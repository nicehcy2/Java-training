package modernjavainaction.chap06;

import modernjavainaction.chap04.Dish;

import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

import static modernjavainaction.chap04.Dish.menu;
import static java.util.stream.Collectors.*;
public class Partitioning {

    public static void main(String[] args) {

        System.out.println("분할 함수 개요");
        Map<Boolean, List<Dish>> partitionedMenu =
                menu.stream().collect(partitioningBy(Dish::isVegetarian));
        System.out.println(partitionedMenu);
        System.out.println(partitionedMenu.get(true) + "\n");

        System.out.println("숫자와 소수와 비소수로 분할하기");
        Map<Boolean, List<Integer>> partitionPrime = IntStream.rangeClosed(2, 100).boxed()
                .collect(
                        partitioningBy(candidate -> isPrime(candidate))
                );
        System.out.println(partitionPrime + "\n");
    }

    static boolean isPrime(int candidate) {
        int candidateRoot = (int) Math.sqrt(candidate);
        return IntStream.rangeClosed(2, candidateRoot)
                .noneMatch(i -> candidate % i == 0);
    }
}
