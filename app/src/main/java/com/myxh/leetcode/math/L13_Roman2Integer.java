package com.myxh.leetcode.math;

import java.util.HashMap;
import java.util.Map;

/**
 * Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
 * <p>
 * Symbol       Value
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * For example, two is written as II in Roman numeral, just two one's added together. Twelve is written as, XII, which is simply X + II. The number twenty seven is written as XXVII, which is XX + V + II.
 * <p>
 * Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:
 * <p>
 * I can be placed before V (5) and X (10) to make 4 and 9.
 * X can be placed before L (50) and C (100) to make 40 and 90.
 * C can be placed before D (500) and M (1000) to make 400 and 900.
 * Given a roman numeral, convert it to an integer. Input is guaranteed to be within the range from 1 to 3999.
 * <p>
 * Example 1:
 * <p>
 * Input: "III"
 * Output: 3
 * Example 2:
 * <p>
 * Input: "IV"
 * Output: 4
 * Example 3:
 * <p>
 * Input: "IX"
 * Output: 9
 * Example 4:
 * <p>
 * Input: "LVIII"
 * Output: 58
 * Explanation: L = 50, V= 5, III = 3.
 * Example 5:
 * <p>
 * Input: "MCMXCIV"
 * Output: 1994
 * Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
 */
public class L13_Roman2Integer {
    public static void main(String[] args) {
        System.out.println(romanToInt2("IV"));
    }

    /**
     * Runtime: 5 ms, faster than 85.90% of Java online submissions for Roman to Integer.
     * Memory Usage: 38 MB, less than 32.93% of Java online submissions for Roman to Integer.
     */
    public static int romanToInt(String s) {
        char[] romanChar = {'I', 'V', 'X', 'L', 'C', 'D', 'M'};
        int[] romanNum = {1, 5, 10, 50, 100, 500, 1000};
        Map<Character, Integer> romanMap = new HashMap<>();
        for (int index = 0; index < romanChar.length; index++) {
            romanMap.put(romanChar[index], romanNum[index]);
        }
        int result = 0;
        for (int j = 0; j < s.length(); j++) {
            char c = s.charAt(j);

            Integer num = romanMap.get(c);
            if (j + 1 < s.length()) {
                char nextChar = s.charAt(j + 1);
                if ((c == 'I' && (nextChar == 'V' || nextChar == 'X'))
                        || (c == 'X' && (nextChar == 'L' || nextChar == 'C'))
                        || (c == 'C' && (nextChar == 'D' || nextChar == 'M'))) {
                    result += romanMap.get(nextChar) - num;
                    j++;
                    continue;
                }
            }
            result += romanMap.get(s.charAt(j));
        }
        return result;
    }

    /**
     *
     * Runtime: 3 ms, faster than 100.00% of Java online submissions for Roman to Integer.
     * Memory Usage: 37.3 MB, less than 35.04% of Java online submissions for Roman to Integer.
     */
    public static int romanToInt2(String s) {
        if (s == null || s.length() == 0) {
            return -1;
        }
        int result = 0;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = s.charAt(i);
            switch (c) {
                case 'I':
                    if (i + 1 < chars.length && (chars[i + 1] == 'V' || chars[i + 1] == 'X')) {
                        result += (chars[i + 1] == 'V' ? 5 : 10) - 1;
                        i++;
                        continue;
                    }
                    result += 1;
                    break;
                case 'X':
                    if (i + 1 < chars.length && (chars[i + 1] == 'L' || chars[i + 1] == 'C')) {
                        result += (chars[i + 1] == 'L' ? 50 : 100) - 10;
                        i++;
                        continue;
                    }
                    result += 10;
                    break;
                case 'C':
                    if (i + 1 < chars.length && (chars[i + 1] == 'D' || chars[i + 1] == 'M')) {
                        result += (chars[i + 1] == 'D' ? 500 : 1000) - 100;
                        i++;
                        continue;
                    }
                    result += 100;
                    break;
                case 'V':
                    result += 5;
                    break;
                case 'L':
                    result += 50;
                    break;
                case 'D':
                    result += 500;
                    break;
                case 'M':
                    result += 1000;
                    break;
                default:
            }
        }
        return result;
    }
}
