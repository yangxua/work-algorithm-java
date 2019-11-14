package com.xuyang.algorithm.leetcode;

/**
 * @Auther: allanyang
 * @Date: 2019/11/14 20:19
 * @Description:
 *
 * 给定一个由正整数组成且不存在重复数字的数组，找出和为给定目标正整数的组合的个数。
 *
 * 示例:
 *
 * nums = [1, 2, 3]
 * target = 4
 *
 * 所有可能的组合为：
 * (1, 1, 1, 1)
 * (1, 1, 2)
 * (1, 2, 1)
 * (1, 3)
 * (2, 1, 1)
 * (2, 2)
 * (3, 1)
 *
 * 请注意，顺序不同的序列被视作不同的组合。
 *
 * 因此输出为 7。
 *
 */
public class X_377_组合总和Ⅳ {

    public int combinationSum4(int[] nums, int target) {
        if (target < 0) {
            return 0;
        }

        int[] dp = new int[target+1];
        dp[0] = 1;

        for (int i = 1;i <= target;i++) {
            for (int j = 1;j <= nums.length;j++) {
                if (i >= nums[j-1]) {
                    dp[i] += dp[i-nums[j-1]];
                }
            }
        }

        return dp[target];
    }
}