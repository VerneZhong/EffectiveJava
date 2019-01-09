package com.zxb.effective.chapter06.example03;

import java.util.Arrays;
import java.util.List;

/**
 * 慎用可变参数
 * @author Mr.zxb
 * @date 2019-01-09 16:02
 */
public class VariableParameterDemo {

    /**
     * Simple use of varargs
     * @param args
     * @return
     */
    static int sum(int...args) {
        int sum = 0;
        for (int arg : args) {
            sum += arg;
        }
        return sum;
    }

    /**
     * The WRONG way to use varargs to pass one or more arguments!
     * 使用varargs传递一个或多个参数的错误方法！
     * @param args
     * @return
     */
    static int min(int...args) {
        if (args.length == 0) {
            throw new IllegalArgumentException("Too few arguments.");
        }
        int min = args[0];
        for (int i = 1; i < args.length; i++) {
            if (args[i] < min) {
                min = args[i];
            }
        }
        return min;
    }

    /**
     * The right way to use varargs to pass one or more arguments
     * 使用varargs传递一个或多个参数的正确方法
     * @param args
     * @return
     */
    static int min2(int firstArg, int...args) {
        int min = firstArg;
        for (int arg : args) {
            if (arg < min) {
                min = arg;
            }
        }
        return min;
    }

    public static <T> List<T> gather(T...args) {
        return Arrays.asList(args);
    }

    public static void main(String[] args) {

        List<String> homophones = Arrays.asList("to", "too", "two");

        int[] digits = { 3, 1, 4, 1, 5, 9, 2, 6, 5, 4};
        System.out.println(Arrays.asList(digits));
    }
}
