package com.myxh.leetcode.array;

import java.util.Arrays;

/**
 * Given a non-empty array of digits representing a non-negative integer, plus one to the integer.
 *
 * The digits are stored such that the most significant digit is at the head of the list, and each element in the array contain a single digit.
 *
 * You may assume the integer does not contain any leading zero, except the number 0 itself.
 *
 * Example 1:
 *
 * Input: [1,2,3]
 * Output: [1,2,4]
 * Explanation: The array represents the integer 123.
 * Example 2:
 *
 * Input: [4,3,2,1]
 * Output: [4,3,2,2]
 * Explanation: The array represents the integer 4321.
 *
 * Input: [9,9]
 * Output: [1,0,0]
 * Explanation: The array represents the integer 99.
 */
public class L66_PlusOne {
    public static void main(String[] args) {
        int[] digits = {9,9};
        System.out.println(Arrays.toString(plusOne(digits)));
    }

    /**
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Plus One.
     * Memory Usage: 37.5 MB, less than 5.64% of Java online submissions for Plus One.
     */
    public static int[] plusOne(int[] digits) {
        if (digits[digits.length - 1] == 9) {
            int carry = 1;
            digits[digits.length - 1] = 0;
            for (int i = digits.length - 2; i >= 0; i--) {
                int sum = digits[i] + carry;
                digits[i] = sum % 10;
                carry = sum / 10;
            }
            if (carry > 0) {
                int[] array = new int[digits.length + 1];
                array[0] = carry;
                return array;
            } else {
                return digits;
            }
        } else {
            digits[digits.length - 1] += 1;
            return digits;
        }
    }

    /**
     * 高赞答案
     */
    public int[] plusOne2(int[] digits) {
        int n = digits.length;
        for(int i=n-1; i>=0; i--) {
            if(digits[i] < 9) {
                digits[i]++;
                return digits;
            }

            digits[i] = 0;
        }

        int[] newNumber = new int [n+1];
        newNumber[0] = 1;

        return newNumber;
    }
}
