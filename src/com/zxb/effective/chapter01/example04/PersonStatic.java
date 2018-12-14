package com.zxb.effective.chapter01.example04;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 * 用静态初始化器，避免创建不必要的对象
 * 静态初始化，每次都会初始化对象，如果不调用isBabyBoomer方法，初始化就没必要，可以通过延迟初始化的方式来修改
 * @author Mr.zxb
 * @date 2018-12-12 10:33
 */
public class PersonStatic {

    private final Date birthDate;

    public static final Date BOOM_START;

    public static final Date BOOM_END;

    static {
        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
        calendar.set(1946, Calendar.JANUARY, 1, 0, 0, 0);
        BOOM_START = calendar.getTime();
        calendar.set(1965, Calendar.JANUARY, 1, 0, 0, 0);
        BOOM_END = calendar.getTime();
    }

    public PersonStatic(Date birthDate) {
        this.birthDate = birthDate;
    }

    public boolean isBabyBoomer() {
        return birthDate.compareTo(BOOM_START) >= 0 && birthDate.compareTo(BOOM_END) < 0;
    }
}
