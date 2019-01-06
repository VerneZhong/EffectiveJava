package com.zxb.effective.chapter05.example01;

/**
 * Enum type with data and behavior
 * 具有数据和行为的枚举类型
 *
 * @author Mr.zxb
 * @date 2019-01-06 15:01:57
 */
public enum Planet {

    MERCURY(9.302e+23, 2.439e6),
    VENUS(8.302e+23, 1.439e6),
    EARTH(5.302e+23, 3.439e6),
    MARS(7.302e+23, 4.439e6),
    JUPITER(6.302e+23, 6.439e6),
    SATURN(2.302e+23, 5.439e6),
    URANUS(1.302e+23, 7.439e6),
    NEPTUNE(3.302e+23, 7.439e6);

    /**
     * In kilograms 以公斤计
     */
    private final double mass;
    /**
     * In meters    以米为单位
     */
    private final double radius;
    /**
     * In m / s^2
     */
    private final double surfaceGravity;
    /**
     * Universal gravitational constant in m^3 / kg s^2
     * 万向引力常数，单位为m ^ 3 / kg s ^ 2
     */
    public static final double G = 6.67300E-11;

    Planet(double mass, double radius) {
        this.mass = mass;
        this.radius = radius;
        this.surfaceGravity = G * mass / (radius * radius);
    }

    public double getMass() {
        return mass;
    }

    public double getRadius() {
        return radius;
    }

    public double getSurfaceGravity() {
        return surfaceGravity;
    }

    public double getSurfaceGravity(double mass) {
        // F = ma
        return surfaceGravity * mass;
    }


}
