package com.zxb.effective.chapter05.example01;

/**
 * 用enum替代int常量
 *
 * @author Mr.zxb
 * @date 2019-01-06 14:57:52
 */
public class EnumSubstituteConstant {

    /**
     * The int enum pattern - severely deficient!
     * int enum模式 - 严重缺陷！
     */
    public static final int APPLE_FUJI = 0;
    public static final int APPLE_PIPPIN = 1;
    public static final int APPLE_GRANNY_SMITH = 2;

    public static final int ORANGE_NAVEL = 0;
    public static final int ORANGE_TEMPLE = 1;
    public static final int ORANGE_BLOOD = 2;

    /**
     * 类型安全的枚举
     */
    public enum Apple {
        FUJI, PIPPIN, GRANNY_SMITH
    }

    public enum Orange {
        NAVEL, TEMPLE, BLOOD
    }

}
