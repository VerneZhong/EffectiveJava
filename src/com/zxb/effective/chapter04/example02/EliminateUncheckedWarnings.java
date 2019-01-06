package com.zxb.effective.chapter04.example02;

import java.util.Arrays;

/**
 * 消除非受检警告
 * 如果无法消除警告，同时可以证明引起警告代码是类型安全的，可以用注解@SuppressWarnings("unchecked")注解来禁止这条警告，
 * 应该尽可能小的范围中使用@SuppressWarnings注解
 * @author Mr.zxb
 * @date 2019-01-06 10:15:47
 */
public class EliminateUncheckedWarnings<T> {

    private int size;

    private T[] elements;

    public <T> T[] toArray(T[] a) {
        if (a.length < size) {
            @SuppressWarnings("unchecked")
            // 该方法编译会产生这条警告 Unchecked cast: 'java.lang.Object[]' to 'T[]
            // This cast is correct because the array we're creating is of the same type as the one passed in, which is T[].
            // 这个强制转换是正确的，因为我们创建的数组与传入的数组的类型相同，即T []。
            T[] result = (T[]) Arrays.copyOf(elements, size, a.getClass());
            return result;
        }
        System.arraycopy(elements, 0, a, 0, size);
        if (a.length > size) {
            a[size] = null;
        }
        return a;
    }
}
