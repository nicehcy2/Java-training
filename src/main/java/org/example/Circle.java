package org.example;

public class Circle {
    private double radius;
    private int line;
    private int color;

    // @NoArgsConstructor
    public Circle() {
    }

    // @AllArgsConstructor
    public Circle(double radius, int line, int color) {
        this.radius = radius;
        this.line = line;
        this.color = color;
    }

    public double findArea() {
        return 3.14 * radius * radius;
    }

    // @getter
    public double getRadius() {
        return radius;
    }

    public int getLine() {
        return line;
    }

    public int getColor() {
        return color;
    }
}
