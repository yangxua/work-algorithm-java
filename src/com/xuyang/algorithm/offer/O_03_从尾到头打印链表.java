package com.xuyang.algorithm.offer;

import com.xuyang.algorithm.common.ListNode;

import java.util.ArrayList;

/**
 * @Auther: allanyang
 * @Date: 2019/11/16 11:23
 * @Description:
 *
 * 输入一个链表，按链表从尾到头的顺序返回一个ArrayList。
 */
public class O_03_从尾到头打印链表 {

    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        if (listNode == null) {
            return new ArrayList<>();
        }

        ArrayList<Integer> res = new ArrayList<>();
        ListNode pre = null;
        ListNode cur = listNode;

        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        while (pre != null) {
            res.add(pre.val);
            pre = pre.next;
        }

        return res;
    }



    public ArrayList<Integer> printListFromTailToHead1(ListNode listNode) {
        if (listNode == null) {
            return new ArrayList<>();
        }

        return process(listNode, new ArrayList<Integer>());
    }

    private ArrayList<Integer> process(ListNode node, ArrayList<Integer> list) {
        if (node == null) {
            return list;
        }

        process(node.next, list);
        list.add(node.val);

        return list;
    }
}