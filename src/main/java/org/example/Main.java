package org.example;

public class Main {
    public static void main(String[] args) {

        // stringTestMethod();
        // varArgsTest(1, 2, 3, 4, 5);

        System.out.println(ResponseCode.NOT_FOUND);
    }

    /**
     * 자바는 가변 개수 매개변수를 배열로 취급
     * @param a
     * @param v
     */
    private static void varArgsTest(int a, int... v) {

        for(int x : v){
            System.out.println(x);
        }
    }


    private static void stringTestMethod() {

        StringTest stringTest = new StringTest();
        stringTest.print();
    }

    private static void classTestMethod() {

        Circle circle = new Circle();
        Circle circle1 = new Circle();
        Circle circle2 = new Circle();
        circle.setLine(1).setRadius(3.14).setColor(1);

        //Circle.setCount();
        System.out.println("count: " + Circle.count);

        System.out.println(circle.findArea());
    }
}