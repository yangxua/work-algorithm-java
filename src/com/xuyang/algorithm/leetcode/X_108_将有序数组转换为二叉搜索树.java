package com.xuyang.algorithm.leetcode;

import com.xuyang.algorithm.common.TreeNode;

/**
 * @Auther: allanyang
 * @Date: 2019/9/3 21:51
 * @Description:
 *
 * 将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
 *
 * 示例:
 * 给定有序数组: [-10,-3,0,5,9],
 * 一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：
 *
 *       0
 *      / \
 *    -3   9
 *    /   /
 *  -10  5
 *
 */
public class X_108_将有序数组转换为二叉搜索树 {

    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) {
            return null;
        }

        return process(nums, 0, nums.length-1);
    }

    private TreeNode process(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }

        TreeNode node = new TreeNode(nums[(left+right)/2]);
        node.left = process(nums,left, (left+right)/2-1);
        node.right = process(nums,(left+right)/2+1, right);

        return node;
    }
}