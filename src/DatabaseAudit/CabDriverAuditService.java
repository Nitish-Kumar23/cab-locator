package DatabaseAudit;

import Entity.CabDriver;

import java.util.List;

public interface CabDriverAuditService {
    
    List<CabDriver> getDriverGreaterThanAverageRating(Double averageRating);
}
