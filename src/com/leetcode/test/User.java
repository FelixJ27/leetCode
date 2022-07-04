package com.leetcode.test;

/**
 * @Author: Felix
 * @Description:
 */
public class User {

    private String text = "user";

    public void getText() {
        System.out.println(text);
    }

    public void testException(int n) {
        try {
            if (n % 2 != 0) {
                throw new NullPointerException();
            }
        } finally {
            System.out.println("e");
        }
    }
}
