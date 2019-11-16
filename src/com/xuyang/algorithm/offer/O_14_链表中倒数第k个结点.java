package com.xuyang.algorithm.offer;

import com.xuyang.algorithm.common.ListNode;

/**
 * @Auther: allanyang
 * @Date: 2019/11/16 13:51
 * @Description:
 *
 * 输入一个链表，输出该链表中倒数第k个结点。
 */
public class O_14_链表中倒数第k个结点 {

    public ListNode FindKthToTail(ListNode head, int k) {
        ListNode fast = head;
        ListNode slow = head;

        for (int i = 0;i < k;i++) {
            if (fast == null) {
                return null;
            }
            fast = fast.next;
        }

        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        return slow;
    }
}