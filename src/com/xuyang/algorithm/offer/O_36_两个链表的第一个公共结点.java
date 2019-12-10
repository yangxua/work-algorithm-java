package com.xuyang.algorithm.offer;

import com.xuyang.algorithm.common.ListNode;

/**
 * @Auther: allanyang
 * @Date: 2019/11/19 14:25
 * @Description:
 *
 * 输入两个链表，找出它们的第一个公共结点。
 */
public class O_36_两个链表的第一个公共结点 {

    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if(pHead1 == null || pHead2 == null) {
            return null;
        }

        ListNode head1 = pHead1;
        ListNode head2 = pHead2;

        while (head1 != head2) {
            head1 = head1 == null ? pHead2 : head1.next;
            head2 = head2 == null ? pHead1 : head2.next;
        }

        return head1;
    }
}