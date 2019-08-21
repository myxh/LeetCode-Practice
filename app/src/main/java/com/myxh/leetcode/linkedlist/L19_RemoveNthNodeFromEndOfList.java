package com.myxh.leetcode.linkedlist;

/**
 * Given a linked list, remove the n-th node from the end of list and return its head.
 *
 * Example:
 *
 * Given linked list: 1->2->3->4->5, and n = 2.
 *
 * After removing the second node from the end, the linked list becomes 1->2->3->5.
 */
public class L19_RemoveNthNodeFromEndOfList {

    public static void main(String[] args) {
        ListNode list = ListUtils.getList(new int[]{1, 2, 3, 4, 5});
        ListUtils.print(removeNthFromEnd(list, 2));
    }

    /**
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Remove Nth Node From End of List.
     * Memory Usage: 34.7 MB, less than 100.00% of Java online submissions for Remove Nth Node From End of List.
     */
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null || n <= 0) {
            return head;
        }
        ListNode n1 = new ListNode(-1);
        n1.next = head;
        ListNode n2 = n1;
        ListNode tmp = n2;
        //n1 指针先走 n 步
        while(n > 0 && n1.next != null) {
            n1 = n1.next;
            n--;
        }
        while(n1.next != null) {
            n1 = n1.next;
            n2 = n2.next;
        }
        n2.next = n2.next.next;
        return tmp.next;
    }

    /**
     * 高赞答案
     */
    public static ListNode removeNthFromEnd1(ListNode head, int n) {

        ListNode start = new ListNode(0);
        ListNode slow = start, fast = start;
        slow.next = head;

        //Move fast in front so that the gap between slow and fast becomes n
        for(int i=1; i<=n+1; i++)   {
            fast = fast.next;
        }
        //Move fast to the end, maintaining the gap
        while(fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        //Skip the desired node
        slow.next = slow.next.next;
        return start.next;
    }

}
