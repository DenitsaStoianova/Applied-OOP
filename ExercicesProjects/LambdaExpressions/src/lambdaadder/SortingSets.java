package lambdaadder;

import java.util.Comparator;
import java.util.SortedSet;
import java.util.TreeSet;

public class SortingSets {

    public static SortedSet<Integer>  sort(int[] data, Comparator<Integer> sortOrder){
        SortedSet<Integer> set = new TreeSet(sortOrder);
        //set.addAll(Arrays.asList(data)); type is int - primitive
        for(int i = 0; i < data.length; i++){
            set.add(data[i]);
        }
        return set;
    }
}
