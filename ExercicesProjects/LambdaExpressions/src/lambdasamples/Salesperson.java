/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lambdasamples;


import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;


@FunctionalInterface
interface Adder<T extends Salesperson> {
    T add(T op1, T op2);

    default String printNumSales(T obj) {
        return "Adder " + obj.getNumSales();
    }

    static void printSales(Salesperson s) {
        System.out.println(s.getNumSales());
    }
}

public class Salesperson implements Adder<Salesperson> {
    private String name;
    private double salary;
    private int numsales;

    public Salesperson(String name, double salary, int numsales) {
        this.name = name;
        this.salary = salary;
        this.numsales = numsales;
    }

    public void addBonus(double amount) {
        salary += amount;
    }

    public int getNumSales() {
        return numsales;
    }

    public double getSalary() {
        return salary;
    }

    public String printNumSales(Salesperson obj) {

        return String.format("%s Sales: %d", Adder.super.printNumSales(obj),
                obj.getNumSales());
    }

    public static Set<Salesperson> distinct(List<Salesperson> list) {
        return new HashSet<>(list);
    }

    @Override
    public boolean equals(Object obj){
        if(obj == null){
            return false;
        }

        if(!(obj instanceof Salesperson)){
            return false;
        }

        return this.name.equals(((Salesperson) obj).name);
    }

    @Override
    public int hashCode(){
        return name.hashCode();
    }

    @Override
    public String toString() {
        return String.format("name: %s, salary: %.2f numsales: %d ",
                name, salary, numsales);
    }

    @Override
    public Salesperson add(Salesperson op1, Salesperson op2) {
        return new Salesperson(op1.name, op1.salary, op1.numsales + op2.numsales); //To change body of generated methods, choose Tools | Templates.
    }
}

class LambdaDemo {
    public static void main(String[] args) {

        Predicate<Salesperson> predicate1 = s -> s.getNumSales() > 1200;
        Predicate<Salesperson> predicate2 = s -> s.getSalary() > 900;
        Predicate<Salesperson> predicate = s -> predicate1.test(s) || predicate2.test(s);

        Consumer<Salesperson> consumer1 = s -> {
            s.addBonus(s.getSalary() * 0.05);
            System.out.println(s);
        };

        Consumer<Salesperson> consumer2 = s -> {
            if (predicate1.test(s)) {
                s.addBonus(s.getSalary() * 0.02);
            } else {
                s.addBonus(-s.getSalary() * 0.02);
            }
            System.out.println(s);
        };

        Comparator<Salesperson> comparator1 = (s1, s2) -> {
            if(s1.getSalary() == s2.getSalary()){
                return 0;
            }
            if(s1.getSalary() > s2.getSalary()){
                return -1;
            }
            return 1;
        };

        Comparator<Salesperson> comparator2 = (s1, s2) -> {
            int result = comparator1.compare(s1, s2);
            if(result == 0){ // sort ascending
                return  s1.getNumSales() - s2.getNumSales();
            }
            return result;
        };

        Random generator = new Random();
        Salesperson[] salespersons =
                {
                        new Salesperson("John Doe", generator.nextInt(7001), generator.nextInt(1001)),
                        new Salesperson("John Doe", generator.nextInt(7001), generator.nextInt(1001)),
                        new Salesperson("Jim Donovan", generator.nextInt(7001), generator.nextInt(1001)),
                        new Salesperson("Jake Smith", generator.nextInt(7001), generator.nextInt(1001)),
                        new Salesperson("Donna Doe", generator.nextInt(7001), generator.nextInt(1001)),
                        new Salesperson("Harry Donovan", generator.nextInt(7001), generator.nextInt(1001)),
                        new Salesperson("Kate Dave", generator.nextInt(7001), generator.nextInt(1001)),
                        new Salesperson("Kim Smith", generator.nextInt(7001), generator.nextInt(1001)),
                        new Salesperson("Jenny Doe", generator.nextInt(7001), generator.nextInt(1001)),
                        new Salesperson("Jenny Doe", generator.nextInt(7001), generator.nextInt(1001))
                };

        System.out.println(salespersons[0].printNumSales(salespersons[1]));

        List<Salesperson> listOfSalespersons = new ArrayList<>(Arrays.asList(salespersons));
        for (Salesperson salesperson : salespersons) {
            applyBonus(salesperson, predicate1, consumer1);
            System.out.println(salesperson);
            salesperson.printNumSales(salesperson);

        }
        for (Salesperson salesperson : salespersons) {
            applyBonus(salesperson, predicate2, consumer2);
            System.out.println(salesperson);
        }
        sort(listOfSalespersons, comparator1);
        System.out.println(listOfSalespersons);

        sort(listOfSalespersons, comparator2);
        System.out.println(listOfSalespersons);

        Set<Salesperson> salespersonSet = Salesperson.distinct(listOfSalespersons);
        System.out.println(salespersonSet);
    }

    public static void applyBonus(Salesperson salesperson,
                                  Predicate<Salesperson> predicate,
                                  Consumer<Salesperson> consumer) {
        if(predicate.test(salesperson)){
            consumer.accept(salesperson);
        }
    }

    public static void applyBonus(List<Salesperson> salespersons,
                                  Predicate<Salesperson> predicate,
                                  Consumer<Salesperson> consumer) {
        for(Salesperson salesperson : salespersons){
            applyBonus(salesperson, predicate, consumer);
        }
    }

    public static void sort(List<Salesperson> salespersons,
                            Comparator<Salesperson> comparator) {
        salespersons.sort(comparator);
    }

}

