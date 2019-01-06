package com.zxb.effective.chapter05.example03;

import java.util.EnumSet;
import java.util.Set;

/**
 * 用EnumSet代替位域
 * Bit field enumeration constants - OBSOLETE!
 * 位字段枚举常量 -  OBSOLETE！
 * @author Mr.zxb
 * @date 2019-01-06 16:14:32
 */
public class Text {

    public static final int STYLE_BOLD = 1 << 0;
    public static final int STYLE_ITALIC = 1 << 1;
    public static final int STYLE_UNDERLINE = 1 << 2;
    public static final int STYLE_STRIKETHROUGH = 1 << 3;

    /**
     * Parameter is bitwise OR of zero or more STYLE_ constants
     * 参数是零或多个STYLE_常量的按位OR
     * @param styles
     */
    public void applyStyles(int styles) {
//        ...
    }

    /**
     * Any Set could be passed in, but EnumSet is clearly best
     * 任何Set都可以传入，但EnumSet显然是最好的
     * @param styles
     */
    public void applyStyles(Set<Style> styles) {
//        ...
    }

    /**
     * EnumSet - a modern replacement for bit fields
     * EnumSet  - 比特字段的现代替代品
     */
    public enum Style {
        BOLD, ITALIC, UNDERLINE, STRIKETHROUGH
    }

    public static void main(String[] args) {
        Text text = new Text();
        // 总而言之，正是因为枚举类型要用在集合（Set）中，所以没有理由用位域来表示它。
        text.applyStyles(EnumSet.of(Style.BOLD, Style.ITALIC));
    }
}
