package com.zxb.effective.chapter04.example05;

import java.util.*;

/**
 * Prioritize generic methods 优先考虑泛型方法
 * @author Mr.zxb
 * @date 2019-01-06 11:09:19
 */
public class PrioritizeGenericMethods {

    /**
     * Uses raw types - unacceptable!
     * 使用原始类型 - 不可接受！
     * @param s1
     * @param s2
     * @return
     */
    public static Set union(Set s1, Set s2) {
        // 这个方法可以编译，但有两条警告
        Set result = new HashSet(s1);
        result.addAll(s2);
        return result;
    }

    /**
     * Generic method
     * 用泛型使方法变成类型安全的
     * 该方法的局限性在于，三个集合的类型（两个输入参数和一个返回值）必须全部都是相同的。
     * 利用有限制的通配符类型，可以使得这个方法变得更灵活。
     * 泛型方法的一个显著特性是，无需明确指定类型参数的值， 不像调用泛型构造器的时候是必须制定的。编译器通过检查方法参数的类型来计算类型参数的值。
     * @param s1
     * @param s2
     * @param <E>
     * @return
     */
    public static <E> Set<E> union2(Set<E> s1, Set<E> s2) {
        Set<E> result = new HashSet<>(s1);
        result.addAll(s2);
        return result;
    }

    /**
     * Generic static factory method  泛型静态工厂方法
     * @param <K>
     * @param <V>
     * @return
     */
    public static <K, V> HashMap<K, V> newHashMap() {
        return new HashMap<>(16);
    }

    public interface UnaryFunction<T> {
        T apply(T arg);
    }

    /**
     * Generic singleton factory pattern
     * 通用的单例工厂模式
     */
    private static UnaryFunction<Object> IDENTITY_FUNCTION = arg -> arg;

    /**
     * IDENTITY_FUNCTION is stateless and its type parameter is unbounded so it's safe to share one instance across all types.
     * IDENTITY_FUNCTION是无状态的，其类型参数是无界的，因此可以安全地在所有类型之间共享一个实例。
     * @param <T>
     * @return
     */
    @SuppressWarnings("unchecked")
    public static <T> UnaryFunction<T> identityFunction() {
        return (UnaryFunction<T>) IDENTITY_FUNCTION;
    }

    public static void main(String[] args) {

        Set<String> guys = new HashSet<>(Arrays.asList("Tom", "Dick", "Harry"));

        Set<String> stooges = new HashSet<>(Arrays.asList("Larry", "Moe", "Curly"));

        Set<String> aflCio = union2(guys, stooges);

//        System.out.println(aflCio);

        // Parameterized type instance creation with static factory 使用静态工厂创建参数化类型实例
        Map<String, List<String>> listMap = newHashMap();

        String[] strings = {"jute", "hemp", "nylon"};

        UnaryFunction<String> sameString = identityFunction();
        for (String s : strings) {
            System.out.println(sameString.apply(s));
        }

        Number[] numbers = {1, 2.0, 3L};
        UnaryFunction<Number> sameNumber = identityFunction();
        for (Number n :numbers) {
            System.out.println(sameNumber.apply(n));
        }
    }
}
