package zad1;

/*
Пред кварталния магазин има игрален автомат за деца, където срещу 50ст се избира
шоколадово яйце, в което има картинка на герой от 10 анимационни филми.Едно дете
иска да си направи албум с картинките на всичките му любими герои, но има само 7
лева.
*/

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ChooseEgg {
    public static void main(String[] args) {

        // ArrayList, който съхранява цели числа, представящи десетте картинки на герои от анимационни филми
        ArrayList<Integer> allEggs = new ArrayList<>();
        for(int i = 0; i < 10; i ++){
            allEggs.add(i + 1);
        }

        final double PRICE_PER_EGG = 0.50;
        double childMoney = 7.00;
        int countOfEggsToBuy = (int) Math.round(childMoney / PRICE_PER_EGG); // 14
        Random generator = new Random();

        // симулиране на тегленето на яйца според парите, които има детето
        List<Integer> boughtEggs = IntStream.rangeClosed(1, countOfEggsToBuy)
                .mapToObj(e -> generator.nextInt(10) + 1)
                .collect(Collectors.toList());

        System.out.print("Номер на картинката на яйцата, които е изтеглило детето за 7 лв: ");
        boughtEggs.forEach(e -> System.out.print(e + " "));

        // проверка дали яйцата, които е изтеглило детето съдържат всичките 10 картинки на герои от анимационни филми
        boolean containsAllEggs = boughtEggs.containsAll(allEggs);
        System.out.printf("%nМоже ли детето да си направи албум с картинките на всичките му любими герои? - %s", containsAllEggs ? "Да": "Не");
    }
}
