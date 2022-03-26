package DatabaseAudit;

import Entity.RideTaker;

public class RiderAuditServiceImpl implements RiderAuditService {
    
    //it will be fetched by DB call but hardcoding here
    @Override
    public RideTaker getRiderById(Integer riderId) {
        switch (riderId){
            case 1: 
                return new RideTaker(1,"Ram",3.33,3);
            case 2 :
                return new RideTaker(2,"Laxman",4.667,2);
            case 3:
                return new RideTaker(3,"Bharat",4.0,2);
        }
        return null;
    }
}
