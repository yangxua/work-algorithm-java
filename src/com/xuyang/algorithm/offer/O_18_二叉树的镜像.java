package com.xuyang.algorithm.offer;

import com.xuyang.algorithm.common.TreeNode;

import java.util.ArrayList;

/**
 * @Auther: allanyang
 * @Date: 2019/11/16 14:40
 * @Description:
 *
 * 题目描述
 * 操作给定的二叉树，将其变换为源二叉树的镜像。
 * 输入描述:
 * 二叉树的镜像定义：源二叉树
 *     	    8
 *     	   /  \
 *     	  6   10
 *     	 / \  / \
 *     	5  7 9 11
 *     	镜像二叉树
 *     	    8
 *     	   /  \
 *     	  10   6
 *     	 / \  / \
 *     	11 9 7  5
 */
public class O_18_二叉树的镜像 {

    public void Mirror(TreeNode root) {
        if (root == null) {
            return ;
        }

        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        Mirror(root.left);
        Mirror(root.right);
    }


}