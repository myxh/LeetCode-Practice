package com.myxh.leetcode.array;

import java.util.Arrays;

/**
 * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
 * <p>
 * Note:
 * <p>
 * The number of elements initialized in nums1 and nums2 are m and n respectively.
 * You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2.
 * Example:
 * <p>
 * Input:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 * <p>
 * Output: [1,2,2,3,5,6]
 */
public class L88_MergeSortedArray {
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int m = 3;
        int[] nums2 = {2, 5, 6};
        int n = 3;
        merge(nums1, m, nums2, n);
        System.out.println(Arrays.toString(nums1));
    }

    /**
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Merge Sorted Array.
     * Memory Usage: 35.4 MB, less than 97.34% of Java online submissions for Merge Sorted Array.
     */
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int index = m + n - 1;
        int i = m - 1;
        int j = n - 1;
        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[index--] = nums1[i--];
            } else {
                nums1[index--] = nums2[j--];
            }
        }
        //这段代码纯属多余
        /*while (i >= 0) {
            nums1[index--] = nums1[i--];
        }*/

        while (j >= 0) {
            nums1[index--] = nums2[j--];
        }
    }

    /**
     * 高赞答案1
     */
    public static void merge2(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1, j = n - 1, k = m + n - 1;
        while (i > -1 && j > -1) {
            nums1[k--] = (nums1[i] > nums2[j]) ? nums1[i--] : nums2[j--];
        }
        while (j > -1) {
            nums1[k--] = nums2[j--];
        }
    }

    /**
     * 高赞答案2
     */
    public static void merge3(int[] nums1, int m, int[] nums2, int n) {
        while (n > 0) {
            nums1[m + n - 1] = (m == 0 || nums2[n - 1] > nums1[m - 1]) ? nums2[--n] : nums1[--m];
        }
    }
}
