package com.myxh.leetcode.linkedlist;

/**l;.
 * Given a singly linked list, determine if it is a palindrome.
 *
 * Example 1:
 *
 * Input: 1->2
 * Output: false
 * Example 2:
 *
 * Input: 1->2->2->1
 * Output: true
 */
public class L234_PalindromeLinkedList {

    public static void main(String[] args) {
        int[] l1Array = {1, 2, 2, 1};
        ListNode list1 = ListUtils.getList(l1Array);
        ListUtils.print(list1);
        System.out.println(isPalindrome(list1));
    }

    /**
     * Runtime: 1 ms, faster than 99.08% of Java online submissions for Palindrome Linked List.
     * Memory Usage: 40 MB, less than 98.78% of Java online submissions for Palindrome Linked List.
     */
    public static boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        ListNode slow = head;
        ListNode fast = head.next.next;
        //翻转后的前半段链表
        ListNode result = null;
        //将前半段链表翻转
        while (true) {
            ListNode tmp = result;
            result = slow;
            slow = slow.next;
            result.next = tmp;
            if (fast != null && fast.next != null) {
                fast = fast.next.next;
            } else {
                break;
            }
        }
        //元素个数为单数，单独处理 slow 指针
        if (fast != null && fast.next == null) {
            slow = slow.next;
        }
        //依次对比前半段和后半段链表元素
        while (slow != null && result != null) {
            if (slow.val != result.val) {
                return false;
            }
            slow = slow.next;
            result = result.next;
        }
        //前半段和后半段链表完全一致，说明是回文链表
        return true;
    }

    /**
     * 高赞答案
     */
    public static boolean isPalindrome1(ListNode head) {
        if(head == null) {
            return true;
        }
        ListNode p1 = head;
        ListNode p2 = head;
        ListNode p3 = p1.next;
        ListNode pre = p1;
        //find mid pointer, and reverse head half part
        while(p2.next != null && p2.next.next != null) {
            p2 = p2.next.next;
            pre = p1;
            p1 = p3;
            p3 = p3.next;
            p1.next = pre;
        }

        //odd number of elements, need left move p1 one step
        if(p2.next == null) {
            p1 = p1.next;
        }
        else {   //even number of elements, do nothing

        }
        //compare from mid to head/tail
        while(p3 != null) {
            if(p1.val != p3.val) {
                return false;
            }
            p1 = p1.next;
            p3 = p3.next;
        }
        return true;

    }
}
