package com.zxb.effective.chapter04.example03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 列表优先于数组
 * @author Mr.zxb
 * @date 2019-01-06 10:27:40
 */
public class ListTakesPrecedenceOverArray {


    public void codeFragment() {
        // Fails at runtime 在运行时失败
        Object[] objects = new Long[1];
        // Throws ArrayStoreException
        objects[0] = "I don't fit in";

        // Won't compile  不会编译
//        List<Object> ol = new ArrayList<Long>();
//        ol.add("I don't fit in");

        // Why generic array creation is illegal - won't compile!
        // 为什么通用数组创建是非法的 - 不会编译！
//        List<String>[] stringLists = new List<String>[1];
        List<Integer> integers = Arrays.asList(42);
//        Object[] objects1 = stringLists;
//        objects1[0] = integers;
//        String s = stringLists[0].get(0);
    }

    /**
     * Reduction without generics, and with concurrency flaw!
     * 没有泛型的减少，并没有并发性缺陷！
     * @param list
     * @param f
     * @param initVal
     * @return
     */
    static Object reduce(List list, Function f, Object initVal) {
        synchronized (list) {
            Object result = initVal;
            for (Object o : list) {
                result = f.apply(result, o);
            }
            return result;
        }
    }

    /**
     * Reduction without generics or concurrency flaw!
     * 没有泛型或并发缺陷的减少！
     * @param list
     * @param f
     * @param initVal
     * @return
     */
    static Object reduce2(List list, Function f, Object initVal) {
        // Locks list internally
        // 内部锁定列表
        Object[] snapshot = list.toArray();
        Object result = initVal;
        for (Object e : snapshot) {
            result = f.apply(result, e);
        }
        return result;
    }

    interface Function {
        Object apply(Object o1, Object o2);
    }

    /**
     * Native generic version of reduction - won't compile!
     * 原生通用版减少 - 不会编译！
     * @param list
     * @param f
     * @param initVal
     * @param <E>
     * @return
     */
    static <E> E reduce(List<E> list, Function2<E> f, E initVal) {
        // 会有警告，编译器告诉你，它无法再运行时检查转换的安全性，因为它在运行时还不知道E是什么
        E[] snapshot = (E[]) list.toArray();
        E result = initVal;
        for (E e : snapshot) {
            result = f.apply(result, e);
        }
        return result;
    }

    /**
     * List-based generic reduction
     * 基于列表的通用减少
     * @param list
     * @param f
     * @param initVal
     * @param <E>
     * @return
     */
    static <E> E reduceBase(List<E> list, Function2<E> f, E initVal) {
        // 这个版本的代码比数组版的代码稍微冗长一些，但是可以确定的是在运行时不会出现ClassCastException异常
        // 总之，数组和泛型有着非常相同的类型规则。数组是协变且可以具体化的；泛型是不可变的且可以被擦除的。
        // 因此，数组提供了运行时的类型安全，但是没有编译时的类型安全，反之，对于泛型也一样。一般来说，数组和泛型不能很好的混合使用。
        // 如果你发现自己将他们混合使用，并且得到了编译时错误或者警告，你的第一反应就应该是用列表代替数组。
        List<E> snapshot;
        synchronized (list) {
            snapshot = new ArrayList<>(list);
        }
        E result = initVal;
        for (E e : snapshot) {
            result = f.apply(result, e);
        }
        return result;
    }

    /**
     * 如果通过泛型来完成这一点
     */
    interface Function2<T> {
        T apply(T t1, T t2);
    }
}
