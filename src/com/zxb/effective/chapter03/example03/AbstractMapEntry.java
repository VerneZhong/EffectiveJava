package com.zxb.effective.chapter03.example03;

import java.util.Map;

/**
 * Skeletal Implementation
 * Map.Entry接口的骨架实现
 * @author Mr.zxb
 * @date 2018-12-18 10:57
 */
public abstract class AbstractMapEntry<K, V> implements Map.Entry<K, V> {

    /**
     * Primitive operations
     * 原始操作
     * @return
     */
    @Override
    public abstract K getKey();

    /**
     * Primitive operations
     * 原始操作
     * @return
     */
    @Override
    public abstract V getValue();

    /**
     * Entries in modifiable maps must override this method
     * 可修改映射中的条目必须覆盖此方法
     * @param value
     * @return
     */
    @Override
    public V setValue(V value) {
        throw new UnsupportedOperationException();
    }

    /**
     * Implements the general contract of Map.Entry.hashCode
     * 实现Map.Entry.hashCode的常规协定
     * @return
     */
    @Override
    public int hashCode() {
        return hashCode(getKey()) ^ hashCode(getValue());
    }

    private int hashCode(Object obj) {
        return obj == null ? 0 : obj.hashCode();
    }

    private boolean equals(Object o1, Object o2) {
        return o1 == null ? o2 == null : o1.equals(o2);
    }

    /**
     * Implements the general contract of Map.Entry.equals
     * 实现Map.Entry.equals的常规协定
     * @param obj
     * @return
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        Map.Entry<K, V> entry = (Map.Entry<K, V>) obj;
        return equals(getKey(), entry.getKey()) && equals(getValue(), entry.getValue());
    }
}
