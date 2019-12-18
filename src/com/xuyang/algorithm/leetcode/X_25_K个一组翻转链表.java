package com.xuyang.algorithm.leetcode;

import com.xuyang.algorithm.common.ListNode;

/**
 * @Auther: allanyang
 * @Date: 2019/12/17 20:28
 * @Description:
 *
 * 给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
 * k 是一个正整数，它的值小于或等于链表的长度。
 * 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 * 示例 :
 * 给定这个链表：1->2->3->4->5
 * 当 k = 2 时，应当返回: 2->1->4->3->5
 * 当 k = 3 时，应当返回: 3->2->1->4->5
 */
public class X_25_K个一组翻转链表 {

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) {
            return null;
        }

        ListNode dummy = new ListNode(1);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode end = dummy;

        while (end.next != null) {
            for (int i = 0;i < k && end != null;i++) {
                end = end.next;
            }
            if (end == null) {
                break;
            }

            ListNode start = pre.next;
            ListNode next = end.next;
            end.next = null;
            pre.next = reverse(start);
            start.next = next;
            pre = start;
            end = pre;
        }

        return dummy.next;
    }

    private ListNode reverse(ListNode head) {
        ListNode pre = null;
        ListNode node = head;

        while (node != null) {
            ListNode next = node.next;
            node.next = pre;
            pre = node;
            node = next;
        }

        return pre;
    }
}