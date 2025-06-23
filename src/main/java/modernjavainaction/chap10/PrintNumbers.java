package modernjavainaction.chap10;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class PrintNumbers {

    public static void main(String[] args) {

        List<String> numbers = Arrays.asList("one", "two", "three");

        // 문법상 필요한 코드(추상 클래스의 메서드를 오버라이딩하여 구현) 때문에 잡음이 많다.
        numbers.forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        });

        // 람다로 잡음을 줄임
        System.out.println("Lambda expression:");
        numbers.forEach(s -> System.out.println(s));

        // 메서드 참조로 잡음을 더 줄임. 자바의 새로운 API는 강력한 작은 DSL이다.
        System.out.println("Method reference:");
        numbers.forEach(System.out::println);
    }
}
