package modernjavainaction.chap05;

import modernjavainaction.chap04.Dish;
import static modernjavainaction.chap04.Dish.menu;

import java.util.Arrays;
import java.util.List;

public class Filtering {

    public static void main(String[] args) {

        // 5.1.1 Predicate로 필터링
        System.out.println("Filtering with a predicate");
        List<Dish> vegetarianMenu = menu.stream()
                .filter(Dish::isVegetarian)
                .toList();
        vegetarianMenu.forEach(System.out::println);

        // 5.1.2 고유 요소 필터링 (중복을 필터링)
        System.out.println("Filtering unique elements:");
        List<Integer> numbers = Arrays.asList(1, 2, 1, 3, 3, 2, 4);
        numbers.stream()
                .filter(i -> i % 2 == 0)
                .distinct()
                .forEach(System.out::println);

        // 스트림 슬라이스
        List<Dish> specialMenu = Arrays.asList(
                new Dish("season fruit", true, 120, Dish.Type.OTHER),
                new Dish("prawns", false, 300, Dish.Type.FISH),
                new Dish("rice", true, 350, Dish.Type.OTHER),
                new Dish("chicken", false, 400, Dish.Type.MEAT),
                new Dish("french fries", true, 530, Dish.Type.OTHER));

        System.out.println("takeWhile 연산으로 참일 때 스트림을 받는다");
        List<Dish> slicedMenu1 = specialMenu.stream()
                .takeWhile(dish -> dish.getCalories() < 320) // 거짓이면 연산을 종료(참인 동안만 스트림을 받는다)
                .toList();
        slicedMenu1.forEach(System.out::println);

        System.out.println("dropWhile 연산으로 거짓일 때 스트림을 받는다");
        List<Dish> slicedMenu2 = specialMenu.stream()
                .dropWhile(dish -> dish.getCalories() < 320) // 참이면 연산을 종료(거짓인 동안만 스트림을 받는다)
                .toList();
        slicedMenu2.forEach(System.out::println);

        System.out.println("스트림의 크기를 줄인다");
        List<Dish> dishes = specialMenu.stream()
                .filter(dish -> dish.getCalories() > 300)
                .limit(3)
                .toList();
        dishes.forEach(System.out::println);

        System.out.println("요소를 건너 뛴다");
        List<Dish> dishes2 = specialMenu.stream()
                .filter(d -> d.getCalories() > 300)
                .skip(2)
                .toList();
        dishes2.forEach(System.out::println);
    }
}
