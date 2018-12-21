package com.zxb.effective.chapter03.example07;

import java.util.AbstractSet;
import java.util.Iterator;

/**
 * 优先考虑静态成员类
 * 非静态成员类来实现迭代器
 * @author Mr.zxb
 * @date 2018-12-18 15:50
 */
public class MySet<E> extends AbstractSet<E> {
    @Override
    public Iterator<E> iterator() {
        return new MyIterator();
    }

    @Override
    public int size() {
        return 0;
    }

    private class MyIterator implements Iterator<E> {

        @Override
        public boolean hasNext() {
            return false;
        }

        @Override
        public E next() {
            return null;
        }
    }
}
