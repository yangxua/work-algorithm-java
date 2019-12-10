package com.xuyang.algorithm.offer;

import com.xuyang.algorithm.common.RandomListNode;

/**
 * @Auther: allanyang
 * @Date: 2019/11/18 17:47
 * @Description:
 *
 * 输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点），返回结果为复制后复杂链表的head。（注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
 */
public class O_25_复杂链表的复制 {

    /**
     *     1. 把复制的结点链接在原始链表的每一对应结点后面
     *     2. 把复制的结点的random指针指向被复制结点的random指针的下一个结点
     *     3. 拆分成两个链表，奇数位置为原链表，偶数位置为复制链表，注意复制链表的最后一个结点的next指针不能跟原链表指向同一个空结点None，next指针要重新赋值None(判定程序会认定你没有完成复制）
     */
    public RandomListNode Clone(RandomListNode pHead) {
        if (pHead == null) {
            return null;
        }

        RandomListNode head = pHead;
        while (head != null) {
            RandomListNode node = new RandomListNode(head.label);
            node.next = head.next;
            head.next = node;
            head = node.next;
        }

        head = pHead;
        RandomListNode random = null;
        while (head != null) {
            random = head.random;
            head.next.random = random == null ? null : random.next;
            head = head.next.next;
        }

        head = pHead;
        RandomListNode tmp = head.next;
        RandomListNode nHead = head.next;
        while (head.next != null) {
            tmp = head.next;
            head.next = tmp.next;
            head = tmp;
        }

        return nHead;
    }
}