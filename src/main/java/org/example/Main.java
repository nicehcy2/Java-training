package org.example;

public class Main {
    public static void main(String[] args) {

        // stringTestMethod();
        // varArgsTest(1, 2, 3, 4, 5);
        // System.out.println(ResponseCode.NOT_FOUND);
        // mathTest();

        // stringBuilderTest();
    }

    private static void stringBuilderTest() {

        StringBuilder sb = new StringBuilder("hi");
        sb.append("!");
        sb.insert(0, "Hello, ");
        sb.replace(0, 5, "JAVA").reverse();

        System.out.println(sb);
    }

    private static void mathTest() {
        System.out.println("Math.pow(2, 8) : " + Math.pow(2.0, 8.1));
        System.out.println("10과 5 중 더 큰 수 : " + Math.max(10.0, 5));
        System.out.println("10과 5 중 더 작은 수 : " + Math.min(10, 5));
        System.out.println("-1의 절댓값 : " + Math.abs(-1));
        System.out.println("0.0이상 1.0 미만의 난수: " + Math.random());
        System.out.println("4의 제곱근 값 : " + Math.sqrt(4.0));
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