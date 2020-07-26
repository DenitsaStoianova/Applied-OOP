package com.implementator;

import com.services.SortService;

public class InsertionSortServiceImpl implements SortService {
    @Override
    public void sortArray(Comparable[] arr) {
        Comparable element;

        for(int i = 1; i < arr.length; i++){
            element = arr[i];
            int index = i;

            while(index > 0 && arr[index - 1].compareTo(element) > 0){
                arr[index] = arr[index - 1];
                index--;
            }
            arr[index] = element;
        }
    }
}
