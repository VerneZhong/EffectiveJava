package com.zxb.effective.chapter06.example02;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author Mr.zxb
 * @date 2019-01-09 15:49
 */
public class SetList {

    public static void main(String[] args) {

        Set<Integer> set = new TreeSet<>();

        List<Integer> list = new ArrayList<>();

        for (int i = -3; i < 3; i++) {
            set.add(i);
            list.add(i);
        }

        for (int i = 0; i < 3; i++) {
            set.remove(i);
            // 按索引删除
//            list.remove(i);
            // 按Object删除
            list.remove(Integer.valueOf(i));
        }
        System.out.println(set + " " + list);
    }
}
