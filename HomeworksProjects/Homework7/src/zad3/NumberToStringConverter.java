package zad3;

/*
Създайте Stream от последователност от числата от 1 до 100.
Преобразувайте тази последователност в стринг 1#2# … 99#100 като използвате
reduce.Отпечатайте този стринг.
*/

import java.util.stream.IntStream;

public class NumberToStringConverter {
    public static void main(String[] args) {
        IntStream.rangeClosed(1, 100)
                .mapToObj(String::valueOf) // mapToObj(x -> "" + x)
                .reduce((x1, x2) -> x1 + "#" + x2)
                .ifPresent(System.out::println);
    }
}
