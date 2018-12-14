package com.zxb.effective.chapter02.example01;

/**
 * @author Mr.zxb
 * @date 2018-12-12 17:51
 */
public class Point {

    private final int x;
    private final int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object obj) {
//        if (!(obj instanceof  Point)) {
//            return false;
//        }
        if (obj == null || obj.getClass() == getClass()) {
            return false;
        }
        Point p = (Point) obj;
        return p.x == x && p.y == y;
    }
}
