package com.xuyang.algorithm.leetcode;

import com.xuyang.algorithm.common.ListNode;

/**
 * @Auther: allanyang
 * @Date: 2019/11/7 11:06
 * @Description:
 *
 * 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
 *
 * 示例 1:
 * 输入: 1->1->2
 * 输出: 1->2
 * 示例 2:
 * 输入: 1->1->2->3->3
 * 输出: 1->2->3
 *
 */
public class X_83_删除排序链表中的重复元素 {

    /**
     * 迭代法
     */
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            while (next != null && next.val == cur.val) {
                next = next.next;
            }
            cur.next = next;
            cur = next;
        }

        return head;
    }

    /**
     * 递归法
     */
    public ListNode deleteDuplicates1(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        head.next = deleteDuplicates1(head.next);

        return head.val == head.next.val ? head.next : head;
    }
}