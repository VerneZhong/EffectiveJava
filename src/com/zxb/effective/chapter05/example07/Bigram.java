package com.zxb.effective.chapter05.example07;

import java.util.HashSet;
import java.util.Set;

/**
 * 坚持使用@Override注解
 * Can you spot the bug?
 * 你能发现这个bug吗？
 * @author Mr.zxb
 * @date 2019-01-07 21:47:27
 */
public class Bigram {

    private final char first;
    private final char second;

    public Bigram(char first, char second) {
        this.first = first;
        this.second = second;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Bigram)) {
            return false;
        }
        Bigram big = (Bigram) o;
        return big.first == first && big.second == second;
    }

    @Override
    public int hashCode() {
        return 31 * first + second;
    }

    public static void main(String[] args) {

        Set<Bigram> s = new HashSet<>();

        for (int i = 0; i < 10; i++) {
            for (char ch = 'a'; ch <= 'z'; ch++) {
                s.add(new Bigram(ch, ch));
            }
        }
        System.out.println(s.size());
    }
}
