package lambdaadder;

import java.util.Comparator;
import java.util.SortedSet;

public class UseSort {
    public static void main(String[] args) {
        int[] numbers = new int[]{6,7,4,3,6,7,4,89,6,77,5,5,7,3};

        //Comparator<Integer> comparator = (a, b) -> a.compareTo(b);
        Comparator<Integer> ascending = Integer::compareTo;

        Comparator<Integer> descending = (a, b) -> b.compareTo(a);

        SortedSet<Integer> ascendingSort = SortingSets.sort(numbers, ascending);
        SortedSet<Integer> descendingSort = SortingSets.sort(numbers, descending);
    }
}
