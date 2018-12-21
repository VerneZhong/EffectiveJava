package com.zxb.effective.chapter03.example06;

import java.util.Comparator;

/**
 * @author Mr.zxb
 * @date 2018-12-18 15:30
 */
public class StringLengthComparator implements Comparator<String> {

    private static final StringLengthComparator instance = new StringLengthComparator();

    private StringLengthComparator() {}

    @Override
    public int compare(String s1, String s2) {
        return s1.length() - s2.length();
    }

    public static StringLengthComparator getInstance() {
        return instance;
    }
}
