package com.xuyang.algorithm.leetcode;

import com.xuyang.algorithm.common.ListNode;

/**
 * @Auther: allanyang
 * @Date: 2019/8/22 19:12
 * @Description:
 *
 *反转一个单链表。
 *
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 *
 */
public class X_206_反转链表 {

    /**
     * 迭代方法
     *
     * 注意循环过程中每一次向后走一步即可
     */
    public ListNode reverseList(ListNode head) {
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


    /**
     * 迭代方法
     */
    public ListNode reverseList1(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode node = reverseList1(head.next);
        head.next.next = head;
        head.next = null;

        return node;
    }
}