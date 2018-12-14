package com.zxb.effective.chapter01.example04;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 * 避免创建不必要的对象
 * @author Mr.zxb
 * @date 2018-12-12 10:24
 */
public class Person {

    private final Date birthDate;

    // 其他字段省略...

    public Person(Date birthDate) {
        this.birthDate = birthDate;
    }

    /**
     * DON't DO THIS
     * 检验这个人是否出生于1946-1965年间
     * 以下这种实现方式，每次调用isBabyBoomer方法都会创建Calendar和TimeZone和Date实例，这是没必要的
     * @return
     */
    public boolean isBabyBoomer() {
        // Unnecessary allocation of expensive object 不必要的昂贵对象分配
        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
        calendar.set(1946, Calendar.JANUARY, 1, 0, 0, 0);
        Date boomStart = calendar.getTime();
        calendar.set(1965, Calendar.JANUARY, 1, 0, 0, 0);
        Date boomEnd = calendar.getTime();
        return birthDate.compareTo(boomStart) >= 0 && birthDate.compareTo(boomEnd) < 0;
    }

    /*****避免使用终结方法*****/
    @Override
    protected void finalize() throws Throwable {
        // Manual finalizer chaining 手动终结方法链
        try {
            System.out.println("finalize");
        } finally {
            // 如果子类实现者覆盖了超类的终结方法，如果不调用父类的终结方法，那么超类的终结方法永远不会执行
            super.finalize();
        }
    }

    public static void main(String[] args) {
        boolean b = new Person(new Date()).isBabyBoomer();

        System.out.println(b);

//        System.gc();
//        System.runFinalization();
//        System.runFinalizersOnExit(true);
    }
}
