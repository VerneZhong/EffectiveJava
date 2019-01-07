package com.zxb.effective.chapter06.example01;

import java.util.Date;

/**
 * 必要时进行保护性拷贝
 * Broken "immutable" time period class
 * 打破“不可变”的时间段
 *
 * @author Mr.zxb
 * @date 2019-01-07 21:54:10
 */
public class Period {

    private final Date start;
    private final Date end;

    /**
     * @param start
     * @param end
     */
    public Period(Date start, Date end) {
        // Repaired constructor - makes defensive copies of parameter. 修复的构造函数 - 制作参数的防御副本。
        this.start = new Date(start.getTime());
        this.end = new Date(end.getTime());
        if (start.compareTo(end) > 0) {
            throw new IllegalArgumentException(start + " after " + end);
        }
//        this.start = start;
//        this.end = end;
    }

    /**
     * Repaired accessors - make defensive copies of internal fields.
     * 修复的访问者 - 制作内部字段的防御性副本。
     * @return
     */
    public Date start() {
        return new Date(start.getTime());
    }

    public Date end() {
        return new Date(end.getTime());
    }

    @Override
    public String toString() {
        return "start:" + start.getYear() + ", end:" + end.getYear();
    }

    /**
     * Attack the internals of a Period instance
     * 攻击Period实例的内部
     */
    public static void attack() {
        Date start = new Date();
        Date end = new Date();

        Period p = new Period(start, end);
        // Modifies internals of p! 修改p的内部！
        end.setYear(78);
        System.out.println("attack: " + p);
    }

    /**
     * Second attack on the internals of a Period instance.
     * 对Period实例内部的第二次攻击
     */
    public static void attackSecond() {
        Date start = new Date();
        Date end = new Date();

        Period p = new Period(start, end);
        // Modifies internals of p! 修改p的内部！
        p.end().setYear(78);
        System.out.println("attackSecond: " + p);
    }

    public static void main(String[] args) {
        Period.attack();
        Period.attackSecond();
    }
}
