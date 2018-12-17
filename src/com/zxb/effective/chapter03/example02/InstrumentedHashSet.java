package com.zxb.effective.chapter03.example02;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;

/**
 * 复合优先于继承
 * @author Mr.zxb
 * @date 2018-12-17 11:16
 */
public class InstrumentedHashSet<E> extends HashSet<E> {

    /**
     * 集合添加元素的个数
     */
    private int addCount;

    public InstrumentedHashSet() {

    }

    public InstrumentedHashSet(int initialCapacity, float loadFactor) {
        super(initialCapacity, loadFactor);
    }

    @Override
    public boolean add(E e) {
        addCount++;
        return super.add(e);
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        addCount += c.size();
        return super.addAll(c);
    }

    public int getAddCount() {
        return addCount;
    }

    public static void main(String[] args) {

        InstrumentedHashSet<String> hashSet = new InstrumentedHashSet<>();
        // 我们期望值是3，结果是6，主要是因为addAll方法会调用add方法，导致数值添加重复
        hashSet.addAll(Arrays.asList("Snap", "Java", "C#"));
        System.out.println(hashSet.getAddCount());
    }
}
