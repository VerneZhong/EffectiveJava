package com.zxb.effective.chapter05.example04;

import java.util.EnumMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 用EnumMap代替序数索引
 * @author Mr.zxb
 * @date 2019-01-06 21:01:04
 */
public class Herb {

    public enum Type {
        ANNUAL, PERENNIAL, BIENNIAL;
    }

    private final String name;
    private final Type type;

    public Herb(String name, Type type) {
        this.name = name;
        this.type = type;
    }

    @Override
    public String toString() {
        return name;
    }

    public void methodOne() {

        // Using ordinal() to index an array - DON'T DO THIS!
        // 使用ordinal（）索引数组 - 不要这样做！
        Herb[] garden = new Herb[Type.values().length];

        // Indexed by Herb.Type.ordinal()
        // 由Herb.Type.ordinal（）索引
        Set<Herb>[] herbByType = new Set[Type.values().length];

        for (int i = 0; i < herbByType.length; i++) {
            herbByType[i] = new HashSet<>();
        }

        for (Herb h : garden) {
            herbByType[h.type.ordinal()].add(h);
        }

        // Print the results
        for (int i = 0; i < herbByType.length; i++) {
            System.out.printf("%s: %s%n", Herb.Type.values()[i], herbByType[i]);
        }
    }

    public void methodTwo() {
        // Using an EnumMap to associate data with an enum.
        // 使用EnumMap将数据与枚举关联。
        Herb[] garden = new Herb[Type.values().length];

        Map<Herb.Type, Set<Herb>> typeSetMap = new EnumMap<>(Herb.Type.class);

        for (Herb.Type t : Herb.Type.values()) {
            typeSetMap.put(t, new HashSet<>());
        }
        for (Herb h : garden) {
            typeSetMap.get(h.type).add(h);
        }
        System.out.println(typeSetMap);
    }
}
