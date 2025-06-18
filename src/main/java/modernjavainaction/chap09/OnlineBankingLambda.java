package modernjavainaction.chap09;

import java.util.function.Consumer;

/**
 * 템플릿 메서드 패턴(Template Method Pattern)
 * 알고리즘의 구조는 상위 클래스에서 정의하고, 알고리즘의 일부 단계는 하위 클래스에서 구체화하도록 만든 패턴
 * * 상위 클래스(추상 클래스)는 고정된 흐름을 정의한 템플릿 메서드를 제공
 * * 하위 클래스는 그 흐름 중 일부를 오버라이딩하여 원하는 동작을 구현
 *
 * * 이 방식은 전통적인 템플릿 메서드 패턴은 아니고 람다를 활용한 템플릿 메서드 패턴이다.
 * 함수형 인터페이스를 인자로 전달하고 인자로 람다만 전달하기에 추상 메서드를 오버라이딩 하지 않아도 된다.
 */
public class OnlineBankingLambda {

    public static void main(String[] args) {
        new OnlineBankingLambda().processCustomer(1337, (Customer c) -> System.out.println("Hello!"));
    }

    public void processCustomer(int id, Consumer<Customer> makeCustomerHappy) {
        Customer c = Database.getCustomerWithId(id);
        makeCustomerHappy.accept(c);
    }

    // 더미 Customer 클래스
    static private class Customer {}

    // 더미 Database 클래스
    static private class Database {

        static Customer getCustomerWithId(int id) {
            return new Customer();
        }

    }
}
