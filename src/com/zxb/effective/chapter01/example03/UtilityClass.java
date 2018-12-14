package com.zxb.effective.chapter01.example03;

/**
 * 通过私有构造器强化不可实例化的能力
 * 该用法会导致不能被子类化，所有的构造器都必须显式或隐式地调用超类构造器
 * @author Mr.zxb
 * @date 2018-12-12 10:17
 */
public class UtilityClass {

    /**
     * 禁止默认构造函数以实现非实例化
     */
    private UtilityClass() {
        throw new AssertionError();
    }

    // 其他方法
}
