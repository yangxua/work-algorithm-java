package com.xuyang.algorithm.offer;

import com.xuyang.algorithm.common.TreeNode;

/**
 * @Auther: allanyang
 * @Date: 2019/11/18 19:16
 * @Description:
 *
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求不能创建任何新的结点，只能调整树中结点指针的指向。
 */
public class O_26_二叉搜索树与双向链表 {

    TreeNode head = null;
    TreeNode pre = null;

    public TreeNode Convert(TreeNode pRootOfTree) {
        if (pRootOfTree == null) {
            return null;
        }

        Convert(pRootOfTree.left);
        if (pre == null) {
            pRootOfTree.left = null;
            pre = pRootOfTree;
            head = pre;
        } else {
            pRootOfTree.left = pre;
            pre.right = pRootOfTree;
            pre = pRootOfTree;
        }
        Convert(pRootOfTree.right);


        return head;
    }
}