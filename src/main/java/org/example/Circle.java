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

    public Circle(double radius) {
        this(radius, 1, 1);
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

    public Circle setRadius(double radius) {
        this.radius = radius;
        return this;
    }

    public Circle setLine(int line) {
        this.line = line;
        return this;
    }

    public Circle setColor(int color) {
        this.color = color;
        return this;
    }
}
