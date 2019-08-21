package com.myxh.leetcode.linkedlist;

/**
 * Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.
 * <p>
 * Example:
 * <p>
 * Input: 1->2->4, 1->3->4
 * Output: 1->1->2->3->4->4
 */
public class L21_MergeTwoSortedLists {
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 4};
        ListNode l1 = new ListNode(1);
        ListNode tmp1 = l1;
        for (int i = 1; i < nums1.length; i++) {
            tmp1.next = new ListNode(nums1[i]);
        }

        int[] nums2 = {1, 3, 4};
        ListNode l2 = new ListNode(1);
        ListNode tmp2 = l2;
        for (int i = 1; i < nums2.length; i++) {
            tmp2.next = new ListNode(nums2[i]);
        }


        while ((tmp1 = l1) != null) {
            System.out.print(tmp1.val+"->");
            tmp1 = tmp1.next;
        }
        System.out.println();
        while ((tmp2 = l2) != null) {
            System.out.print(tmp2.val+"->");
            tmp2 = tmp2.next;
        }
        System.out.println("-------------------------------------------");
        ListNode result = mergeTwoLists(l1, l2);
        while (result != null) {

        }
        System.out.println("-------------------------------------------");
    }

    /**
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Merge Two Sorted Lists.
     * Memory Usage: 38.5 MB, less than 83.20% of Java online submissions for Merge Two Sorted Lists.
     */
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(-1);
        ListNode tmp = result;
        while (l1 != null && l2 != null) {
            if (l1.val > l2.val) {
                tmp.next = l2;
                l2 = l2.next;
            } else {
                tmp.next = l1;
                l1 = l1.next;
            }
            tmp = tmp.next;
        }
        while (l1 != null) {
            tmp.next = l1;
            l1 = l1.next;
            tmp = tmp.next;
        }
        while (l2 != null) {
            tmp.next = l2;
            l2 = l2.next;
            tmp = tmp.next;
        }
        return result.next;
    }
}
