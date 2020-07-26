package lambdaadder;

import java.util.Scanner;
import java.util.function.BiFunction;

@FunctionalInterface
interface IntAdder{
    Integer add(Integer a, Integer b);
}
@FunctionalInterface
interface StringAdder{
    String add(String a, String b);
}
@FunctionalInterface
interface DoubleAdder{
    Double add(Double a, Double b);
}

@FunctionalInterface
interface Adder<T>{
    T add(T a, T b);
}

public class LambdaTest {

    public static IntAdder getIntAdder(){
        return new IntAdder() {
            @Override
            public Integer add(Integer a, Integer b) {
                return a + b;
            }
        };
    }

    public static StringAdder getStringAdder(){
        return new StringAdder() {
            @Override
            public String add(String a, String b) {
                return String.format("%s %s", a, b);
            }
        };
    }

    public static Adder<Double> getDoubleAdder(){
       return new Adder<Double>() {
           @Override
           public Double add(Double a, Double b) {
               Scanner input = new Scanner(System.in);
               System.out.print("Enter number: ");
               double c = input.nextDouble();
               return Math.max(a,Math.max(b,c));
           }
       };
    }

    public static void main(String[] args) {
        IntAdder intAdder = getIntAdder();
        System.out.println(intAdder.add(5,6));

        StringAdder stringAdder = getStringAdder();
        System.out.println(stringAdder.add("Hello", "Java"));

        Adder<Double> doubleAdder = getDoubleAdder();
        System.out.println(doubleAdder.add(6.1,3.9));

        BiFunction<Integer, Integer, Integer> adderInteger = (a,b) -> a + b;
        BiFunction<String, String, String> adderString = (a, b) -> String.format("%s %s", a, b);
        BiFunction<Double, Double, Double> adderDouble = (a, b) -> {
            Scanner input = new Scanner(System.in);
            System.out.print("Enter number: ");
            double c = input.nextDouble();
            return Math.max(a,Math.max(b,c));
        };

        System.out.println(adderInteger.apply(5,6));
        System.out.println(adderString.apply("Hello", "Java"));
        System.out.println(adderDouble.apply(6.1,3.9));
    }

}
