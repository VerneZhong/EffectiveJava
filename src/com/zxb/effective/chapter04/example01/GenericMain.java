package com.zxb.effective.chapter04.example01;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * 请不要在代码中使用原生态类型
 *
 * @author Mr.zxb
 * @date 2018-12-21 11:18
 */
public class GenericMain {

    public static void main(String[] args) {
        List<Object> strings = new ArrayList<>();

        unsafeAdd(strings, new Integer(42));

        Object s = strings.get(0);

        System.out.println(s);
    }

    private static void unsafeAdd(List<Object> list, Object o) {
        list.add(o);
    }

    /**
     * Use of raw type for unknown element type - Don't do this!
     * 原始类型用于未知元素类型 - 不要这样做！
     * @param s1
     * @param s2
     * @return
     */
    static int numElementsInCommon(Set s1, Set s2) {
        int result = 0;
        for (Object o1 : s1) {
            if (s2.contains(o1)) {
                result++;
            }
        }
        return result;
    }

    /**
     * Unbounded wildcard type - typesafe and flexible
     * 无界通配符类型 - 类型安全且灵活
     * 通配符类型更安全，原生态类型则不安全。
     * @param s1
     * @param s2
     * @return
     */
    static int numElementsInCommon2(Set<?> s1, Set<?> s2) {
        int result = 0;
        for (Object o1 : s1) {
            if (s2.contains(o1)) {
                result++;
            }
        }
        return result;
    }
}
