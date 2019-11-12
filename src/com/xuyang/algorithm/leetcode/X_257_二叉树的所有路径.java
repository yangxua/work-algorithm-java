package com.xuyang.algorithm.leetcode;

import com.xuyang.algorithm.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: allanyang
 * @Date: 2019/11/11 19:37
 * @Description:
 *
 * 给定一个二叉树，返回所有从根节点到叶子节点的路径。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例:
 * 输入:
 *
 *    1
 *  /   \
 * 2     3
 *  \
 *   5
 *
 * 输出: ["1->2->5", "1->3"]
 *
 * 解释: 所有根节点到叶子节点的路径为: 1->2->5, 1->3
 */
public class X_257_二叉树的所有路径 {

    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<String> res = new ArrayList<>();
        process(root, res, "");

        return res;
    }

    private void process(TreeNode root, List<String> res, String s) {
        if (root == null) {
            return ;
        }

        s = s + "->" + root.val;

        if (root.left == null && root.right == null) {
            res.add(s.substring(2));
            return ;
        }

        process(root.left, res, s);
        process(root.right, res, s);
    }
}