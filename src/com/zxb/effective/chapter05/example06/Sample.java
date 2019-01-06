package com.zxb.effective.chapter05.example06;

/**
 * Program containing marker annotations
 * 包含标记注释的程序
 * @author Mr.zxb
 * @date 2019-01-06 21:49:27
 */
public class Sample {

    @Test
    public static void m1() {}

    public static void m2() {}

    @Test
    public static void m3() {
        throw new RuntimeException("Boom");
    }

    public static void m4() {}

    @Test
    public static void m5() {}

    public static void  m6() {}

    @Test
    public static void m7() {
        throw new RuntimeException("Crash");
    }

    public static void m8() {}

    @ExceptionTest(ArithmeticException.class)
    public static void  m9() {
        // Test should pass
        int i = 0;
        i = i/ i;
    }

    @ExceptionTest(ArithmeticException.class)
    public static void m10() {
        // Should fail (wrong exception)
        int[] a = new int[0];
        int i = a[1];
    }

    @ExceptionTest(ArithmeticException.class)
    public static void m11() {

    }

}
