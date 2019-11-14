package com.xuyang.algorithm.leetcode;

/**
 * @Auther: allanyang
 * @Date: 2019/9/29 15:25
 * @Description: 518,322
 *
 * 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。
 *
 * 示例 1:
 * 输入: coins = [1, 2, 5], amount = 11
 * 输出: 3
 * 解释: 11 = 5 + 5 + 1
 * 示例 2:
 * 输入: coins = [2], amount = 3
 * 输出: -1
 *
 */
public class X_322_零钱兑换 {

    public int coinChange(int[] coins, int amount) {
        if (coins.length == 0) {
            return -1;
        }

        int[] dp = new int[amount+1];
        for (int i = 1; i <= amount;i++) {
            dp[i] = (i % coins[0] == 0) ? i / coins[0] : amount+1;
        }

        for (int i = 1; i < coins.length;i++) {
            for (int j = 1;j <= amount;j++) {
                if (j >= coins[i]) {
                    dp[j] = Math.min(dp[j], dp[j-coins[i]] + 1);
                }
            }
        }

        return dp[amount] > amount ? -1 : dp[amount];
    }

    /**
     * 因为可以重复使用，所以是完全背包
     * 完全背包和01背包的套路就是把第二部的逆序改成顺序
     */
    public int coinChange1(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }

        int[] dp = new int[amount+1];

        for (int i = 1;i <= coins.length;i++) {
            int coin = coins[i-1];
            for (int j = coin;j <= amount;j++) { //因为是完全背包，所以这里是顺序的
                if (coin == j) {
                    dp[j] = 1;
                } else if (dp[j] == 0 && dp[j-coin] != 0) {
                    dp[j] = dp[j-coin] + 1;
                } else if (dp[j-coin] != 0){
                    dp[j] = Math.min(dp[j], dp[j-coin]);
                }
            }
        }

        return dp[amount] == 0 ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        X_322_零钱兑换 s = new X_322_零钱兑换();
        System.out.println(s.coinChange(new int[]{1,2,5}, 11));

    }
}