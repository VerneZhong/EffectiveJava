package com.zxb.effective.chapter01.example05;

import java.util.Arrays;
import java.util.EmptyStackException;

/**
 * 消除过期的对象引用
 * 该类会引发内存泄漏，是比较隐式的一个问题
 * 内存泄漏另一个常见来源是缓存，可以用WeakHashMap作为缓存的数据结构，缓存过期后会自动删除
 * 内存泄漏的另一种常见来源是监听器和其他回调
 * @author Mr.zxb
 * @date 2018-12-12 11:12
 */
public class StackExample implements Cloneable {

    private Object[] objects;

    private int size;

    private static final int DEFAULT_INITIAL_CAPACITY = 16;

    public StackExample() {
        this.objects = new Object[DEFAULT_INITIAL_CAPACITY];
    }

    public void push(Object e) {
        ensureCapacity();
        objects[size++] = e;
    }

    public Object pop() {
        if (size == 0) {
            throw new EmptyStackException();
        }
        Object result = objects[--size];
        /**********************/
        // Eliminate obsolete reference 去掉无用的引用
        objects[size] = null;
        /**********************/
        return result;
    }

    /**
     * 数组扩容
     */
    public void ensureCapacity() {
        if (objects.length == size) {
            objects = Arrays.copyOf(objects, size * 2 + 1);
        }
    }

    /**
     * clone最好的替代方法是用拷贝构造器或是拷贝静态工厂方法
     * @return
     */
    @Override
    protected Object clone() {
        try {
            StackExample result = (StackExample) super.clone();
            result.objects = objects.clone();
            return result;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

    @Override
    public String toString() {
        return "size:" + size + ", objects:" + Arrays.toString(objects);
    }
}
