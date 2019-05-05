package com.myxh.leetcode.math;

/**
 * Determine whether an integer is a palindrome. An integer is a palindrome when it reads the same backward as forward.
 *
 * Example 1:
 *
 * Input: 121
 * Output: true
 * Example 2:
 *
 * Input: -121
 * Output: false
 * Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
 * Example 3:
 *
 * Input: 10
 * Output: false
 * Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
 * Follow up:
 *
 * Could you solve it without converting the integer to a string?
 */
public class L9_PalindromeNumber {

    public static void main(String[] args) {

    }

    /**
     *
     * Runtime: 6 ms, faster than 100.00% of Java online submissions for Roman to Integer.
     * Memory Usage: 34.7 MB, less than 100.00% of Java online submissions for Roman to Integer.
     */
    public static boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        int result = 0;
        int tmp = x;
        while (tmp > 0) {
            result = result * 10 + tmp % 10;
            tmp = tmp / 10;
        }
        if (result == x) {
            return true;
        }
        return false;
    }

}
