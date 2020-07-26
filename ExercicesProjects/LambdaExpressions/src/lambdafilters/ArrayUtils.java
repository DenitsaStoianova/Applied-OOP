package lambdafilters;

import java.util.Random;
import java.util.function.Predicate;

public class ArrayUtils {

    public static void filterNumbers(Predicate<Integer> condition, int[] array){
        for (int i = 0; i < array.length; i++) {
            if(condition.test(array[i])){
                System.out.println(array[i] + " ");
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = new int[20];
        Random generator = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = generator.nextInt(41) + 10;
        }

        Predicate<Integer> isEven = a -> a % 2 == 0;
        Predicate<Integer> inInterval = a -> a >= 30 && a <= 40;
        Predicate<Integer> isPrime = a -> {
            for(int i = 2; i < a; i++){
                if(a % i == 0 && a != i){
                    return false;
                }
            }
            return true;
        };

        filterNumbers(isEven, arr);
        filterNumbers(inInterval, arr);
        filterNumbers(isPrime, arr);
    }
}
