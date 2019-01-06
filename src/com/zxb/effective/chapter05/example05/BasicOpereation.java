package com.zxb.effective.chapter05.example05;

import java.util.Arrays;
import java.util.Collection;

/**
 * Emulated extensible enum using an interface
 * 使用接口模拟可扩展枚举
 *
 * @author Mr.zxb
 * @date 2019-01-06 21:33:52
 */
public enum BasicOpereation implements Operation<Double> {

    PLUS("+") {
        @Override
        public Double apply(Double x, Double y) {
            return x + y;
        }
    }, MINUS("-") {
        @Override
        public Double apply(Double x, Double y) {
            return x - y;
        }
    }, TIMES("*") {
        @Override
        public Double apply(Double x, Double y) {
            return x * y;
        }
    }, DIVIDE("/") {
        @Override
        public Double apply(Double x, Double y) {
            return x / y;
        }
    }, EXP("^") {
        @Override
        public Double apply(Double x, Double y) {
            return Math.pow(x, y);
        }
    }, REMAINDER("%") {
        @Override
        public Double apply(Double x, Double y) {
            return x % y;
        }
    };

    private final String symbol;

    BasicOpereation(String symbol) {
        this.symbol = symbol;
    }


    @Override
    public String toString() {
        return symbol;
    }

}

class Test {
    public static void main(String[] args) {

        double x = 2.0;
        double y = 2.0;
        test(BasicOpereation.class, x ,y);
        test(Arrays.asList(BasicOpereation.values()), x, y);
    }

    private static <T extends Enum<T> & Operation<Double>> void test(Class<T> opSet, Double x, Double y) {
        for (Operation<Double> op : opSet.getEnumConstants()) {
            System.out.printf("%s %s %s = %s%n", x, op, y, op.apply(x, y));
        }
    }

    /**
     * 有限制的通配符类型
     * @param opSet
     * @param x
     * @param y
     */
    private static void test(Collection<? extends Operation> opSet, double x, double y) {
        for (Operation op : opSet) {
            System.out.printf("%s %s %s = %s%n", x, op, y, op.apply(x, y));
        }
    }
}
