package com.zxb.effective.chapter05.example04;

import java.util.EnumMap;
import java.util.Map;

/**
 * Using a nested EnumMap to associate data with enum pairs
 * 使用嵌套的EnumMap将数据与枚举对关联
 * 总而言之，最好不要用序数来索引数组， 而要使用EnumMap
 * @author Mr.zxb
 * @date 2019-01-06 21:22:55
 */
public enum Phase2 {

    SOLID, LIQUID, GAS;

    public enum Transition {
        MELT(SOLID, LIQUID), SUBLIME(LIQUID, SOLID),
        FREEZE(LIQUID, GAS), BOIL(GAS, LIQUID),
        DEPOSIT(SOLID, GAS), CONDENSE(GAS, SOLID);

        private final Phase2 src;
        private final Phase2 dst;

        Transition(Phase2 src, Phase2 dst) {
            this.src = src;
            this.dst = dst;
        }

        /**
         * Initialize the phase transition map
         * 初始化 transition map
         */
        private static final Map<Phase2, Map<Phase2, Transition>> m = new EnumMap<>(Phase2.class);

        static {
            for (Phase2 p : Phase2.values()) {
                m.put(p, new EnumMap<>(Phase2.class));
            }
            for (Transition t : Transition.values()) {
                m.get(t.src).put(t.dst, t);
            }
        }


        public static Transition from(Phase2 src, Phase2 dst) {
            return m.get(src).get(dst);
        }
    }
}
