package com.xuyang.algorithm.dp;

/**
 * @Auther: allanyang
 * @Date: 2019/9/17 15:52
 * @Description:
 *
 * 背包问题
 */
public class Packet {

    /**
     *
     * value和weight一一对应
     * （此代码未经过ac检测，可能出现bug）
     *
     * @param total 背包总重量
     * @param values 价值
     * @param weights 重量
     */
    public int packet01(int total, int[] values, int[] weights) {
        if (values.length != weights.length) {
            return 0;
        }

        int count = values.length;
        int[][] dp = new int[count][total+1];

        for (int i = 0;i <= total;i++) {
            dp[0][i] = weights[i] > total ? 0 : values[i];
        }

        for (int i = 1;i < count;i++) {
            for (int j = 1;j <= total;j++) {
                if (j-weights[i] >= 0) {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-weights[i]] + values[i]);
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        return dp[count-1][total];
    }
}