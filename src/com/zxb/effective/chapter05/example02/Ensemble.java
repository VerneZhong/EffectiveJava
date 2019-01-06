package com.zxb.effective.chapter05.example02;

/**
 * 用实例域代替序数
 * Abuse of ordinal to derive an associated value - DON'T DO THIS
 * 滥用序数来获得相关价值 - 不要这样做
 * @author Mr.zxb
 * @date 2019-01-06 16:09:22
 */
public enum Ensemble {

    SOLO, DUET, TRIO, QUARTET, QUINTET, SEXTET, SEPTET, OCTET, NONET, DECTET;

    public int numberOfMusicians() {
        return ordinal() + 1;
    }

    enum Ensemble2 {
        SOLO(1), DUET(2), TRIO(3), QUARTET(4), QUINTET(5), SEXTET(6), SEPTET(7), OCTET(8), NONET(9), DECTET(10);

        private final int numberOfMusicians;

        Ensemble2(int numberOfMusicians) {
            this.numberOfMusicians = numberOfMusicians;
        }

        public int numberOfMusicians() {
            return numberOfMusicians;
        }
    }
}
