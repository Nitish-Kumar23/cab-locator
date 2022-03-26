package Interfaces;

import Entity.CabDriver;

public interface CabLocationService {
    CabDriver getValidCab(Integer rideTakerId);
}
