package com.xuyang.algorithm.common;

/**
 * @Auther: allanyang
 * @Date: 2019/9/24 17:47
 * @Description:
 */
public class Node {

    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val,Node _left,Node _right,Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}