package com.xuyang.algorithm.leetcode;

import com.xuyang.algorithm.common.TreeNode;

import java.util.*;

/**
 * @Auther: allanyang
 * @Date: 2019/9/24 19:55
 * @Description:
 *
 * 给定一个二叉搜索树，编写一个函数 kthSmallest 来查找其中第 k 个最小的元素。
 *
 * 说明：
 * 你可以假设 k 总是有效的，1 ≤ k ≤ 二叉搜索树元素个数。
 *
 * 示例 1:
 * 输入: root = [3,1,4,null,2], k = 1
 *    3
 *   / \
 *  1   4
 *   \
 *    2
 * 输出: 1
 * 示例 2:
 * 输入: root = [5,3,6,2,4,null,null,1], k = 3
 *        5
 *       / \
 *      3   6
 *     / \
 *    2   4
 *   /
 *  1
 * 输出: 3
 *
 */
public class X_230_二叉搜索树中第K小的元素 {

    /**
     * 可采用固定大小k的优先级队列，来降低时间复杂度
     */
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();

        dfs(root, list);

        Collections.sort(list);

        return list.get(k-1);
    }

    private void dfs(TreeNode root, List<Integer> list) {
        if (root == null) {
            return ;
        }

        list.add(root.val);
        dfs(root.left, list);
        dfs(root.right, list);
    }


    int res = 0;
    int count = 0;
    public int kthSmallest1(TreeNode root, int k) {

        inOrder(root, k);

        return res;
    }

    private void inOrder(TreeNode root, int k) {
        if (root == null) {
            return;
        }

        inOrder(root.left, k);
        if (++count == k) {
            res = root.val;
            return;
        }

        inOrder(root.right, k);
    }

    public static void main(String[] args) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(3, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        minHeap.add(100);
        minHeap.add(101);
        minHeap.add(102);
        minHeap.add(103);
        minHeap.add(104);

        System.out.println(minHeap.poll());
        System.out.println(minHeap.poll());
        System.out.println(minHeap.poll());
        System.out.println(minHeap.poll());


    }
}