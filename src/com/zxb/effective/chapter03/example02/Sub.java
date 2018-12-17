package com.zxb.effective.chapter03.example02;

import java.util.Date;

/**
 * @author Mr.zxb
 * @date 2018-12-17 14:25
 */
public final class Sub extends Super {

    private final Date date;

    public Sub() {
        this.date = new Date();
    }

    @Override
    public void overrideMe() {
        System.out.println(date);
    }

    public static void main(String[] args) {
        Sub sub = new Sub();
        sub.overrideMe();
    }
}
