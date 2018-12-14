package com.zxb.effective.chapter01.example04;

/**
 * Java5提供的自动装箱是一种创建多余对象的方法
 * @author Mr.zxb
 * @date 2018-12-12 10:38
 */
public class Main {

    public static void main(String[] args) {
        // 该程序的答案是正确的，但是比实际要更慢一些
        long start = System.currentTimeMillis();
        long sum = 0L;
        // 优先使用基本类型而不是装箱基本类型，要当心无意识的自动装箱
//        Long sum = 0L;
        for (long i = 0; i < Integer.MAX_VALUE; i++) {
            sum += i;
        }
        System.out.println(sum);
        System.out.println("耗时：" + (System.currentTimeMillis() - start));
    }
}
