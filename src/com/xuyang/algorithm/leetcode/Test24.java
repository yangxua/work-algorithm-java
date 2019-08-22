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
public class Test24 {

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
            next.next = head;
            pre.next = next;
            pre = cur.next;//注意这里一次是三个节点间的转换，所以一次要跳跃2个节点
            cur = pre.next;
        }

        return dummy.next;
    }
}