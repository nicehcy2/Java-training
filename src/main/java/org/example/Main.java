package org.example;

import org.example.inheritance.Child;
import org.example.inheritance.Parent;

public class Main {
    public static void main(String[] args) {

        Child child1 = new Child("Child", "대학교");

        // 1. 자식 클래스가 부모 클래스의 메서드를 사용 가능.
        // 단, 이 상황에서는 부모 클래스의 필드를 사용. (private, protected 제외)
        // 단, 자식 클래스에서 오버라이딩할 경우 자식 클래스의 메서드를 사용
        child1.printName();

        // 2. 부모 타입의 객체를 자식 타입의 객체로 생성하는 상황.
        // 2.1 업캐스팅: 부모 타입의 참조 변수를 사용하여 자식 클래스 객체를 참조하는 것.
        // 업캐스팅은 자동으로 수행되며, 자식 클래스에서 정의된 메서드나 속성은 부모 타입에서 직접 접근할 수 없다.
        // 다형성을 활용하여 부모 클래스 타입으로 다양한 자식 객체를 처리할 수 있다.
        // Is-A 관계: 자식 클래스의 객체는 부모 클래스의 자료형인 것 처럼 사용가능
        Parent parent1 = new Child("Child", "대학교");
        parent1.printName();

        // 부모 타입에서는 자식 클래스만의 메서드 접근 불가 (업캐스팅이기 때문)
        // parent1.childMethod();

        // 2.2 다운캐스팅: 부모 타입의 참조 변수를 자식 타입으로 변환하는 것.
        // 필요에 따라 자식 클래스의 고유한 기능을 사용할 수 있다.
        if (parent1 instanceof Child) {
            Child child2 = (Child) parent1; // 다운 캐스팅

            // 다운캐스팅 했기에 자식 클래스 메서드 호출 가능
            child2.ChildMethod();
        }

        Parent parent2 = new Parent();
        Child child2 = new Child();
        Parent parent3 = new Child();

        System.out.println("필드 상속 테스트");
        System.out.println(parent2.pub); // Parent
        System.out.println(child2.cPub); // Child Public
        System.out.println(child2.pub); // Child
        // 필드는 메서드와 달리 상속되지 않는다.
        System.out.println(parent3.pub); // Parent
    }
}