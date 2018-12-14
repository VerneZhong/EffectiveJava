package com.zxb.effective.chapter02.example01;

import java.awt.*;

/**
 * 另一种复合模式
 * @author Mr.zxb
 * @date 2018-12-13 15:40
 */
public class ColorPoint2 {

    private final Point point;
    private final Color color;

    public ColorPoint2(int x, int y, Color color) {
        if (color == null) {
            throw new NullPointerException();
        }
        point = new Point(x, y);
        this.color = color;
    }

    /**
     * Returns the point-view of this color point
     * @return
     */
    public Point asPoint() {
        return point;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof ColorPoint2)) {
            return false;
        }
        ColorPoint2 cp = (ColorPoint2) obj;
        return cp.point.equals(point) && cp.color.equals(color);
    }
}
