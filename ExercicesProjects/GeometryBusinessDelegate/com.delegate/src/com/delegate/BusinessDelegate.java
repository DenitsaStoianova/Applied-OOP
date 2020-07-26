package com.delegate;

// da si izbere service

import com.implementator.SelectServiceImpl;
import com.services.SelectService;
import com.services.SortService;

public class BusinessDelegate {

    private SortService businessService;
    private SelectService lookUpService = new SelectServiceImpl();
    private String serviceType;

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public void doTask(Comparable[] arr){
        businessService = lookUpService.getService(serviceType);
        businessService.sortArray(arr);
    }
}
