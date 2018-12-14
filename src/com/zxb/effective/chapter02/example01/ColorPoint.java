package com.zxb.effective.chapter02.example01;

import java.awt.*;

/**
 * @author Mr.zxb
 * @date 2018-12-12 17:52
 */
public class ColorPoint extends Point {

    private final Color color;

    public ColorPoint(int x, int y, Color color) {
        super(x, y);
        this.color = color;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Point)) {
            return false;
        }
        if (!(obj instanceof ColorPoint)) {
            // 不比较颜色
            return super.equals(obj);
        }
        // 该做法提供了对称性，却牺牲了传递性
        return super.equals(obj) && ((ColorPoint) obj).color == color;
    }

    public static void main(String[] args) {
        Point p = new Point(1, 2);

        ColorPoint cp = new ColorPoint(1, 2, Color.RED);

        System.out.println(p.equals(cp));
        System.out.println(cp.equals(p));

        System.out.println("--------------");
        ColorPoint p3 = new ColorPoint(1, 2, Color.BLUE);
        System.out.println(cp.equals(p));
        System.out.println(p.equals(p3));
        // 违反了传递性，p1.equals(p2)->true,p2.equals(p3)->true,p1.equals(p3)->false
        System.out.println(cp.equals(p3));
    }
}
