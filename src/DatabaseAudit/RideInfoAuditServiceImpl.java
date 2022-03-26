package DatabaseAudit;

import Entity.RideInformation;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RideInfoAuditServiceImpl implements RideInfoAuditService {
    
    static RideInformation ride1 = new RideInformation(123,1,1,3.0,5.0);
    static RideInformation ride2 = new RideInformation(124,2,2,5.0,2.0);
    static RideInformation ride3 = new RideInformation(125,3,1,4.0,2.0);
    static RideInformation ride4 = new RideInformation(126,1,3,3.0,5.0);
    static RideInformation ride5 = new RideInformation(127,1,1,3.0,1.0);
    static RideInformation ride6 = new RideInformation(128,3,2,3.0,3.0);
    static RideInformation ride7 = new RideInformation(129,2,3,5.0,5.0);
    List<RideInformation> rideInformationList = Arrays.asList(ride1,ride2,ride3,ride4,ride5,ride6,ride7);



    @Override
    public List<RideInformation> getAllRidesByRideTakerId(Integer rideTakerId) {
        return rideInformationList.stream().filter(rideInformation -> rideInformation.getRideTakerId()==rideTakerId).collect(Collectors.toList());
    }
}
