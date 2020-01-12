package com.xuyang.algorithm;

import com.xuyang.algorithm.common.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Auther: allanyang
 * @Date: 2019/11/6 18:05
 * @Description:
 * 开始的时候写在这个上面，如果已经ac之后再粘贴到对应的文件
 * 或已经cr的想再次练习，可以用这个文件
 */
public class Test {

    public static void main(String[] args) {
        System.out.println(reverse1("www.toutiao.p/hello/index.com"));
    }

    public static String reverse1(String s) {
        char[] chars = s.toCharArray();
        reverseString(chars);
        s = new String(chars);
        String[] split = s.split("\\.");
        StringBuilder sb = new StringBuilder();
        for (int i = 0;i < split.length;i++) {
            char[] chars1 = split[i].toCharArray();
            reverseString(chars1);
            sb.append(new String(chars1)).append(".");
        }
        return sb.toString().substring(0,sb.length()-1);
    }

    /**
     * 迭代
     */
    public static void reverseString(char[] s) {
        if (s.length <= 1) {
            return ;
        }

        for (int i = 0;i <= (s.length-1)/2;i++) {
            swap(s, i, s.length-1-i);
        }
    }

    private static void swap(char[] arr, int i, int j) {
        char tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int rest = 0, run = 0, start = 0;
        for (int i = 0; i < gas.length; ++i) {
            run += (gas[i] - cost[i]);
            rest += (gas[i] - cost[i]);
            if (run < 0) {
                start = i + 1;
                run = 0;
            }
        }
        return rest < 0 ? -1 : start;

    }

    public static int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        int k = 1;
        for (int i = 0; i < nums.length; i++) {
            res[i] = k;
            k *= nums[i];
        }
        k = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            res[i] *= k;
            k *= nums[i];
        }

        return res;
    }


    public List<String> generateParenthesis(int n) {
        if (n == 0) {
            return new ArrayList<>();
        }

        return process(new ArrayList<>(), n, n, "");
    }

    private List<String> process(List<String> res, int left, int right, String s) {
        if (left == 0 && right == 0) {
            res.add(s);
            return res;
        }

        if (left > right || left < 0 || right < 0) {
            return res;
        }

        s += '(';
        process(res, left - 1, right, s);
        s = s.substring(0, s.length() - 1);

        s += ')';
        process(res, left, right - 1, s);

        return res;
    }

    public void preOrder1(TreeNode root) {
        if (root == null) {
            return;
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
            return;
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

        int[] dp = new int[amount + 1];

        for (int i = 1; i <= coins.length; i++) {
            int coin = coins[i - 1];
            for (int j = coin; j <= amount; j++) {
                if (coin == j) {
                    dp[j] = 1;
                } else if (dp[j] == 0 && dp[j - coin] != 0) {
                    dp[j] = dp[j - coin] + 1;
                } else if (dp[j - coin] != 0) {
                    dp[j] = Math.max(dp[j], dp[j - coin]);
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

}