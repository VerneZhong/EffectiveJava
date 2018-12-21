package com.zxb.effective.chapter03.example06;

import java.io.Serializable;
import java.util.Comparator;

/**
 * @author Mr.zxb
 * @date 2018-12-18 15:32
 */
public class Host {

    private static class StrLenCmp implements Comparator<String>, Serializable {

        @Override
        public int compare(String o1, String o2) {
            return o1.length() - o2.length();
        }
    }

    private static final Comparator<String> STRING_LENGTH_COMPARATOR = new StrLenCmp();

}
