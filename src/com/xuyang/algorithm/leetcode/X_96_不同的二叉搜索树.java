package com.xuyang.algorithm.leetcode;

import com.xuyang.algorithm.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: allanyang
 * @Date: 2019/8/23 15:09
 * @Description:
 *
 * 给定一个整数 n，求以 1 ... n 为节点组成的二叉搜索树有多少种？
 *
 * 示例:
 * 输入: 3
 * 输出: 5
 * 解释:
 * 给定 n = 3, 一共有 5 种不同结构的二叉搜索树:
 *
 *    1         3     3      2      1
 *     \       /     /      / \      \
 *      3     2     1      1   3      2
 *     /     /       \                 \
 *    2     1         2                 3
 *
 */
public class X_96_不同的二叉搜索树 {

    /**
     * 暴力法
     */
    public int numTrees(int n) {
        if (n == 0) {
            return 0;
        }

        List<TreeNode> res = process(1, n);
        return res.size();
    }

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
                    res.add(node);
                }
            }
        }

        return res;
    }

    /**
     * 递归法
     *
     *
     * 结题思路：
     *        假设n个节点存在二叉排序树的个数是G(n)，1为根节点，2为根节点，...，n为根节点，当1为根节点时，
     *        其左子树节点个数为0，右子树节点个数为n-1，同理当2为根节点时，其左子树节点个数为1，右子树节点为n-2，
     *        所以可得G(n) = G(0)*G(n-1)+G(1)*(n-2)+...+G(n-1)*G(0)
     */
    public int numTrees1(int n) {
        if (n <= 1) {
            return 1;
        }

        int res = 0;
        for (int i = 1;i <= n;i++) {
            res += numTrees1(i-1) * numTrees1(n-i);
        }

        return res;
    }


    /**
     * 动态规划
     */
    public int numTrees2(int n) {
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            for (int j = 1;j <= i;j++) {
                dp[i] += dp[j-1] * dp[i-j];
            }
        }

        return dp[n];
    }

    /**
     * 数学法，具体详情请查看卡特兰数
     */
    public int numTrees3(int n) {
        long res = 1;

        for (int i = 0; i < n; ++i) {
            res = res * 2 * (2 * i + 1) / (i + 2);
        }

        return (int) res;
    }



}