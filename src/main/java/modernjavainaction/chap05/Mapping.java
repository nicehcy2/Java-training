package modernjavainaction.chap05;

import modernjavainaction.chap04.Dish;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static modernjavainaction.chap04.Dish.menu;

public class Mapping {

    public static void main(String[] args) {

        System.out.println("스트림의 각 요소에 함수 적용하기(map)");
        List<String> dishNames = menu.stream()
                .map(Dish::getName)
                .toList();
        dishNames.forEach(System.out::println);

        List<String> words = Arrays.asList("Modern", "Java", "In", "Action");
        List<Integer> wordLengths = words.stream()
                .map(String::length)
                .toList();
        wordLengths.forEach(System.out::println);

        System.out.println("스트림 평면화(flat map)");
        List<String> list = words.stream()
                .map(word -> word.split("")) // 각 단어를 개별 문자를 포함하는 배열로 변환
                .flatMap(Arrays::stream) // 생성된 스트림을 하나의 스트림으로 평면화
                .toList();
        list.forEach(System.out::println);

        System.out.println("퀴즈 5-2 1번 문제");
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> squares = numbers.stream()
                .map(n -> n * n)
                .toList();
        squares.forEach(System.out::println);

        System.out.println("퀴즈 5-2 2번 문제");
        List<Integer> numbers1 = Arrays.asList(1, 2, 3);
        List<Integer> numbers2 = Arrays.asList(3, 4);
        List<int[]> pairs = numbers1.stream()
                .flatMap(i -> numbers2.stream()
                        .map(j -> new int[]{i, j}))
                .toList();
        pairs.forEach(num -> System.out.println("(" + num[0] + ", " + num[1] + ")"));

        System.out.println("퀴즈 5-2 3번 문제");
        List<int[]> pairs2 = numbers1.stream()
                .flatMap(i -> numbers2.stream()
                        .filter(j -> (i + j) % 3 == 0)
                        .map(j -> new int[]{i, j}))
                .toList();
        pairs2.forEach(num -> System.out.println("(" + num[0] + ", " + num[1] + ")"));
    }
}
