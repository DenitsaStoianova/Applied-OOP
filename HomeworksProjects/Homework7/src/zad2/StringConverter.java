package zad2;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
Създайте Stream от "aBc", "d", "ef", "123456". Преобразувайте елементите в стрийма в
главни букви, сортирайте ги във възходящ ред и ги запазете в списък. Отпечатайте елементите на
така получения списък.
 */

public class StringConverter {
    public static void main(String[] args) {
        List<String> list = Stream.of("aBc", "d", "ef", "123456")
                .map(String::toUpperCase)
                .sorted()
                .collect(Collectors.toList());

        System.out.println("Result: " + list);
    }
}
