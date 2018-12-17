package com.zxb.effective.chapter03.example02;

import java.util.*;

/**
 * 前一个例子的修正版，复合优先于继承
 * 不用扩展现有的类，而是在新的类中增加一个私有域，它引用现有类的一个实例。这种设计被称为“复合”，因为现有的类变成了新类的一个组件。
 * 新类中的每个实例方法都可以被调用被包含的现有类实例中对应的方法，并返回它的结果。这被称为“转发”，新类中的方法被称为转发方法。
 * @author Mr.zxb
 * @date 2018-12-17 11:23
 */
public class InstrumentedSet<E> extends ForwardingSet<E> {

    private int addCount;


    public InstrumentedSet(Set<E> set) {
        super(set);
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
        // 而且支持任意Set的子类型，这种实现方式更灵活健壮
        InstrumentedSet<String> set = new InstrumentedSet<>(new HashSet<>());

        set.addAll(Arrays.asList("C#", "Java", "Swift"));

        System.out.println(set.getAddCount());
    }
}

/**
 * 转发类
 * @param <E>
 */
class ForwardingSet<E> implements Set<E> {

    private final Set<E> set;

    public ForwardingSet(Set<E> set) {
        this.set = set;
    }

    @Override
    public int size() {
        return set.size();
    }

    @Override
    public boolean isEmpty() {
        return set.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return set.contains(o);
    }

    @Override
    public Iterator<E> iterator() {
        return set.iterator();
    }

    @Override
    public Object[] toArray() {
        return set.toArray();
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return set.toArray(a);
    }

    @Override
    public boolean add(E e) {
        return set.add(e);
    }

    @Override
    public boolean remove(Object o) {
        return set.remove(o);
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return set.containsAll(c);
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        return set.addAll(c);
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return set.retainAll(c);
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return set.removeAll(c);
    }

    @Override
    public void clear() {
        set.clear();
    }

    @Override
    public int hashCode() {
        return set.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return set.equals(obj);
    }

    @Override
    public String toString() {
        return set.toString();
    }
}