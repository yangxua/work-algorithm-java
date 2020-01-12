package com.xuyang.algorithm.leetcode;

/**
 * @Auther: allanyang
 * @Date: 2019/9/29 16:12
 * @Description: 518,322
 *
 * 给定不同面额的硬币和一个总金额。写出函数来计算可以凑成总金额的硬币组合数。假设每一种面额的硬币有无限个。 
 *
 * 示例 1:
 * 输入: amount = 5, coins = [1, 2, 5]
 * 输出: 4
 * 解释: 有四种方式可以凑成总金额:
 * 5=5
 * 5=2+2+1
 * 5=2+1+1+1
 * 5=1+1+1+1+1
 * 示例 2:
 * 输入: amount = 3, coins = [2]
 * 输出: 0
 * 解释: 只用面额2的硬币不能凑成总金额3。
 * 示例 3:
 * 输入: amount = 10, coins = [10]
 * 输出: 1
 *
 */
public class X_518_零钱兑换II {

    public int change(int amount, int[] coins) {
        if (coins.length == 0) {
            return amount == 0 ? 1 : 0;
        }

        int[] dp = new int[amount+1];
        dp[0] = 1;
        for (int i = 1;i * coins[0] <= amount;i++) {
            dp[i * coins[0]] = 1;
        }

        for (int i = 1; i < coins.length;i++) {
            for (int j = 1;j <= amount;j++) {
                if (j >= coins[i]) {
                    dp[j] = dp[j] + dp[j-coins[i]];
                }
            }
        }

        return dp[amount];
    }

    public int change1(int amount, int[] coins) {
        int[] dp = new int[amount+1];
        dp[0] = 1;

        for (int i = 1;i <= coins.length;i++) {
            int coin = coins[i-1];
            for (int j = coin;j <= amount;j++) {
                dp[j] += dp[j-coin];
            }
        }

        return dp[amount];
    }
}