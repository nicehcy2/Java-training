package modernjavainaction.chap02;

import modernjavainaction.chap03.Apple;
import modernjavainaction.chap03.Color;

import java.util.*;
import java.util.function.Predicate;

import static modernjavainaction.chap03.Color.*;

public class FilteringApples {

    public static void main(String[] args) {

        List<Apple> inventory = Arrays.asList(
                new Apple(80, GREEN),
                new Apple(155, GREEN),
                new Apple(120, RED));
        prettyPrintApple(inventory, new AppleFancyFormatter());

        /**
         * 익명 클래스 사용
         */
        List<Apple> redApples = filterApples(inventory, new ApplePredicate() {
            @Override
            public boolean test(Apple apple) {
                return RED.equals(apple.getColor());
            }
        });

        /**
         * 람다 표현식 사용
         */
        List<Apple> result = filterApples(inventory, (Apple apple) -> RED.equals(apple.getColor()));

        inventory.sort(new Comparator<Apple>() {
            @Override
            public int compare(Apple o1, Apple o2) {
                return ((Integer) o1.getWeight()).compareTo(o2.getWeight());
            }
        });

        inventory.sort((a1, a2)
                -> ((Integer) a1.getWeight()).compareTo(a2.getWeight()));
    }

    /**
     * 초록색 사과만 필터링 가능
     * @param inventory
     * @return
     */
    static List<Apple> filterGreenApples(List<Apple> inventory) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if (GREEN.equals(apple.getColor())) {
                result.add(apple);
            }
        }
        return result;
    }

    /**
     * 매개변수로 입력된 색으로 사과 필터링 가능
     * @param inventory
     * @param color
     * @return
     */
    static List<Apple> filterApplesByColor(List<Apple> inventory, Color color) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if (apple.getColor().equals(color)) {
                result.add(apple);
            }
        }
        return result;
    }

    /**
     * 무게를 기준으로 사과 필터링 가능
     * @param inventory
     * @param weight
     * @return
     */
    static List<Apple> filterApplesByWeight(List<Apple> inventory, int weight) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if (apple.getWeight() > weight) {
                result.add(apple);
            }
        }
        return result;
    }

    /**
     * 플래그를 사용해서 가능한 모든 속성으로 필터링(제일 형편없는 코드)
     * @param inventory
     * @param color
     * @param weight
     * @param flag
     * @return
     */
    static List<Apple> filterApples(List<Apple> inventory, Color color, int weight, boolean flag) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if ((flag && apple.getColor().equals(color)) ||
                    (!flag && apple.getWeight() > weight)) {
                result.add(apple);
            }
        }
        return result;
    }

    /**
     * 추상적 조건으로 필터링
     * ApplePredicate는 사과 선택 전략을 캡슐화 한다. => 전략 디자인 패턴
     * ApplePredicate를 만들어서 filterApples 메서드로 전달할 수 있다.
     * filterApples 메서드의 동작을 파라미터화 했다.
     * @param inventory
     * @param p 동작 파라미터화, 즉 메서드가 다양한 동작(또는 전략)을 받아서 내부적으로 다양한 동작을 수행할 수 있다.
     * @return
     */
    static List<Apple> filterApples(List<Apple> inventory, ApplePredicate p) {
        List<Apple> result = new ArrayList<>();
        for(Apple apple : inventory) {
            if (p.test(apple)) { // 프레디게이트 객체로 사과 검사 조건을 캡슐화
                result.add(apple);
            }
        }
        return result;
    }

    static class AppleRedAndHeavyPredicate implements ApplePredicate {
        @Override
        public boolean test(Apple apple) {
            return RED.equals(apple.getColor()) && apple.getWeight() > 150;
        }
    }

    static class AppleGreenColorPredicate implements ApplePredicate {
        @Override
        public boolean test(Apple apple) {
            return GREEN.equals(apple.getColor());
        }
    }

    /**
     * 다양한 방법으로 문자열을 생성(커스터마이즈된 다양한 toString 메서드와 같이)할 수 있도록 파라미터화됨.
     * @param inventory
     */
    static void prettyPrintApple(List<Apple> inventory, AppleFormatter f) {
        for (Apple apple : inventory) {
            String output = f.accept(apple);
            System.out.println(output);
        }
    }

    static class AppleFancyFormatter implements AppleFormatter {
        @Override
        public String accept(Apple a) {
            return "An apple of " + a.getWeight() + "g";
        }
    }

    /**
     * 리스트 형식으로 추상화, 제네릭 프로그래밍
     * @param list
     * @param p
     * @return
     * @param <T>
     */
    static <T> List<T> filter(List<T> list, Predicate<T> p) {
        List<T> result = new ArrayList<>();
        for(T e : list) {
            if (p.test(e)) {
                result.add(e);
            }
        }
        return result;
    }
}