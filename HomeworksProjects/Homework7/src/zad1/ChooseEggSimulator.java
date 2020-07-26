package zad1;

/*
Напишете приложение, което да използва симулация за избиране на шоколадово
яйце и да покаже каква е средната цена за изкупуване на шоколадови яйца с 10 различни
картинки.
*/

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ChooseEggSimulator {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        Random generator = new Random();

        final double PRICE_PER_EGG = 0.50;
        double userMoney;
        int countOfEggsToBuy;
        boolean containsAllEggs;
        int userChoice;

        int allEggsCount = 0;
        int allChoicesCount = 0;

        double allEggsMoneySum = 0;

        // използвам ArrayList за съхраняване на цели числа представящи различните яйца
        ArrayList<Integer> allEggs = new ArrayList<>();
        for(int i = 0; i < 10; i ++){
            allEggs.add(i + 1);
        }

        do {
            allChoicesCount++;

            System.out.print("Въведете сумата в лева, с която разполагате: ");
            userMoney = input.nextDouble();

            countOfEggsToBuy = (int) Math.round(userMoney / PRICE_PER_EGG);
            System.out.printf(" -> Можете да изтеглите %d на брой яйца", countOfEggsToBuy);

            // симулиране на тегленето на яйца според парите, които има потребителя
            List<Integer> boughtEggs = IntStream.rangeClosed(1, countOfEggsToBuy)
                    .mapToObj(e -> generator.nextInt(10) + 1)
                    .collect(Collectors.toList());

            System.out.print("\n -> Вие изтеглихте яйцата: ");
            boughtEggs.forEach(e -> System.out.print(e + " "));

            containsAllEggs = boughtEggs.containsAll(allEggs);
            System.out.println(containsAllEggs ? "\n -> Събрали сте картинките на всички анимационни герои :)" : "\n -> Все още нямате картинките на всички анимационни герои :(");

            if(containsAllEggs){
                allEggsCount++;
                allEggsMoneySum += userMoney;
            }

            System.out.println("Разполагате със следния брой картинки за герой: ");
            System.out.printf("%-5s%s%n", "Картинка ", "Брой");
            boughtEggs.stream()
                    .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                    .forEach((egg, count) -> System.out.printf("%-10d%d%n", egg, count));

            System.out.print("Въведете 1 ако искате да продължите с тегленето или 0 в противен случай: ");
            userChoice = input.nextInt();

        }while(userChoice != 0);

        System.out.printf(" -> От всички %d опита, които направихте, в %d от тях събрахте всички картинки.", allChoicesCount, allEggsCount);
        System.out.printf("\n -> Вероятността за успех е: %.2f", (double) allEggsCount/allChoicesCount);
        System.out.printf("\n -> Средната цена, която похарчихте за успешните опити е: %.2f", allEggsCount != 0 ? allEggsMoneySum / allEggsCount : 0);
    }
}
