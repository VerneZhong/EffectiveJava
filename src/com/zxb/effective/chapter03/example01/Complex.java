package com.zxb.effective.chapter03.example01;

/**
 * 使可变性最小化：
 * 1. 不要提供任何会修改对象状态的方法
 * 2. 保证类不会被扩展
 * 3. 使所有的域都是final的
 * 4. 使所有的域都成为私有的
 * 5. 确保对于任何可变组件的互斥访问
 *
 * 这个类表示一个复数
 * @author Mr.zxb
 * @date 2018-12-14 16:20
 */
public final class Complex {

    private final double re;
    private final double im;

    public Complex(double re, double im) {
        this.re = re;
        this.im = im;
    }

    /**
     * Accessors with no corresponding mutators
     * @return
     */
    public double realPart() {
        return re;
    }

    /**
     * Accessors with no corresponding mutators
     * @return
     */
    public double imaginaryPart() {
        return im;
    }

    public Complex add(Complex c) {
        return new Complex(re + c.re, im + c.im);
    }

    public Complex subtract(Complex c) {
        return new Complex(re - c.re, im - c.im);
    }

    public Complex multiply(Complex c) {
        return new Complex(re * c.re - im * c.im, re * c.im + im * c.re);
    }

    public Complex divide(Complex c) {
        double tmp = c.re * c.re + c.im * c.im;
        return new Complex((re * c.re + im * c.im) / tmp, (im * c.re - re * c.im) / tmp);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Complex)) {
            return false;
        }
        Complex c = (Complex) obj;
        return Double.compare(re, c.re) == 0 && Double.compare(im, c.im) == 0;
    }

    @Override
    public int hashCode() {
        int result = 17 + hashDouble(re);
        result = 31 * result + hashDouble(im);
        return result;
    }

    private int hashDouble(double re) {
        long longBits = Double.doubleToLongBits(re);
        return (int) (longBits ^ (longBits >>> 32));
    }

    @Override
    public String toString() {
        return "(" + re + " + " + im + ")";
    }

    public static void main(String[] args) {

        double d1 = 2.5;
        double d2 = 3.5;

        Complex complex = new Complex(d1, d2);

        Complex c = complex.add(new Complex(2, 2));
        Complex c1 = complex.add(new Complex(2, 2));
        System.out.println(c.hashCode());
        System.out.println(c1.hashCode());
        System.out.println(c.equals(c1));
    }
}
