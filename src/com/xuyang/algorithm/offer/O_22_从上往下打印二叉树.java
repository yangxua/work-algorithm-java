package com.xuyang.algorithm.offer;

import com.xuyang.algorithm.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @Auther: allanyang
 * @Date: 2019/11/16 15:35
 * @Description:
 *
 * 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 */
public class O_22_从上往下打印二叉树 {


    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        LinkedList<TreeNode> queue = new LinkedList<>();
        ArrayList<Integer> res = new ArrayList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();

            while (size-- > 0) {
                TreeNode node = queue.pollFirst();
                res.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }

        return res;
    }
}