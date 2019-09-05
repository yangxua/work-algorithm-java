package com.xuyang.algorithm.leetcode;

import com.xuyang.algorithm.common.TreeNode;

/**
 * @Auther: allanyang
 * @Date: 2019/9/3 21:35
 * @Description:
 *
 * 给定一个二叉树，检查它是否是镜像对称的。
 *
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
 *     1
 *    / \
 *   2   2
 *    \   \
 *    3    3
 *
 */
public class X_101_对称二叉树 {

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }

        return process(root.left, root.right);
    }

    private boolean process(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }

        return left.val == right.val && process(left.left, right.right) && process(left.right, right.left);
    }

}