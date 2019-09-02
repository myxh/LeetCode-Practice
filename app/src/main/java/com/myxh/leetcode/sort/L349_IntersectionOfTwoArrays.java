package com.myxh.leetcode.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

/**
 * Given two arrays, write a function to compute their intersection.
 *
 * Example 1:
 *
 * Input: nums1 = [1,2,2,1], nums2 = [2,2]
 * Output: [2]
 *
 * Example 2:
 *
 * Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * Output: [9,4]
 *
 * Note:
 *
 * Each element in the result must be unique.
 * The result can be in any order.
 */
public class L349_IntersectionOfTwoArrays {

    public static void main(String[] args) {
        int[] nums1 = {4,9,5};
        int[] nums2 = {9,4,9,8,4};
        System.out.println(Arrays.toString(intersection(nums1, nums2)));
    }

    /**
     * Runtime: 1 ms, faster than 99.88% of Java online submissions for Intersection of Two Arrays.
     * Memory Usage: 37.8 MB, less than 48.65% of Java online submissions for Intersection of Two Arrays.
     */
    public static int[] intersection(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null) {
            return null;
        } else if (nums1.length <= 0 || nums2.length <= 0) {
            return nums1.length > nums2.length ? nums2 : nums1;
        }
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int k = 0;
        for (int i = 0, j = 0; i < nums1.length && j < nums2.length;) {
            if (nums1[i] > nums2[j]) {
                j++;
            } else if (nums1[i] < nums2[j]) {
                i++;
            } else {
                if (k == 0 || nums1[k - 1] != nums1[i]) {
                    nums1[k++] = nums1[i];
                }
                i++;
                j++;
            }
        }
        return Arrays.copyOf(nums1, k);
    }

    /**
     * 高赞答案
     */
    public static int[] intersection1(int[] nums1, int[] nums2) {
        HashSet<Integer> set = new HashSet<Integer>();
        ArrayList<Integer> res = new ArrayList<Integer>();
        //Add all elements to set from array 1
        for(int i =0; i< nums1.length; i++) set.add(nums1[i]);
        for(int j = 0; j < nums2.length; j++) {
            // If present in array 2 then add to res and remove from set
            if(set.contains(nums2[j])) {
                res.add(nums2[j]);
                set.remove(nums2[j]);
            }
        }
        // Convert ArrayList to array
        int[] arr = new int[res.size()];
        for (int i= 0; i < res.size(); i++) arr[i] = res.get(i);
        return arr;
    }
}
