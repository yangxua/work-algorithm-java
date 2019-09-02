package com.xuyang.algorithm.leetcode;

import com.xuyang.algorithm.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: allanyang
 * @Date: 2019/8/23 14:43
 * @Description:
 *
 * 给定一个整数 n，生成所有由 1 ... n 为节点所组成的二叉搜索树。
 *
 * 输入: 3
 * 输出:
 * [
 *   [1,null,3,2],
 *   [3,2,null,1],
 *   [3,1,null,null,2],
 *   [2,1,3],
 *   [1,null,2,null,3]
 * ]
 * 解释:
 * 以上的输出对应以下 5 种不同结构的二叉搜索树：
 *
 *    1         3     3      2      1
 *     \       /     /      / \      \
 *      3     2     1      1   3      2
 *     /     /       \                 \
 *    2     1         2                 3
 *
 */
public class X_95_不同的二叉搜索树Ⅱ {

    public List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return new ArrayList<>();
        }

        return process(1, n);
    }

    /**
     * 此节点返回的
     */
    private List<TreeNode> process(int start, int end) {
        List<TreeNode> res = new ArrayList<>();
        if (start > end) {
            res.add(null);
            return res;
        }

        List<TreeNode> leftTree;
        List<TreeNode> rightTree;
        for (int i = start; i <= end; i++) {
            leftTree = process(start, i-1);
            rightTree = process(i+1, end);
            for (TreeNode left : leftTree) {
                for (TreeNode right : rightTree) {
                    TreeNode node = new TreeNode(i);
                    node.left = left;
                    node.right = right;
                    res.add(node);//此处每个节点都会加一次，总共15次
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        X_95_不同的二叉搜索树Ⅱ s = new X_95_不同的二叉搜索树Ⅱ();
        System.out.println(s.generateTrees(3).size());
    }

}