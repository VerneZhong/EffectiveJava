package com.zxb.effective.chapter04.example04;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.EmptyStackException;

/**
 * Prioritize generics 优先考虑泛型
 *
 * 利用有限制通配符来提升API的灵活性
 * 结论很明显：为了获得最大限度的灵活性，要在表示生产者或者消费者的输入参数上使用通配符类型。换句话说，如果参数化类型表示一个生产者，就使用
 * <? extends T>；如果它表示一个消费者，就使用<? super T>
 *
 * @author Mr.zxb
 * @date 2019-01-06 10:53:23
 */
public class PrioritizeGenerics {

    static class Stack<E> {
        private E[] elements;
        private int size = 0;
        public static final int DEFAULT_INITIAL_CAPACITY = 16;

        @SuppressWarnings("unchecked")
        public Stack() {
            elements = (E[]) new Object[DEFAULT_INITIAL_CAPACITY];
        }

        public void push(E e) {
            ensureCapacity();
            elements[size++] = e;
        }

        public E pop() {
            if (size == 0) {
                throw new EmptyStackException();
            }
            E result = elements[--size];
            // Eliminate obsolete reference 消除过时的引用，避免内存溢出
            elements[size] = null;
            return result;
        }

        public boolean isEmpty() {
            return this.size == 0;
        }

        /**
         * pushAll method without wildcard type - deficient!
         * pushAll方法没有通配符类型 - 缺陷！
         * Wildcard type for parameter that serves as an E producer
         * 用作E生产者的参数的通配符类型
         * 利用有限制通配符来提升API的灵活性
         * Iterable<? extends E> pushAll的输入参数类型不应该为“E的Iterable接口”，而应该为“E的某个子类型的Iterable接口”
         * @param src
         */
        public void pushAll(Iterable<? extends E> src) {
            for (E e : src) {
                push(e);
            }
        }

        /**
         * popAll method without wildcard type - deficient!
         * 没有通配符类型的popAll方法 - 缺陷！
         * Collection<? super E> popAll的输入参数类型不应该为“E的集合”，而应该为“E的某种超类的集合”
         * @param dst
         */
        public void popAll(Collection<? super E> dst) {
            while (!isEmpty()) {
                dst.add(pop());
            }
        }

        private void ensureCapacity() {
            if (elements.length == size) {
                elements = Arrays.copyOf(elements, 2 * size + 1);
            }
        }
    }

    public static void main(String[] args) {

        Stack<Number> numberStack = new Stack<>();
        Iterable<Integer> integers = new ArrayList<>();
        numberStack.pushAll(integers);

        Collection<Object> objects = new ArrayList<>();
        numberStack.popAll(objects);
    }
}
