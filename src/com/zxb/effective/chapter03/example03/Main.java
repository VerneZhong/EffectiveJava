package com.zxb.effective.chapter03.example03;

import java.util.AbstractList;
import java.util.List;

/**
 * 接口优先于抽象类
 * @author Mr.zxb
 * @date 2018-12-18 10:46
 */
public class Main {

    /**
     * Concrete implementation built atop skeletal implementation
     * 在骨架实现之上构建的具体实现，以下实现自动装箱的开销，所以性能不会很好
     * @param a
     * @return
     */
    static List<Integer> intArrayAsList(final int[] a) {
        if (a == null) {
            throw new NullPointerException();
        }
        return new AbstractList<Integer>() {
            @Override
            public Integer get(int index) {
                // 自动装箱
                return a[index];
            }

            @Override
            public Integer set(int index, Integer element) {
                int oldValue = a[index];
                a[index] = element;
                // 自动装箱
                return oldValue;
            }

            @Override
            public int size() {
                return a.length;
            }
        };
    }
}
