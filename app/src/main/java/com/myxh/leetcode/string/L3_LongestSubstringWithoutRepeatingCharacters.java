package com.myxh.leetcode.string;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Given a string, find the length of the longest substring without repeating characters.
 * <p>
 * Example 1:
 * <p>
 * Input: "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 * Example 2:
 * <p>
 * Input: "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 * Example 3:
 * <p>
 * Input: "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 * Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */
public class L3_LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        String s = "qwertyesuio";
        System.out.println(lengthOfLongestSubstring(s));
    }

    /**
     * Runtime: 6 ms, faster than 92.94% of Java online submissions for Longest Substring Without Repeating Characters.
     * Memory Usage: 36.8 MB, less than 72.50% of Java online submissions for Longest Substring Without Repeating Characters.
     */
    public static int lengthOfLongestSubstring(String s) {
        if (s == null) {
            return 0;
        }
        if (s.length() < 2) {
            return s.length();
        }
        Map<Character, Integer> map = new HashMap<>();
        int pre = 0;
        int length = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            Integer integer = map.get(c);
            //出现重复元素并且下标在[pre, i]区间内
            if (integer != null && pre <= integer) {
                //移到重复元素的下一个元素下标
                pre = integer + 1;
            } else {
                //更新最长不重复子串长度
                length = Math.max(length, i - pre + 1);
            }
            //记录元素最后出现的下标
            map.put(c, i);
        }
        return length;
    }

    /**
     * 高赞答案
     */
    public static int lengthOfLongestSubstring2(String s) {
        if (s.length() == 0) {
            return 0;
        }
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int max = 0;
        for (int i = 0, j = 0; i < s.length(); ++i) {
            if (map.containsKey(s.charAt(i))) {
                j = Math.max(j, map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i), i);
            max = Math.max(max, i - j + 1);
        }
        return max;
    }
}
