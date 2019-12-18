package com.xuyang.algorithm;

import com.xuyang.algorithm.common.TreeNode;
import com.xuyang.algorithm.dp.Packet;

import java.util.Stack;

/**
 * @Auther: allanyang
 * @Date: 2019/11/6 18:05
 * @Description:
 * 开始的时候写在这个上面，如果已经ac之后再粘贴到对应的文件
 * 或已经cr的想再次练习，可以用这个文件
 */
public class Test {

    public void preOrder1(TreeNode root) {
        if (root == null) {
            return ;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            root = stack.pop();

            System.out.println(root.val);
            if (root.right != null) {
                stack.push(root.right);
            }
            if (root.left != null) {
                stack.push(root.left);
            }
        }
    }

    public void inOrder1(TreeNode root) {
        if (root == null) {
            return ;
        }

        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || root != null) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                root = stack.pop();

                System.out.println(root);
                root = root.right;
            }
        }
    }

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }

        return process(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean process(TreeNode root, int minValue, int maxValue) {
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


    private boolean isValid(int i, String haystack, String needle) {
        int index = 0;
        while (index < needle.length() && haystack.charAt(i) == needle.charAt(index)) {
            i++;
            index++;
        }
        return index == needle.length();
    }

    public int coinChange(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }

        int[] dp = new int[amount+1];

        for (int i = 1;i <= coins.length;i++) {
            int coin = coins[i-1];
            for (int j = coin;j <= amount;j++) {
                if (coin == j) {
                    dp[j] = 1;
                } else if (dp[j] == 0 && dp[j-coin] != 0) {
                    dp[j] = dp[j-coin] + 1;
                } else if (dp[j-coin] != 0){
                    dp[j] = Math.max(dp[j], dp[j-coin]);
                }
            }
        }

        return dp[amount] == 0 ? -1 : dp[amount];
    }


    public void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        Packet s = new Packet();
        s.packet01_1(4,new int[]{1,2,5},new int[]{1,2,5});
    }
}