package com.xuyang.algorithm.offer;

import com.xuyang.algorithm.common.ListNode;

/**
 * @Auther: allanyang
 * @Date: 2019/11/16 14:00
 * @Description:
 *
 * 输入一个链表，反转链表后，输出新链表的表头。
 */
public class O_15_反转链表 {

    public ListNode ReverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode pre = null;
        ListNode cur = head;

        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        return pre;
    }

    public ListNode ReverseList1(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode node = ReverseList1(head.next);
        head.next.next = head;
        head.next = null;

        return node;
    }

}