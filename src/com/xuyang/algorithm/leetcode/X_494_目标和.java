package com.xuyang.algorithm.leetcode;

/**
 * @Auther: allanyang
 * @Date: 2019/11/14 14:13
 * @Description:
 *
 * 给定一个非负整数数组，a1, a2, ..., an, 和一个目标数，S。现在你有两个符号 + 和 -。对于数组中的任意一个整数，你都可以从 + 或 -中选择一个符号添加在前面。
 *
 * 返回可以使最终数组和为目标数 S 的所有添加符号的方法数。
 *
 * 示例 1:
 *
 * 输入: nums: [1, 1, 1, 1, 1], S: 3
 * 输出: 5
 * 解释:
 *
 * -1+1+1+1+1 = 3
 * +1-1+1+1+1 = 3
 * +1+1-1+1+1 = 3
 * +1+1+1-1+1 = 3
 * +1+1+1+1-1 = 3
 *
 * 一共有5种方法让最终目标和为3。
 *
 */
public class X_494_目标和 {

    /**
     *                   sum(P) - sum(N) = target
     * sum(P) + sum(N) + sum(P) - sum(N) = target + sum(P) + sum(N)
     *                        2 * sum(P) = target + sum(nums)
     *
     *  即01背包问题，求sum(P) = (target + sum(nums))/2的个数
     */
    public int findTargetSumWays(int[] nums, int S) {
        int sum = getSum(nums);
        if (sum < S || (sum + S) % 2 == 1) {
            return 0;
        }

        int weight = (sum + S) / 2;
        int[] dp = new int[weight+1];
        dp[0] = 1;

        for (int i = 1;i < nums.length;i++) {
            for (int j = weight;j >= nums[i];j--) {
                dp[j] = dp[j] + dp[j-nums[i]];
            }
        }

        return dp[weight];
    }

    private int getSum(int[] nums) {
        int sum = 0;

        for (int num : nums) {
            sum += num;
        }

        return sum;
    }


    private int count = 0;

    /**
     * dfs
     * level : 第i层，也就是数组中第i个元素
     */
    public int findTargetSumWays1(int[] nums, int S) {
        process(nums, 0, 0, S);
        return count;
    }

    private void process(int[] nums, int level, int sum, int s) {
        if (level == nums.length) {
            if (sum == s) {
                count++;
            }
        } else {
            process(nums, level+1, sum + nums[level], s);
            process(nums, level+1, sum - nums[level], s);
        }
    }
}