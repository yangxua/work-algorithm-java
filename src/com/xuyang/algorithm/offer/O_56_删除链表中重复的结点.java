package com.xuyang.algorithm.offer;

import com.xuyang.algorithm.common.ListNode;

/**
 * @Auther: allanyang
 * @Date: 2019/12/3 16:39
 * @Description:
 *
 * 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
 */
public class O_56_删除链表中重复的结点 {

    public ListNode deleteDuplication(ListNode pHead)
    {
        if (pHead == null || pHead.next == null) {
            return pHead;
        }

        ListNode dummy = new ListNode(pHead.val == -1 ? -2 : -1);
        dummy.next = pHead;
        ListNode pre = dummy;
        ListNode cur = pHead;

        while (cur != null && cur.next != null) {
            if (cur.val == cur.next.val) {
                int value = cur.val;
                while (cur != null && cur.val == value) {
                    cur = cur.next;
                }
                pre.next = cur;
            } else {
                pre = cur;
                cur = cur.next;
            }
        }

        return dummy.next;
    }
}