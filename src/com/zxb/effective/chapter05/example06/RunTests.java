package com.zxb.effective.chapter05.example06;

import java.lang.reflect.*;

/**
 * Program to process marker annotation
 * 用于处理标记注释的程序
 *
 * @author Mr.zxb
 * @date 2019-01-06 21:52:00
 */
public class RunTests {

    public static void main(String[] args) throws ClassNotFoundException {

        int tests = 0;
        int passed = 0;
        Class testClass = Class.forName("com.zxb.effective.chapter05.example06.Sample");

        for (Method m : testClass.getDeclaredMethods()) {
//            if (m.isAnnotationPresent(Test.class)) {
            if (m.isAnnotationPresent(ExceptionTest.class)) {
                tests++;
                try {
                    m.invoke(null);
//                    passed++;
                    System.out.printf("Test %s failed: no exception%n", m);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    Throwable exc = e.getCause();
                    Class<? extends Exception> excType = m.getAnnotation(ExceptionTest.class).value();
                    if (excType.isInstance(exc)) {
                        passed++;
                    } else {
                        System.out.println(m + " failed: " + exc);
                    }
                }
            }
        }
        System.out.printf("Passed: %d, Failed: %d%n", passed, tests - passed);
    }
}
