package com.zxb.effective.chapter05.example04;

/**
 * Using ordinal() to index array of arrays - DON'T DO THIS!
 * 使用ordinal（）来索引数组数组 - 不要这样做！
 *
 * @author Mr.zxb
 * @date 2019-01-06 21:15:38
 */
public enum Phase {

    SOLID, LIQUID, GAS;

    public enum Transition {
        MELT, FREEZE, BOIL, CONDENSE, SUBLIME, DEPOSIT;

        /**
         * Rows indexed by src-ordinal, cols by dst-ordinal
         * 行由src-ordinal索引，cols由dst-ordinal索引
         */
        private static final Transition[][] TRANSITIONS = {
                {null, MELT, SUBLIME},
                {FREEZE, null, BOIL},
                {DEPOSIT, CONDENSE, null}
        };

        /**
         * Returns the phase transition from one phase to another
         * 返回从一个阶段到另一个阶段的阶段转换
         * @param src
         * @param dst
         * @return
         */
        public static Transition from(Phase src, Phase dst) {
            return TRANSITIONS[src.ordinal()][dst.ordinal()];
        }
    }

}
