package com.zxb.effective.chapter02.example02;

import java.util.Scanner;

/**
 * @author Mr.zxb
 * @date 2018-12-13 17:23
 */
public class AIMain {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String result = null;
        while (true) {
            result = scanner.next();
            result = result.replace("吗", "");
            result = result.replace("?", "!");
            result = result.replace("？", "!");
            System.out.println(result);
        }
    }
}
