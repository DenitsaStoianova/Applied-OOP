package com.implementator;

import com.services.SortService;

public class SelectionSortServiceImpl implements SortService {

    @Override
    public void sortArray(Comparable[] arr) {
        int smallest;

        for(int i = 0; i < arr.length - 1; i++){
            smallest = i;
            for(int j = i + 1; j < arr.length; j++){
                if(arr[j].compareTo(arr[smallest]) < 0){
                    smallest = j;
                }
            }

            if(smallest != i){
                Comparable temp = arr[i];
                arr[i] = arr[smallest];
                arr[smallest] = temp;
            }
        }
    }
}
