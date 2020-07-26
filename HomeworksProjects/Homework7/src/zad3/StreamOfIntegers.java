package zad3;

/*
Генерирайте списък от 20 произволни числата в интервала 0 до 30.
Създайте стрийм от тези числа. Отпечатайте срийма.
Намерете дали са изпълнени следните условия за елементите на стрийма.
- Има ли сред тях число, което се дели на 5
- Дали всички числа са по-малки от 15
- Дали броят на числата по-големи от средната стойност на всички елементи е по-голям от 5
*/

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class StreamOfIntegers {
    public static void main(String[] args) {

        boolean matched;
        List<Integer> intList;
        Random generator;

        intList = new ArrayList<>();
        generator = new Random();

        for(int i = 0; i < 20; i++){
            intList.add(generator.nextInt(31));
        }

        System.out.print("Списък от 20 произволни числата в интервала [0, 30]: ");
        intList.stream() .forEach(x -> System.out.print(x + " "));

        matched = intList.stream().anyMatch(x -> x % 5 == 0);
        System.out.printf("%nИма ли число, което се дели на 5? - %s", matched ? "Да" : "Не");

        matched = intList.stream().allMatch(x -> x < 15);
        System.out.printf("%nВсички числа ли са по-малки от 15? - %s", matched ? "Да" : "Не");

        double averageValue = intList.stream().mapToInt(x -> x).average().orElse(0.0);
        long countOfGreaterElements = intList.stream().filter(x -> x > averageValue).count();
        System.out.printf("%nБроят на числата по-големи от средната стойност %.2f на всички елементи по-голям ли е от 5? - %s", averageValue, countOfGreaterElements > 5 ? "Да" : "Не");
    }
}
