package com.zxb.effective.chapter05.example01;

import java.util.HashMap;
import java.util.Map;

/**
 * Enum type that switches on its own value - questionable
 * 枚举类型可以切换自己的价值 - 值得怀疑
 *
 * @author Mr.zxb
 * @date 2019-01-06 15:18:25
 */
public enum Operation {

    /**
     * + - * /
     */
    PLUS, MINUS, TIMES, DIVIDE;

    /**
     * Do the arithmetic op represented by this constant
     * 由此常量表示的算术运算
     *
     * @param x
     * @param y
     * @return
     */
    double apply(double x, double y) {
        switch (this) {
            case PLUS:
                return x + y;
            case MINUS:
                return x - y;
            case TIMES:
                return x * y;
            case DIVIDE:
                return x / y;
            default:
                throw new AssertionError("Unknown op:" + this);
        }

    }

    /**
     * Enum type with constant-specific method implementations
     * 具有常量特定方法实现的枚举类型
     */
    public enum Operation2 {
        PLUS {
            @Override
            double apply(double x, double y) {
                return x + y;
            }
        },
        MINUS {
            @Override
            double apply(double x, double y) {
                return x - y;
            }
        },
        TIMES {
            @Override
            double apply(double x, double y) {
                return x * y;
            }
        },
        DIVIDE {
            @Override
            double apply(double x, double y) {
                return x / y;
            }
        };

        /**
         * 提供抽象方法
         *
         * @param x
         * @param y
         * @return
         */
        abstract double apply(double x, double y);
    }

    /**
     * Enum type with constant-specific class bodies and data
     * 具有常量特定类主体和数据的枚举类型
     */
    public enum Operation3 {
        PLUS("+") {
            @Override
            double apply(double x, double y) {
                return x + y;
            }
        },
        MINUS("-") {
            @Override
            double apply(double x, double y) {
                return x - y;
            }
        },
        TIMES("*") {
            @Override
            double apply(double x, double y) {
                return x * y;
            }
        },
        DIVIDE("/") {
            @Override
            double apply(double x, double y) {
                return x / y;
            }
        };

        private final String symbol;

        Operation3(String symbol) {
            this.symbol = symbol;
        }


        @Override
        public String toString() {
            return symbol;
        }

        /**
         * 提供抽象方法
         *
         * @param x
         * @param y
         * @return
         */
        abstract double apply(double x, double y);
    }

    public static void main(String[] args) {

        double x = 1.0;
        double y = 2.0;

        for (Operation3 o : Operation3.values()) {
            System.out.printf("%s %s %s = %s%n", x, o, y, o.apply(x, y));
        }
    }

    /**
     * Implementing a fromString method on an enum type
     * 在枚举类型上实现fromString方法
     */
    private static final Map<String, Operation3> stringToEnum = new HashMap<>();

    static {
        // Initialize map from constant name to enum constant
        // 将常量名称的映射初始化为枚举常量
        for (Operation3 op : Operation3.values()) {
            stringToEnum.put(op.toString(), op);
        }
    }

    /**
     * Returns Operation for string, or null if string is invalid
     * 返回string的操作，如果string无效，则返回null
     * @param symbol
     * @return
     */
    public static Operation3 fromString(String symbol) {
        return stringToEnum.get(symbol);
    }

    /**
     * Switch on an enum to simulate a missing method
     * 打开枚举以模拟丢失的方法
     * @param op
     * @return
     */
    public static Operation3 inverse(Operation3 op) {
        switch (op) {
            case PLUS: return Operation3.PLUS;
            case MINUS: return Operation3.MINUS;
            case TIMES: return Operation3.TIMES;
            case DIVIDE: return Operation3.DIVIDE;
            default:
                throw new AssertionError("Unknown op:" + op);
        }
    }
}
