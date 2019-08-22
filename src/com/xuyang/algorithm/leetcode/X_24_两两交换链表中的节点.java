package com.xuyang.algorithm.leetcode;

import com.xuyang.algorithm.common.ListNode;

/**
 * @Auther: allanyang
 * @Date: 2019/8/22 15:13
 * @Description: 两两交换链表中的节点
 *
 *
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *
 *
 * 给定 1->2->3->4, 你应该返回 2->1->4->3.
 *
 */
public class X_24_两两交换链表中的节点 {

    /**
     * 递归方法
     */
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode next = head.next;
        head.next = swapPairs(head.next.next);
        next.next = head;

        return next;
    }

    /**
     * 迭代方法
     */
    public ListNode swapPairs1(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = head;
        ListNode pre = dummy;

        while (cur != null && cur.next != null) {
            ListNode next = cur.next;
            cur.next = next.next;
            next.next = cur;
            pre.next = next;
            pre = cur;
            cur = cur.next;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        node1.next=node2;
        node2.next=node3;
        node3.next=node4;
        node4.next=null;
        X_24_两两交换链表中的节点 s = new X_24_两两交换链表中的节点();
        ListNode listNode = s.swapPairs1(node1);
        System.out.println(listNode);
    }
}