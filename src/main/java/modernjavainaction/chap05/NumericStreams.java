package modernjavainaction.chap05;

import modernjavainaction.chap04.Dish;

import java.util.Arrays;
import java.util.OptionalInt;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static modernjavainaction.chap04.Dish.menu;

public class NumericStreams {

    public static void main(String[] args) {

        System.out.println("기본형 특화 스트림");
        int calories = menu.stream()
                .mapToInt(Dish::getCalories) // IntStream 반환 (Stream<Integer>가 아님)
                .sum();
        System.out.println(calories);

        System.out.println("객체 스트림 복원하기");
        IntStream intStream = menu.stream().mapToInt(Dish::getCalories);
        Stream<Integer> stream = intStream.boxed();
        stream.forEach(System.out::println);

        System.out.println("OptinalInt");
        OptionalInt maxCalories = menu.stream()
                .mapToInt(Dish::getCalories)
                .max();
        System.out.println(maxCalories.orElse(1));

        System.out.println("숫자 범위");
        IntStream evenNumbers = IntStream.rangeClosed(1, 100);
        System.out.println(evenNumbers.count());

        System.out.println("피타고라스");
        Stream<int[]> pythagoreanTriples = IntStream.rangeClosed(1, 100).boxed()
                .flatMap(a ->
                        IntStream.rangeClosed(1, 100)
                                .filter(b -> Math.sqrt(a * a + b * b) % 1.0 == 0)
                                .mapToObj(b -> new int[]{a, b, (int) Math.sqrt((a * a + b * b))})
                );
        pythagoreanTriples.distinct().forEach(idx ->
                System.out.println(idx[0] + ", " + idx[1] + ", " + idx[2]));
    }
}
