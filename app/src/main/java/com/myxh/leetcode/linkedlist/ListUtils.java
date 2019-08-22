package com.myxh.leetcode.linkedlist;

/**
 * @author myxh
 * @description com.myxh.leetcode.linkedlist
 * @date 2019-08-21
 */
public class ListUtils {
    public static void print(ListNode node) {
        while (node != null) {
            System.out.print(node.val);
            if (node.next != null) {
                System.out.print("->");
            }
            node = node.next;
        }
        System.out.println();
    }

    public static ListNode getList(int[] nums) {
        if (nums == null || nums.length < 1) {
            return null;
        }
        ListNode node = new ListNode(nums[0]);
        ListNode tmp = node;
        for (int i = 1; i < nums.length; i++) {
            tmp.next = new ListNode(nums[i]);
            tmp = tmp.next;
        }
        return node;
    }
}
