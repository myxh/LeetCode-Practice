package com.myxh.leetcode.array;

/**
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 * <p>
 * Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
 * <p>
 * You may assume nums1 and nums2 cannot be both empty.
 * <p>
 * Example 1:
 * <p>
 * nums1 = [1, 3]
 * nums2 = [2]
 * <p>
 * The median is 2.0
 * Example 2:
 * <p>
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 * <p>
 * The median is (2 + 3)/2 = 2.5
 */
public class L4_MedianOfTwoSortedArrays {
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 4, 5, 6};
        int[] nums2 = {3};
        System.out.println(findMedianSortedArrays(nums1, nums2));
    }

    /**
     * Runtime: 3 ms, faster than 56.62 % of Java online submissions for Remove Duplicates from Sorted Array.
     * Memory Usage: 46 MB, less than 93.36 % of Java online submissions for Remove Duplicates from Sorted Array.
     */
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null) {
            int[] nums = nums1 == null ? nums2 : nums1;
            if (nums == null || nums.length < 1) {
                return -1;
            }
            int numsMid = nums.length >> 1;
            if ((nums.length & 1) == 0) {
                return (nums[numsMid] + nums[numsMid - 1]) / 2f;
            } else {
                return nums[numsMid];
            }
        }
        int length = nums1.length + nums2.length;
        int index = 0;
        int i = 0;
        int j = 0;
        int mid = length >> 1;
        int[] result = new int[nums1.length + nums2.length];
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] > nums2[j]) {
                result[index++] = nums2[j++];
            } else {
                result[index++] = nums1[i++];
            }
        }
        while (i < nums1.length) {
            result[index++] = nums1[i++];
        }
        while (j < nums2.length) {
            result[index++] = nums2[j++];
        }
        return (length & 1) == 1 ? result[mid] : (result[mid - 1] + result[mid]) / 2f;
    }

    //----------------------------------------------------------------------------------------------

    /**
     * 高赞答案 time=O(log(m + n))
     */
    public static double findMedianSortedArrays2(int[] A, int[] B) {
        int m = A.length, n = B.length;
        int l = (m + n + 1) / 2;
        int r = (m + n + 2) / 2;
        return (getkth(A, 0, B, 0, l) + getkth(A, 0, B, 0, r)) / 2.0;
    }

    public static double getkth(int[] A, int aStart, int[] B, int bStart, int k) {
        if (aStart > A.length - 1) {
            return B[bStart + k - 1];
        }
        if (bStart > B.length - 1) {
            return A[aStart + k - 1];
        }
        if (k == 1) {
            return Math.min(A[aStart], B[bStart]);
        }

        int aMid = Integer.MAX_VALUE, bMid = Integer.MAX_VALUE;
        if (aStart + k / 2 - 1 < A.length) {
            aMid = A[aStart + k / 2 - 1];
        }
        if (bStart + k / 2 - 1 < B.length) {
            bMid = B[bStart + k / 2 - 1];
        }

        if (aMid < bMid) {
            // Check: aRight + bLeft
            return getkth(A, aStart + k / 2, B, bStart, k - k / 2);
        } else {
            // Check: bRight + aLeft
            return getkth(A, aStart, B, bStart + k / 2, k - k / 2);
        }
    }

}
