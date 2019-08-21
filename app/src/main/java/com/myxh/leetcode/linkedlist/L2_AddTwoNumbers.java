package com.myxh.leetcode.linkedlist;

/**
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 *
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *
 * Example:
 *
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
 */
public class L2_AddTwoNumbers {

    public static void main(String[] args) {
        ListNode list1 = ListUtils.getList(new int[]{2, 4, 3});
        ListNode list2 = ListUtils.getList(new int[]{5, 6, 4});
        ListUtils.print(addTwoNumbers(list1, list2));
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode temp = new ListNode(0);
        ListNode node = temp;
        ListNode n1 = l1, n2 = l2;
        while(n1 != null || n2 != null) {
            if(n1 != null && n2 != null) {
                int a = n1.val + n2.val;
                int sum = temp.val + a;
                temp.val = sum % 10;
                n1 = n1.next;
                n2 = n2.next;
                if(sum / 10 > 0 || (n1 != null || n2 != null)) {
                    temp.next = new ListNode(sum / 10);
                    temp = temp.next;
                }
            } else {
                if(n1 != null) {
                    int a1 = temp.val + n1.val;
                    temp.val = a1 % 10;
                    n1 = n1.next;
                    if(a1 / 10 > 0 || n1 != null) {
                        temp.next = new ListNode(a1 / 10);
                        temp = temp.next;
                    }
                }
                if(n2 != null) {
                    int a2 = temp.val + n2.val;
                    temp.val = a2 % 10;
                    n2 = n2.next;
                    if(a2 / 10 > 0 || n2 != null) {
                        temp.next = new ListNode(a2 / 10);
                        temp = temp.next;
                    }
                }
            }
        }

        return node;
    }

    /**
     * 高赞答案
     */
    public static ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode p, dummy = new ListNode(0);
        p = dummy;
        while (l1 != null || l2 != null || carry != 0) {
            if (l1 != null) {
                carry += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                carry += l2.val;
                l2 = l2.next;
            }
            p.next = new ListNode(carry%10);
            carry /= 10;
            p = p.next;
        }
        return dummy.next;
    }
}
