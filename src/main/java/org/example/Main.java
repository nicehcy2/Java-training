package org.example;

public class Main {
    public static void main(String[] args) {

        Circle circle = new Circle();
        Circle circle1 = new Circle();
        Circle circle2 = new Circle();
        circle.setLine(1).setRadius(3.14).setColor(1);

        //Circle.setCount();
        System.out.println("count: " + Circle.count);

        System.out.println(circle.findArea());
    }
}