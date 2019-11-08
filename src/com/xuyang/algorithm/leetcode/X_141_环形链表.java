package com.xuyang.algorithm.leetcode;

import com.xuyang.algorithm.common.ListNode;

/**
 * @Auther: allanyang
 * @Date: 2019/11/8 17:21
 * @Description:
 *
 * 给定一个链表，判断链表中是否有环。
 *
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
 *
 */
public class X_141_环形链表 {

    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return false;
        }

        ListNode fast = head.next.next;
        ListNode slow = head.next;

        while (fast != null && fast.next != null) {
            if (fast == slow) {
                return true;
            }
            fast = fast.next.next;
            slow = slow.next;
        }

        return false;
    }
}