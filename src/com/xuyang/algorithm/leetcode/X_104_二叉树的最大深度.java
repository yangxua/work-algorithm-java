package com.xuyang.algorithm.leetcode;


import com.xuyang.algorithm.common.TreeNode;

/**
 * @Auther: allanyang
 * @Date: 2019/8/22 20:46
 * @Description:
 */
public class X_104_二叉树的最大深度 {

    /**
     * 递归方法
     * 时间：O(N)
     * 平均空间：O(lgN)
     * 最差空间：O（N）
     */
    public int maxDepth(TreeNode root) {
        return root == null ? 0 : Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}