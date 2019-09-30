package com.xuyang.algorithm.dp;

/**
 * @Auther: allanyang
 * @Date: 2019/9/17 16:46
 * @Description:
 */
public class Coins {

    /**
     * 可以重复使用
     * 获取方法数
     * leetcode 518
     */
    public int getCount(int[] arr, int aim) {
        int count = arr.length;
        int[][] dp = new int[count][aim+1];

        //不使用任何货币有一种组成aim未0的情况
        for (int i = 0;i < count;i++) {
            dp[i][0] = 1;
        }

        //对于使用第一种类型的硬币情况
        for (int i = 1;i < aim;i++) {
            if (arr[0]*i > aim) {
                break;
            }
            dp[0][arr[0]*i] = 1;
        }

        for (int i = 1;i < count;i++) {
            for (int j = 1;j <= aim;j++) {
                dp[i][j] = dp[i-1][j];
                dp[i][j] += arr[i] > j ? 0 : dp[i-1][j-arr[i]];
            }
        }


        return dp[count-1][aim];
    }

    /**
     * 可以使用无限次
     * 最少货币数
     * leetcode 320
     */
    public int minCount(int[] arr, int aim) {
        int count = arr.length;
        int[][] dp = new int[count][aim+1];
        int max = Integer.MAX_VALUE;

        for (int i = 1;i <= aim;i++) {
            dp[0][i] = max;
            if (arr[0] >= i && dp[0][i-arr[0]] != max) {
                dp[0][i] = dp[0][i-arr[0]] + 1;
            }
        }

        int left = 0;
        for (int i = 1;i < count;i++) {
            for (int j = 1;j <= aim;j++) {
                left = max;
                if (arr[i] >= j && dp[i][j-arr[i]] != max) {
                    left = dp[i][j-arr[i]] + 1;
                }
                dp[i][j] = Math.min(dp[i-1][j], left);
            }
        }

        return dp[count-1][aim] == max ? -1 : dp[count-1][aim];
    }
}