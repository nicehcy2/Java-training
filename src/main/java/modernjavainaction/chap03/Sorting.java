package modernjavainaction.chap03;

import java.util.*;

import static java.util.Comparator.comparing;

public class Sorting {

    public static void main(String[] args) {

        // list 생성 및 초기화
        List<Apple> inventory = new ArrayList<>();
        inventory.addAll(Arrays.asList(
                new Apple(80, Color.GREEN),
                new Apple(155, Color.GREEN),
                new Apple(120, Color.RED)
        ));

        // 1. 동작 파라미터화
        // 함수형 인터페이스를 구현하고 구현체(객체)를 인수로 받아 비교
        // 객체 안에 동작을 포함시키는 방식(코드 전달)
        inventory.sort(new AppleComparator());
        System.out.println(inventory);

        inventory.set(1, new Apple(30, Color.GREEN));

        // 2. 익명 클래스
        // 별도의 명명된 클래스를 구현하지 않아도 된다.
        inventory.sort(new Comparator<Apple>() {
            @Override
            public int compare(Apple o1, Apple o2) {
                return o1.getWeight() - o2.getWeight();
            }
        });
        System.out.println(inventory);

        inventory.set(1, new Apple(20, Color.RED));

        // 3. 람다 표현식 사용
        inventory.sort((a1, a2) -> a1.getWeight() - a2.getWeight());
        System.out.println(inventory);

        inventory.set(1, new Apple(10, Color.RED));

        // 4. 메서드 참조
        inventory.sort(comparing(apple -> apple.getWeight()));
        inventory.sort(comparing(Apple::getWeight));
        System.out.println(inventory);
    }

    static class AppleComparator implements Comparator<Apple> {

        @Override
        public int compare(Apple a1, Apple a2) {
            return a1.getWeight() - a2.getWeight();
        }
    }
}
