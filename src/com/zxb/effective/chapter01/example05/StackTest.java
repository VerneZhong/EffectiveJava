package com.zxb.effective.chapter01.example05;

/**
 * @author Mr.zxb
 * @date 2018-12-12 11:25
 */
public class StackTest {

    public static void main(String[] args) {

        StackExample stack = new StackExample();

        for (int i = 0; i < 16; i++) {
            stack.push(i);
        }

        System.out.println(stack.toString());
        StackExample stack1 = (StackExample) stack.clone();
        System.out.println(stack1.toString());
        System.out.println(stack == stack1);

//        System.runFinalization();
//        System.runFinalizersOnExit(true);
    }
}
