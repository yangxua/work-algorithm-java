package com.xuyang.algorithm.leetcode;

import com.xuyang.algorithm.common.ListNode;

/**
 * @Auther: allanyang
 * @Date: 2019/9/3 20:10
 * @Description:
 *
 * 请判断一个链表是否为回文链表。
 *
 * 示例 1:
 * 输入: 1->2
 * 输出: false
 * 示例 2:
 * 输入: 1->2->2->1
 * 输出: true
 */
public class X_234_回文链表 {

    /**
     * 此方法修改入参，其实是不合理的。
     * 这里只提供了核心代码，正确的代码当确定好返回值之后，应该把入参恢复原样
     */
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }

        // 此处会先走一步,因此如果是偶数的话1-2-3-4-null,此时fast=null, slow等于3,如果是奇数的话,fast仍然为null位置(只不过值为5),slow等于3
        // 如果没有先走这一步,则slow会落在2的位置,fast=4,而奇数的时候,slow等于3,fast为5的位置
        // 因此如果是奇数的话,都为中间,而偶数的话,先走fast会在null,slow会在右中位数,而没先走fast会在最后节点,slow会在左中位数
        // @todo 上面说的好像有问题
        ListNode fast = head.next.next;
        ListNode slow = head.next;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode reverseNode = reverseList(slow);

        while (head != null && reverseNode != null) {
            if (head.val != reverseNode.val) {
                return false;
            }
            head = head.next;
            reverseNode = reverseNode.next;
        }

        return true;
    }

    private ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode node = reverseList(head.next);
        head.next.next = head;
        head.next = null;

        return node;
    }

}