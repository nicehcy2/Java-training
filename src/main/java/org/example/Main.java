package org.example;

public class Main {
    public static void main(String[] args) {

        Circle circle = new Circle();
        circle.setLine(1).setRadius(3.14).setColor(1);

        System.out.println(circle.findArea());
    }
}