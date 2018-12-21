package com.zxb.effective.chapter03.example05;

/**
 * 形状抽象类
 * @author Mr.zxb
 * @date 2018-12-18 15:01
 */
abstract class AbstractFigure {

    abstract double area();
}

/**
 * 圆
 */
class Circle extends AbstractFigure {

    final double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    double area() {
        return Math.PI * (2 * radius);
    }
}

/**
 * 长方形
 */
class Rectangle extends AbstractFigure {

    final double length;
    final double width;

    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    @Override
    double area() {
        return length * width;
    }
}

/**
 * 正方形（特殊的矩形）
 */
class Square extends Rectangle {

    public Square(double length, double width) {
        super(length, width);
    }
}


