package com.myxh.leetcode.sort;

import com.myxh.leetcode.linkedlist.ListNode;
import com.myxh.leetcode.linkedlist.ListUtils;

/**
 * Sort a linked list using insertion sort.
 *
 * Algorithm of Insertion Sort:
 *
 * Insertion sort iterates, consuming one input element each repetition, and growing a sorted output list.
 * At each iteration, insertion sort removes one element from the input data, finds the location it belongs within the sorted list, and inserts it there.
 * It repeats until no input elements remain.
 *
 * Example 1:
 *
 * Input: 4->2->1->3
 * Output: 1->2->3->4
 * Example 2:
 *
 * Input: -1->5->3->4->0
 * Output: -1->0->3->4->5
 */
public class L147_InsertionSortList {

    public static void main(String[] args) {
        ListUtils.print(insertionSortList(ListUtils.getList(new int[]{4, 2, 1, 3, 5})));
    }

    /**
     * Runtime: 3 ms, faster than 94.96% of Java online submissions for Insertion Sort List.
     * Memory Usage: 36.2 MB, less than 100.00% of Java online submissions for Insertion Sort List.
     */
    public static ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        //记录排序后的头结点
        ListNode result = head;
        //已排序区间尾节点
        ListNode tail = head;
        //要插入的目标节点
        ListNode next = head.next;
        //已排序区间遍历时，指针的前置节点
        ListNode pre;
        //已排序区间遍历时指针
        ListNode tmp;
        while (next != null) {
            tmp = result;
            pre = null;
            //如果已排序区间尾节点小于目标节点，直接指针后移
            if (tail.val <= next.val) {
                tail = next;
                next = next.next;
                continue;
            }
            //遍历已排序区间，找到第一个大于目标节点，插入
            while (tmp.next != next || tmp == tail) {
                if (tmp.val <= next.val) {
                    pre = tmp;
                    tmp = tmp.next;
                } else {
                    tail.next = next.next;
                    next.next = tmp;
                    if (pre != null) {
                        pre.next = next;
                    } else {
                        //更新头结点
                        result = next;
                    }
                    next = tail.next;
                    break;
                }
            }

        }
        return result;
    }

    /**
     * 高赞答案
     */
    public ListNode insertionSortList1(ListNode head) {
        if( head == null ){
            return head;
        }

        ListNode helper = new ListNode(0); //new starter of the sorted list
        ListNode cur = head; //the node will be inserted
        ListNode pre = helper; //insert node between pre and pre.next
        ListNode next = null; //the next node will be inserted
        //not the end of input list
        while( cur != null ){
            next = cur.next;
            //find the right place to insert
            while( pre.next != null && pre.next.val < cur.val ){
                pre = pre.next;
            }
            //insert between pre and pre.next
            cur.next = pre.next;
            pre.next = cur;
            pre = helper;
            cur = next;
        }

        return helper.next;
    }
}
