package com.myxh.leetcode.array;

import java.util.Arrays;

/**
 * Given a sorted array nums, remove the duplicates in-place such that each element appear only once and return the new length.
 *
 * Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
 *
 * Example 1:
 *
 * Given nums = [1,1,2],
 *
 * Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively.
 *
 * It doesn't matter what you leave beyond the returned length.
 * Example 2:
 *
 * Given nums = [0,0,1,1,1,2,2,3,3,4],
 *
 * Your function should return length = 5, with the first five elements of nums being modified to 0, 1, 2, 3, and 4 respectively.
 *
 * It doesn't matter what values are set beyond the returned length.
 */
public class L26_RemoveDuplicatesFromSortedArray {
    public static void main(String[] args) {
        int[] nums = {0,0,1,1,1,2,2,3,3,4};
        System.out.println(removeDuplicates(nums) + ":" + Arrays.toString(nums));
    }

    /**
     * Runtime: 1 ms, faster than 99.97% of Java online submissions for Remove Duplicates from Sorted Array.
     * Memory Usage: 41.3 MB, less than 69.82% of Java online submissions for Remove Duplicates from Sorted Array.
     */
    public static int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        //前置元素索引
        int preIndex = 0;
        //已去重的数组长度
        int length = 1;
        //步长，当前遍历元素到前置元素的距离
        int gap;
        for (int i = 1; i < nums.length; i++) {
            gap = i - preIndex;
            if (nums[preIndex] == nums[i]) {
                gap++;
                continue;
            }
            //前置元素索引前进1位
            preIndex++;
            //步长>1 & 前置元素和当前遍历元素不相等，交换前置元素下一位和当前元素的值
            if (gap > 1) {
                int tmp = nums[preIndex];
                nums[preIndex] = nums[i];
                nums[i] = tmp;
            }
            length++;
        }
        return length;
    }

    /**
     * 示例答案
     */
    public int removeDuplicates2(int[] nums) {

        if(nums == null){
            return 0;
        }

        if(nums.length < 2){
            return nums.length;
        }

        int i = 0;

        for(int j = 1; j < nums.length; j++){
            if(nums[i] != nums[j]){
                nums[i+1] = nums[j];
                i++;
            }
        }

        return i+1;
    }
}
