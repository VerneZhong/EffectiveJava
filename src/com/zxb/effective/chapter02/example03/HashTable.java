package com.zxb.effective.chapter02.example03;

/**
 * @author Mr.zxb
 * @date 2018-12-14 09:48
 */
public class HashTable implements Cloneable {

    private Entry[] buckets;

    /**
     * 拷贝构造器和拷贝静态工厂方法，这两种都是有效的拷贝方法
     * @param table
     */
    public HashTable(HashTable table) {
        this.buckets = table.buckets;
    }

    /**
     * 拷贝静态工厂方法
     * @param table
     * @return
     */
    public static HashTable newInstance(HashTable table) {
        return new HashTable(table);
    }

    private static class Entry {
        final Object key;
        Object value;
        Entry next;

        public Entry(Object key, Object value, Entry next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

        /**
         * 深拷贝的递归方法
         *
         * @return
         */
        public Entry deepCopy() {
            // 如果散列桶不是很长可以有很好的效果，这样克隆链表不是一个好办法，因为针对列表中的每个元素，它都消耗一段栈空间。如果链表比较长
            // 的话，很容易导致栈内存溢出。为了避免这种状况，可以将递归替换成迭代
//            return new Entry(key, value, next == null ? null : next.deepCopy());

            Entry result = new Entry(key, value, next);
            for (Entry p = result; p.next != null; p = p.next) {
                p.next = new Entry(p.next.key, p.next.value, p.next.next);
            }
            return result;
        }
    }

//    @Override
//    protected Object clone() {
//        try {
//            HashTable table = (HashTable) super.clone();
//            // 错误做法：虽然被克隆的对象有自己的散列桶，但是这个数组引用的链表与原始对象是一样的，从而引起克隆对象和原始对象中不确定的行为
//            table.buckets = buckets.clone();
//            return table;
//        } catch (CloneNotSupportedException e) {
//            throw new AssertionError();
//        }
//    }

    /**
     * 修正做法我们必须单独拷贝并组成每个桶的链表。以下是场景的做法：
     * 深度拷贝
     *
     * @return
     */
    @Override
    protected Object clone() {
        try {
            HashTable table = (HashTable) super.clone();
            table.buckets = new Entry[buckets.length];
            for (int i = 0; i < buckets.length; i++) {
                if (buckets[i] != null) {
                    table.buckets[i] = buckets[i].deepCopy();
                }
            }
            return table;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
