package modernjavainaction.chap05;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static modernjavainaction.chap04.Dish.menu;

public class Reducing {

    public static void main(String[] args) {

        System.out.println("reducing 연산");
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        int sum = numbers.stream().reduce(0, (a, b) -> a + b);
        int product = numbers.stream().reduce(0, (a, b) -> a * b);
        System.out.println(sum);
        System.out.println(product);

        Optional<Integer> max = numbers.stream().reduce(Integer::max);
        Optional<Integer> min = numbers.stream().reduce(Integer::min);
        System.out.println(max.orElse(0));
        System.out.println(min.orElse(0));

        System.out.println("퀴즈 5-3");
        Optional<Integer> count = menu.stream()
                .map(i -> 1)
                .reduce(Integer::sum);

        System.out.println(count.orElse(0));
    }
}
