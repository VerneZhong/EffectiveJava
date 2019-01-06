package com.zxb.effective.chapter05.example01;

/**
 * @author Mr.zxb
 * @date 2019-01-06 15:14:04
 */
public class WeightTable {

    public static void main(String[] args) {

        double earthWeight = Double.parseDouble("175");
        double mass = earthWeight / Planet.EARTH.getSurfaceGravity();
        for (Planet p : Planet.values()) {
            System.out.printf("Weight on %s is %f%n", p, p.getSurfaceGravity(mass));
        }
    }
}
