package com.xuyang.algorithm.offer;

import com.xuyang.algorithm.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @Auther: allanyang
 * @Date: 2019/12/3 17:28
 * @Description:
 *
 * 请实现一个函数按照之字形打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右至左的顺序打印，第三行按照从左到右的顺序打印，其他行以此类推。
 */
public class O_59_按之字形顺序打印二叉树 {

    public ArrayList<ArrayList<Integer> > Print(TreeNode pRoot) {
        if (pRoot == null) {
            return new ArrayList<>();
        }

        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        LinkedList<Integer> list = new LinkedList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        boolean reverse = false;
        TreeNode node = null;
        queue.add(pRoot);

        while (!queue.isEmpty()) {
            int size = queue.size();

            while (size-- > 0) {
                node = queue.pollFirst();

                if (!reverse) {
                    list.add(node.val);
                } else {
                    list.addFirst(node.val);
                }

                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }

            res.add(new ArrayList(list));
            list = new LinkedList<>();
            reverse = !reverse;
        }

        return res;
    }
}