package com.implementator;

import com.services.SelectService;
import com.services.SortService;

public class SelectServiceImpl implements SelectService {
    @Override
    public SortService getService(String serviceType) {
        if(serviceType.equalsIgnoreCase("insertion")){
            return new InsertionSortServiceImpl();
        }
        return new SelectionSortServiceImpl();
    }
}
