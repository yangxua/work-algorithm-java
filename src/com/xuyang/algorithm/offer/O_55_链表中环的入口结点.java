package com.xuyang.algorithm.offer;

import com.xuyang.algorithm.common.ListNode;

/**
 * @Auther: allanyang
 * @Date: 2019/12/3 16:24
 * @Description:
 *
 * 给一个链表，若其中包含环，请找出该链表的环的入口结点，否则，输出null。
 */
public class O_55_链表中环的入口结点 {

    public ListNode EntryNodeOfLoop(ListNode pHead)
    {
        if (pHead == null || pHead.next == null || pHead.next.next == null) {
            return null;
        }

        ListNode head = pHead;
        ListNode fast = head.next.next;
        ListNode slow = head.next;

        while (fast != slow) {
            if (fast == null || fast.next == null) {
                return null;
            }
            fast = fast.next.next;
            slow = slow.next;
        }

        fast = head;

        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }

        return fast;
    }
}