package com.zxb.effective.chapter01.example02;

/**
 * 枚举类型的单例模式
 * @author Mr.zxb
 * @date 2018-12-11 17:20
 */
public enum Elivis {

    INSTANCE;

    public void leaveTheBuilding() {

    }

    public static Elivis getInstance() {
        return INSTANCE;
    }
}
