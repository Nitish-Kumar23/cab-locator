package DatabaseAudit;

import Entity.RideInformation;

import java.util.List;

public interface RideInfoAuditService {
    
    List<RideInformation> getAllRidesByRideTakerId(Integer rideTakerId);
    
}
