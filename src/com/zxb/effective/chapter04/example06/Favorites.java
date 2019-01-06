package com.zxb.effective.chapter04.example06;

import java.lang.annotation.Annotation;
import java.util.HashMap;
import java.util.Map;

/**
 * 优先考虑类型安全的异构容器
 * Type safe heterogeneous container pattern - API
 * 键入安全异构容器模式 -  API
 * @author Mr.zxb
 * @date 2019-01-06 14:35:43
 */
public class Favorites {

    private Map<Class<?>, Object> favorites = new HashMap<>();

    /**
     * Achieving runtime type safety with a dynamic cast
     * 使用动态强制转换实现运行时类型安全
     * @param type
     * @param instance
     * @param <T>
     */
    public <T> void putFavorite(Class<T> type, T instance) {
        if (type == null) {
            throw new NullPointerException("type is null");
        }
        favorites.put(type, type.cast(instance));
    }

    /**
     * 将对象动态地转换成了Class对象所表示的类型
     * @param type
     * @param <T>
     * @return
     */
    public <T> T getFavorite(Class<T> type) {
        return type.cast(favorites.get(type));
    }

    /**
     * Use of asSubclass to safely cast to a bounded type token.
     * 使用asSubclass安全地转换为有界类型令牌。
     * @param type
     * @param <T>
     * @return
     */
//    public <T extends Annotation> T getAnnotation(Class<T> type) {
//        return type.getAnnotation(type.asSubclass(Annotation.class));
//    }

    public static void main(String[] args) {

        Favorites f = new Favorites();

        f.putFavorite(String.class, "Java");
        f.putFavorite(Integer.class, 10);
        f.putFavorite(Class.class, Favorites.class);

        String fs = f.getFavorite(String.class);
        Integer is = f.getFavorite(Integer.class);
        Class cs = f.getFavorite(Class.class);

        System.out.printf("%s %x %s%n", fs, is, cs.getName());
    }
}
