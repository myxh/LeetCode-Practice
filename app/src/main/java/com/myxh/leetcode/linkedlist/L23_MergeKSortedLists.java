package com.myxh.leetcode.linkedlist;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
 * <p>
 * Example:
 * <p>
 * Input:
 * [
 * 1->4->5,
 * 1->3->4,
 * 2->6
 * ]
 * Output: 1->1->2->3->4->4->5->6
 */
public class L23_MergeKSortedLists {

    public static void main(String[] args) {
        ListNode[] listNodes = {ListUtils.getList(new int[]{1, 4, 5}),
                ListUtils.getList(new int[]{1, 3, 4}),
                ListUtils.getList(new int[]{2, 6})};
        ListUtils.print(mergeKLists(listNodes));
    }

    /**
     * Runtime: 3 ms, faster than 84.76% of Java online submissions for Merge k Sorted Lists.
     * Memory Usage: 40.7 MB, less than 49.18% of Java online submissions for Merge k Sorted Lists.
     */
    public static ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length < 1) {
            return null;
        } else if (lists.length == 1) {
            return lists[0];
        }
        int length = lists.length;
        //建立大小为 length + 1 的小顶堆，1~length 位置存放 lists 中的链表
        ListNode[] heap = new ListNode[length + 1];
        int k = 0;
        //将 lists 中不为空的链表放进堆中
        for (int i = 0; i < length; i++) {
            if (lists[i] != null) {
                heap[++k] = lists[i];
            }
        }
        //全部为空直接返回
        if (k <= 0) {
            return null;
        }
        //0 号位置存放堆的大小
        heap[0] = new ListNode(k + 1);
        //依次进行堆化，堆顶元素即为最小值
        for (int i = length / 2; i >= 1; i--) {
            heapify(heap, i);
        }
        ListNode tmp = new ListNode(-1);
        ListNode result = tmp;
        //不断从堆顶取出最小元素放入 tmp 链表中
        while (heap[1] != null) {
            tmp.next = heap[1];
            tmp = tmp.next;
            heap[1] = heap[1].next;
            heapify(heap, 1);
        }

        return result.next;
    }

    /**
     * 堆化
     */
    private static void heapify(ListNode[] heap, int i) {
        //如果当前位置链表已遍历完，将堆尾链表与之对换，同时缩小堆的大小
        if (heap[i] == null) {
            swap(heap, heap[0].val - 1, i);
            heap[0].val -= 1;
        }
        //从 i 往下进行堆化
        while (true) {
            int minPos = i;
            int n = heap[0].val;
            if (i * 2 < n && heap[i].val > heap[i * 2].val) {
                minPos = i * 2;
            }
            if (i * 2 + 1 < n && heap[minPos].val > heap[i * 2 + 1].val) {
                minPos = i * 2 + 1;
            }
            if (minPos == i) {
                break;
            }
            swap(heap, i, minPos);
            i = minPos;
        }
    }

    /**
     * 交换堆中元素
     */
    private static void swap(ListNode[] heap, int i, int minPos) {
        ListNode tmp = heap[i];
        heap[i] = heap[minPos];
        heap[minPos] = tmp;
    }

    /**
     * 高赞答案
     */
    public static ListNode mergeKLists1(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }

        PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>(lists.length, new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                if (o1.val < o2.val)
                    return -1;
                else if (o1.val == o2.val)
                    return 0;
                else
                    return 1;
            }
        });

        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        for (ListNode node : lists) {
            if (node != null) {
                queue.add(node);
            }
        }

        while (!queue.isEmpty()) {
            tail.next = queue.poll();
            tail = tail.next;

            if (tail.next != null)
                queue.add(tail.next);
        }
        return dummy.next;
    }
}
