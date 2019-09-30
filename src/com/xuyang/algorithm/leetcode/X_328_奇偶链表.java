package com.xuyang.algorithm.leetcode;

import com.xuyang.algorithm.common.ListNode;

/**
 * @Auther: allanyang
 * @Date: 2019/9/17 18:20
 * @Description:
 */
public class X_328_奇偶链表 {

    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return head;
        }
        ListNode dummyOdd = new ListNode(1);
        ListNode dummyEven = new ListNode(1);
        dummyOdd.next = head;
        dummyEven.next = head.next;
        ListNode odd = head;
        ListNode even = head.next;

        while (odd.next != null && even.next != null) {
            odd.next = odd.next.next;
            even.next = even.next.next;
            odd = odd.next;
            even = even.next;
        }

        odd.next = dummyEven.next;

        return dummyOdd.next;
    }
}