package modernjavainaction.chap05;

import modernjavainaction.chap04.Dish;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static modernjavainaction.chap04.Dish.menu;

public class Matching {

    public static void main(String[] args) {

        if (menu.stream().anyMatch(Dish::isVegetarian)) {
            System.out.println("The Menu is (somewhat) vegetarian friendly!!");
        }

        boolean isHealthy = menu.stream()
                .allMatch(dish -> dish.getCalories() < 1000);
        System.out.println("is this food healthy? : " + isHealthy);

        System.out.println("요소 검색 및 Optional");
        Optional<Dish> dish = menu.stream()
                .filter(Dish::isVegetarian)
                .findAny();
        System.out.println("findAny()의 값: " + dish.orElse(new Dish("null", false, 0, Dish.Type.MEAT)));

        List<Integer> someNumber = Arrays.asList(1, 2, 3, 4, 5);
        Optional<Integer> firstSquareDivisibleByThree = someNumber.stream()
                .map(n -> n * n)
                .filter(n -> n % 3 == 0)
                .findFirst();
        System.out.println(firstSquareDivisibleByThree.orElse(0));;
    }
}
