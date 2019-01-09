package com.zxb.effective.chapter06.example02;

import java.util.*;

/**
 * 慎用重载
 * Broken! - What does this program print?
 * 破碎！ - 这个程序打印什么？
 *
 * @author Mr.zxb
 * @date 2019-01-09 15:36
 */
public class CollectionClassifier {

    public static String classify(Set<?> set) {
        return "Set";
    }

    public static String classify(List<?> list) {
        return "List";
    }

    public static String classify(Collection<?> collection) {
        return collection instanceof Set ? "Set" : collection instanceof List ? "List" : "Unknown Collection";
    }

    public static void main(String[] args) {

        Collection<?>[] collections = { new HashSet<>(), new ArrayList<>(), new HashMap<String, String>().values() };

        for (Collection<?> c : collections) {
            System.out.println(classify(c));
        }
    }
}
