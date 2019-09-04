package com.myxh.leetcode.linkedlist;

/**
 * Given a sorted linked list, delete all duplicates such that each element appear only once.
 *
 * Example 1:
 *
 * Input: 1->1->2
 * Output: 1->2
 * Example 2:
 *
 * Input: 1->1->2->3->3
 * Output: 1->2->3
 */
public class L83_RemoveDuplicatesFromSortedList {

    public static void main(String[] args) {
        ListNode list = ListUtils.getList(new int[]{1, 1, 2, 3, 3, 3, 3});
        ListUtils.print(deleteDuplicates(list));
    }

    /**
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Remove Duplicates from Sorted List.
     * Memory Usage: 36.1 MB, less than 100.00% of Java online submissions for Remove Duplicates from Sorted List.
     */
    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        ListNode result = head;
        while (fast != null) {
            if (slow.val != fast.val) {
                slow.next = fast;
                slow = slow.next;
            } else if (slow.val == fast.val && fast.next == null) {
                slow.next = null;
            }
            fast = fast.next;
        }
        return result;
    }

    /**
     * 高赞答案
     */
    public static ListNode deleteDuplicates1(ListNode head) {
        ListNode list = head;

        while(list != null) {
            if (list.next == null) {
                break;
            }
            if (list.val == list.next.val) {
                list.next = list.next.next;
            } else {
                list = list.next;
            }
        }

        return head;
    }

}
