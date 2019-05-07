package com.myxh.leetcode.string;

/**
 * Write a function to find the longest common prefix string amongst an array of strings.
 *
 * If there is no common prefix, return an empty string "".
 *
 * Example 1:
 *
 * Input: ["flower","flow","flight"]
 * Output: "fl"
 * Example 2:
 *
 * Input: ["dog","racecar","car"]
 * Output: ""
 * Explanation: There is no common prefix among the input strings.
 */
public class L14_LongestCommonPrefix {
    public static void main(String[] args) {
        String[] strs = {"aa","aa"};
        System.out.println(longestCommonPrefix(strs));
    }

    /**
     * Runtime: 1 ms, faster than 89.31% of Java online submissions for Longest Common Prefix.
     * Memory Usage: 37.7 MB, less than 74.95% of Java online submissions for Longest Common Prefix.
     */
    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        int index = 0;
        for (int i = 0; i < strs[0].length(); i++) {
            char oldValue = strs[0].charAt(i);
            int count = 1;
            for (int j = 1; j < strs.length; j++) {
                if (i > strs[j].length() - 1) {
                    break;
                }
                if (oldValue == strs[j].charAt(i)) {
                    count++;
                } else {
                    break;
                }
            }
            if (count == strs.length) {
                index++;
            } else {
                break;
            }
        }
        return strs[0].substring(0, index);
    }

    /**
     * 高赞答案
     * @param strs
     * @return
     */
    public String longestCommonPrefix2(String[] strs) {
        if(strs == null || strs.length == 0) {
            return "";
        }
        String pre = strs[0];
        int i = 1;
        while(i < strs.length){
            while(strs[i].indexOf(pre) != 0) {
                pre = pre.substring(0,pre.length()-1);
            }
            i++;
        }
        return pre;
    }
}
