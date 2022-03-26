package DatabaseAudit;

import Entity.CabDriver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CabDriverAuditServiceImpl implements CabDriverAuditService {

    //create drivers object
    static CabDriver driver1 = new CabDriver(1,"Bheem",3.667,3);
    static CabDriver driver2 = new CabDriver(2, "Nakul",3.5,2);
    static CabDriver driver3 = new CabDriver(3, "Sahadev",2.5,2);
    static ArrayList<CabDriver> cabDrivers = new ArrayList<>();

    static {
        cabDrivers.add(driver1);
        cabDrivers.add(driver2);
        cabDrivers.add(driver3);
    }

    @Override
    public List<CabDriver> getDriverGreaterThanAverageRating(Double averageRating) {
        return cabDrivers.stream().filter(cabDriver -> cabDriver.getAverageRating()>averageRating).sorted(CabDriver::compareTo).collect(Collectors.toList());
    }
}
