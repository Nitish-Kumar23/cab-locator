package InterfaceImpl;

import DatabaseAudit.*;
import Entity.CabDriver;
import Entity.RideInformation;
import Entity.RideTaker;
import Exceptions.CabMatchingException;
import Exceptions.ErrorCodes;
import Interfaces.CabLocationService;

import java.util.*;

public class CabLocationServiceImpl implements CabLocationService {

    private RiderAuditService riderAuditService = new RiderAuditServiceImpl();

    private CabDriverAuditService cabDriverAuditService = new CabDriverAuditServiceImpl();

    private RideInfoAuditService rideInfoAuditService = new RideInfoAuditServiceImpl();

    @Override
    public CabDriver getValidCab(Integer rideTakerId) {
        RideTaker rider = riderAuditService.getRiderById(1);
        if(rider==null){
            throw new CabMatchingException(ErrorCodes.INVALID_RIDER,ErrorCodes.INVALID_RIDER.getMessage());
        }
        CabDriver cabDriver = getValidCabDriver(rideTakerId, rider.getAverageRating());
        if (cabDriver == null) {
            throw new CabMatchingException(ErrorCodes.NO_CAB_FOUND, ErrorCodes.NO_CAB_FOUND.getMessage());
        }
        return cabDriver;
    }

    private CabDriver getValidCabDriver(Integer rideTakerId, Double rideTakerRating) {
        //list of all drivers having rating greater than customers
        List<CabDriver> driverList = cabDriverAuditService.getDriverGreaterThanAverageRating(rideTakerRating);
        //list of all rides taken by rider
        List<RideInformation> rideInformationList = rideInfoAuditService.getAllRidesByRideTakerId(rideTakerId);
        Map<Integer, List<Double>> driverIdVsRideInfoMap = getDriverRatingsMap(rideInformationList);

        return getValidCabDriver(driverList, driverIdVsRideInfoMap);

    }

    private CabDriver getValidCabDriver(List<CabDriver> driverList, Map<Integer, List<Double>> driverIdVsRideInfoMap) {
        for (CabDriver driver : driverList) {
            if (driverIdVsRideInfoMap.containsKey(driver.getId())) {
                List<Double> ratings = driverIdVsRideInfoMap.get(driver.getId());
                //if rating is 1 then we cannot assign that driver
                if (ratings.contains(1.0)) {
                    continue;
                }
            }
            return driver;
        }
        return null;
    }

    private Map<Integer, List<Double>> getDriverRatingsMap(List<RideInformation> rideInformationList) {
        Map<Integer, List<Double>> driverIdVsRideInfoMap = new HashMap<>();
        for (RideInformation rideInformation : rideInformationList) {
            Integer driverId = rideInformation.getDriverId();
            if (driverIdVsRideInfoMap.containsKey(driverId)) {
                List<Double> ratings = driverIdVsRideInfoMap.get(driverId);
                ratings.add(rideInformation.getDriverRating());
                driverIdVsRideInfoMap.put(driverId, ratings);
            } else
                driverIdVsRideInfoMap.put(driverId, new ArrayList<>(Arrays.asList(rideInformation.getDriverRating())));
        }
        return driverIdVsRideInfoMap;
    }
}
