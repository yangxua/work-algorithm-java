package com.xuyang.algorithm.leetcode;

import com.xuyang.algorithm.common.Node;

import java.util.LinkedList;

/**
 * @Auther: allanyang
 * @Date: 2019/9/24 17:46
 * @Description:
 */
public class X_116_填充每个节点的下一个右侧节点指针 {

    public Node connect(Node root) {
        if (null == root) {
            return null;
        }

        LinkedList<Node> queue = new LinkedList<>();
        Node last = root;
        Node nlast = null;
        Node tmp = root;
        queue.add(last);

        while (!queue.isEmpty()) {
            tmp = queue.poll();
            tmp.next = queue.peek();
            if (tmp.left != null) {
                queue.add(tmp.left);
                nlast = tmp.left;
            }
            if (tmp.right != null) {
                queue.add(tmp.right);
                nlast = tmp.right;
            }
            if (tmp == last) {
                last = nlast;
                tmp.next = null;
            }
        }

        return root;
    }
}