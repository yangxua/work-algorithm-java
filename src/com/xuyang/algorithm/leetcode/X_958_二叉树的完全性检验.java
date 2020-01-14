package com.xuyang.algorithm.leetcode;

import com.xuyang.algorithm.common.TreeNode;

import java.util.LinkedList;

/**
 * @Auther: allanyang
 * @Date: 2020/1/13 11:17
 * @Description:
 *
 * 给定一个二叉树，确定它是否是一个完全二叉树。
 *
 * 百度百科中对完全二叉树的定义如下：
 * 若设二叉树的深度为 h，除第 h 层外，其它各层 (1～h-1) 的结点数都达到最大个数，第 h 层所有的结点都连续集中在最左边，这就是完全二叉树。（注：第 h 层可能包含 1~ 2h 个节点。）
 *
 */
public class X_958_二叉树的完全性检验 {

    /**
     * 按层遍历
     */
    public boolean isCompleteTree(TreeNode root) {
        boolean end = false;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.pollFirst();

            //如果某个节点为null了，那么就标记为最后节点，如果后续还存在不null节点，直接返回false
            if (node == null) {
                end = true;
            } else {
                if (end) {
                    return false;
                }
                queue.add(node.left);
                queue.add(node.right);
            }
        }

        return true;
    }
}