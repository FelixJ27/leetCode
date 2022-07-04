package com.leetcode;

/**
 * @Author: Felix
 * @Description: 给你一个链表数组，每个链表都已经按升序排列。请你将所有链表合并到一个升序链表中，返回合并后的链表。
 */
public class MergeKLists {
    public class ListNode {
        int val;
        RemoveNthFromEnd.ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, RemoveNthFromEnd.ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        return null;
    }
}
