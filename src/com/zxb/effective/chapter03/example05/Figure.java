package com.zxb.effective.chapter03.example05;

/**
 * 类层次优先于标签类
 * @author Mr.zxb
 * @date 2018-12-18 14:29
 */
public class Figure {

    enum Shape {
        RECTANGLE, CIRCLE
    }

    final Shape shape;

    double length;
    double width;

    double radius;

    public Figure(double radius) {
        this.shape = Shape.CIRCLE;
        this.radius = radius;
    }

    public Figure(double length, double width) {
        this.shape = Shape.RECTANGLE;
        this.length = length;
        this.width = width;
    }

    double area() {
        switch (shape) {
            case RECTANGLE:
                return length * width;
            case CIRCLE:
                return Math.PI * (radius * 2);
            default:
                throw new AssertionError();
        }
    }
}
