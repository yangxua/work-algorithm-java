package com.xuyang.algorithm.offer;

import com.xuyang.algorithm.common.TreeNode;

/**
 * @Auther: allanyang
 * @Date: 2019/12/3 17:11
 * @Description:
 *
 * 请实现一个函数，用来判断一颗二叉树是不是对称的。注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
 */
public class O_58_对称的二叉树 {

    boolean isSymmetrical(TreeNode pRoot)
    {
        if (pRoot == null) {
            return true;
        }

        return process(pRoot.left, pRoot.right);
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