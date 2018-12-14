package com.zxb.effective.chapter02.example01;

import java.util.ArrayList;
import java.util.List;

/**
 * 覆盖Object.equals方法时请遵守通用约定：
 * 自反性：对于任何非null的引用值x，x.equals(x)必须返回true
 * 对称性：对于任何非null的引用值x和y，当且仅当y.equals(x)返回true时，x.equals(y)也必须返回true
 * 传递性：对于任何非null的引用值x、y和z，如果x.equals(y)返回true，并且y.equals(z)返回true，那么x.equals(z)也必须返回true
 * 一致性：对于任何非null的引用值x和y，只要equals的比较操作在对象中所有的信息没有被修改，多次调用x.equals(y)就会一致地返回true，或者一致地返回false
 * Broken - violates symmetry
 * 破坏 - 违反对称性 的 例子
 * @author Mr.zxb
 * @date 2018-12-12 17:11
 */
public final class CaseInsensitiveString implements Comparable<CaseInsensitiveString> {

    private final String s;

    public CaseInsensitiveString(String s) {
        if (s == null) {
            throw new NullPointerException();
        }
        this.s = s;
    }

    /**
     * 违法了equals的对称性约定
     * @param obj
     * @return
     */
    @Override
    public boolean equals(Object obj) {
        // 字符串不区分大小写比较
//        if (obj instanceof CaseInsensitiveString) {
//            return s.equalsIgnoreCase(((CaseInsensitiveString) obj).s);
//        }
        // One-way interoperability 单向互操作性
//        if (obj instanceof String) {
//            return s.equalsIgnoreCase((String) obj);
//        }
//        return false;

        // 修正如下
        return obj instanceof CaseInsensitiveString && ((CaseInsensitiveString) obj).s.equalsIgnoreCase(s);
    }

    @Override
    public int hashCode() {
        return s.hashCode();
    }

    @Override
    public int compareTo(CaseInsensitiveString o) {
        return 0;
    }

    public static void main(String[] args) {

        CaseInsensitiveString cis = new CaseInsensitiveString("Polish");
        CaseInsensitiveString cis1 = new CaseInsensitiveString("polish");

        String s = "polish";
        // 问题在于CaseInsensitiveString类的equals方法知道成员变量String对象，但是，String类中的equals方法却不知道不区分大小写的字符串
        // 因此。违法了对称性
        System.out.println(cis.equals(s));
        System.out.println(cis.equals(cis1));
        System.out.println(cis1.equals(cis));

        List<CaseInsensitiveString> list = new ArrayList<>();
        list.add(cis);
        // 也是返回false
        System.out.println(list.contains(cis1));
    }

}
