package modernjavainaction.chap06;

import modernjavainaction.chap04.Dish;

import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.Optional;
import java.util.stream.Collectors;

import static modernjavainaction.chap04.Dish.menu;
import static java.util.stream.Collectors.*;
public class Reducing {

    public static void main(String[] args) {

        System.out.println("리듀싱 요약");
        Long howManyDishes = menu.stream().collect(counting());
        howManyDishes = menu.stream().count();
        System.out.println(howManyDishes);

        System.out.println("스트림값에서 최대값과 최소값 검색");
        Comparator<Dish> dishCaloriesComparator = Comparator.comparingInt(Dish::getCalories);
        Optional<Dish> mostCalorieDish = menu.stream().collect(maxBy(dishCaloriesComparator));
        System.out.println(mostCalorieDish.get());

        System.out.println("요약 연산");
        Integer totalCalories = menu.stream().collect(summingInt(Dish::getCalories));
        IntSummaryStatistics menuStatistics = menu.stream().collect(summarizingInt(Dish::getCalories));
        System.out.println(totalCalories);
        System.out.println(menuStatistics);

        System.out.println("문자열 연결");
        String shortMenu = menu.stream().map(Dish::getName).collect(joining(", "));
        System.out.println(shortMenu);
    }
}
