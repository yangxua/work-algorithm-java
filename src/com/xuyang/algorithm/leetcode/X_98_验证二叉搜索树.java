package com.xuyang.algorithm.leetcode;

import com.xuyang.algorithm.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: allanyang
 * @Date: 2019/8/24 10:35
 * @Description:
 *
 * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 *
 * 假设一个二叉搜索树具有如下特征：
 * 节点的左子树只包含小于当前节点的数。
 * 节点的右子树只包含大于当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 *
 * 示例 1:
 * 输入:
 *     2
 *    / \
 *   1   3
 * 输出: true
 *
 * 示例 2:
 * 输入:
 *     5
 *    / \
 *   1   4
 *      / \
 *     3   6
 * 输出: false
 * 解释: 输入为: [5,1,4,null,null,3,6]。
 *      根节点的值为 5 ，但是其右子节点值为 4 。
 *
 *
 */
public class X_98_验证二叉搜索树 {

    /**
     * 中序遍历
     *
     * 然后看数据是否是递增的
     */
    List<Integer> inOrderList = new ArrayList<>();
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }

        inorder(root);

        int pre = inOrderList.get(0);
        for (int i = 1; i < inOrderList.size(); i++) {
            if (inOrderList.get(i) <= pre) {
                return false;
            }
            pre = inOrderList.get(i);
        }

        return true;
    }

    private void inorder(TreeNode root) {
        if (root == null) {
            return ;
        }

        inorder(root.left);
        inOrderList.add(root.val);
        inorder(root.right);
    }


    /**
     * 递归法
     *
     * 这里小心不要只和左右节点相比较，应该和左字树或右子树比较，因此把root的节点值存起来当作最大或最小值。
     */
    public boolean isValidBST1(TreeNode root) {
        if (root == null) {
            return true;
        }

        return process(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean process(TreeNode root, long minValue, long maxValue) {
        if (root == null) {
            return true;
        }

        if (root.val <= minValue) {
            return false;
        }
        if (root.val >= maxValue) {
            return false;
        }

        return process(root.left, minValue, root.val) && process(root.right, root.val, maxValue);
    }

}