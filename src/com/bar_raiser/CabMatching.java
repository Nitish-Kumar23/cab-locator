package com.bar_raiser;

import InterfaceImpl.CabLocationServiceImpl;
import Interfaces.CabLocationService;

public class CabMatching {

    public static void main(String[] args) {

        CabLocationService cabLocationService = new CabLocationServiceImpl();
        System.out.println(cabLocationService.getValidCab(1));
    }
}
