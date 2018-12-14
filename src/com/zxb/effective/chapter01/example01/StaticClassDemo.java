package com.zxb.effective.chapter01.example01;

/**
 * 考虑用静态工厂方法替代构造器
 * 静态工厂方法的优势：
 * 1、静态工厂方法有方法名称，容易更实用
 * 2、静态工厂方法不必在每次调用它们的时候都创建一个新对象
 * 3、静态工厂方法可以返回原返回类型的任意子类型的对象，操作更灵活
 * 4、在创建参数化类型实例的时候，可以使代码更简洁
 * @author Mr.zxb
 * @date 2018-12-11 14:55
 */
public class StaticClassDemo {

    private static volatile StaticClass staticClass;

    static class StaticClass {

    }

    public static StaticClass getStaticClass() {
        if (staticClass == null) {
            synchronized (StaticClassDemo.class) {
                if (staticClass == null) {
                    staticClass = new StaticClass();
                }
            }
        }
        return staticClass;
    }

    public static void main(String[] args) {

        StaticClass s1 = StaticClassDemo.getStaticClass();
        StaticClass s2 = StaticClassDemo.getStaticClass();

        System.out.println(s1 == s2);
    }
}
