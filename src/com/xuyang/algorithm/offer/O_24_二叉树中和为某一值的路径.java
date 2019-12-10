package com.xuyang.algorithm.offer;

import com.xuyang.algorithm.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: allanyang
 * @Date: 2019/11/18 10:03
 * @Description:
 *
 * 输入一颗二叉树的跟节点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 * (注意: 在返回值的list中，数组长度大的数组靠前)
 */
public class O_24_二叉树中和为某一值的路径 {

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        if (root == null) {
            return new ArrayList<>();
        }

        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        process(root, target, res, list);

        return res;
    }

    private void process(TreeNode root, int target,
                         ArrayList<ArrayList<Integer>> res,
                         List<Integer> list) {
        if (root == null || root.val > target) {
            return ;
        }

        list.add(root.val);
        target -= root.val;

        if (root.left == null && root.right == null && target == 0) {
            res.add(new ArrayList<Integer>(list));
            list.remove(list.size()-1);
            return ;
        }

        process(root.left, target, res, list);
        process(root.right, target, res, list);
        list.remove(list.size()-1);
    }


}