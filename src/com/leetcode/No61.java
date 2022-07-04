package com.leetcode;

/**
 * @Author: Felix
 * @Description: 旋转链表
 * 给你一个链表的头节点 head ，旋转链表，将链表每个节点向右移动 k 个位置。
 */
public class No61 {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3)));
        ListNode listNode = rotateRight(head, 2000000000);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }

    public static ListNode rotateRight(ListNode head, int k) {
        if (head == null) return null;
        int count = listNodeLength(head);
        if (k == 0 || k % count == 0) return head;
        ListNode newHead = null;
        ListNode pre = null;
        for (int i = 0; i < k; i++) {
            newHead = findLast(head);
            ListNode cur = head;
            while (cur != newHead) {
                pre = cur;
                cur = cur.next;
            }
            pre.next = null;
            newHead.next = head;
            head = newHead;
        }
        return newHead;
    }

    public static ListNode findLast(ListNode head) {
        ListNode last = null;
        while (head != null) {
            last = head;
            head = head.next;
        }
        return last;
    }

    public static int listNodeLength(ListNode head) {
        int count = 0;
        while (head != null) {
            count++;
            head = head.next;
        }
        return count;
    }
}
