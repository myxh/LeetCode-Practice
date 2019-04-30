package com.myxh.leetcode.math;

/**
 * Given a 32-bit signed integer, reverse digits of an integer.
 *
 * Example 1:
 *
 * Input: 123
 * Output: 321
 * Example 2:
 *
 * Input: -123
 * Output: -321
 * Example 3:
 *
 * Input: 120
 * Output: 21
 * Note:
 * Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range:
 * [−231,  231 − 1]. For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.
 */
public class L7_ReverseInteger {

    public static void main(String[] args) {

    }

    /**
     *
     * @param x
     * @return
     */
    public static int reverse(int x) {
        if (x == 0) {
            return 0;
        }
        int i = Math.abs(x);
        int j = 0;
        long result = 0;
        while (i > 0) {
            j = i % 10;
            result = result * 10 + j;
            i = i / 10;
        }
        result = x > 0 ? result : -result;
        if (x > 0) {
            if (result > Integer.MAX_VALUE) {
                return 0;
            }
            return (int) result;
        } else {
            if (result < Integer.MIN_VALUE) {
                return 0;
            }
            return (int) result;
        }
    }
}
