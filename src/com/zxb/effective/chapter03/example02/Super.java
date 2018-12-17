package com.zxb.effective.chapter03.example02;

/**
 * 构造器绝不允许调用可被覆盖的方法
 * @author Mr.zxb
 * @date 2018-12-17 14:24
 */
public class Super {

    public Super() {
//        overrideMe();
    }

    public void overrideMe() {

    }
}
