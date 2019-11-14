package com.xuyang.algorithm.leetcode;

/**
 * @Auther: allanyang
 * @Date: 2019/11/14 11:05
 * @Description:
 *
 * 给定一个只包含正整数的非空数组。是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
 *
 * 注意:
 * 每个数组中的元素不会超过 100
 * 数组的大小不会超过 200
 * 示例 1:
 * 输入: [1, 5, 11, 5]
 * 输出: true
 * 解释: 数组可以分割成 [1, 5, 5] 和 [11].
 *
 * 示例 2:
 * 输入: [1, 2, 3, 5]
 * 输出: false
 * 解释: 数组不能分割成两个元素和相等的子集.
 *
 */
public class X_416_分割等和子集 {

    /**
     * 这一题相当于01背包，其中背包总重量是sum/2，每个物品的重量和价值相等，都分别是nums[i]
     */
    public boolean canPartition(int[] nums) {
        int sum = getSum(nums);
        if (sum % 2 == 1) {
            return false;
        }

        boolean[] dp = new boolean[sum/2+1];
        dp[0] = true;

        for (int i = 1;i < nums.length;i++) {
            int val = nums[i];
            for (int j = sum/2;j > 0;j--) {
                if (j >= val) {
                    dp[j] = dp[j] || dp[j-val];
                }
            }
        }

        return dp[sum/2];
    }


    private int getSum(int[] nums) {
        int res = 0;

        for (int num : nums) {
            res += num;
        }

        return res;
    }

    public static void main(String[] args) {
        X_416_分割等和子集 s = new X_416_分割等和子集();
        s.canPartition(new int[]{1,2,5});
    }
}