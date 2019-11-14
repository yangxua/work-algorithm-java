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
     * 定义一个二维数组 dp 存储最大价值，其中 dp[i][j] 表示前 i 件物品体积不超过 j 的情况下能达到的最大价值。设第 i 件物品体积为 w，价值为 v，根据第 i 件物品是否添加到背包中，可以分两种情况讨论：
     *
     * 第 i 件物品没添加到背包，总体积不超过 j 的前 i 件物品的最大价值就是总体积不超过 j 的前 i-1 件物品的最大价值，dp[i][j] = dp[i-1][j]。
     * 第 i 件物品添加到背包中，dp[i][j] = dp[i-1][j-w] + v。
     * 第 i 件物品可添加也可以不添加，取决于哪种情况下最大价值更大。因此，0-1 背包的状态转移方程为：
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
        int[][] dp = new int[count+1][total+1];

        for (int i = 1;i <= count;i++) {
            int v = values[i-1];
            int w = weights[i-1];
            for (int j = 1;j <= total;j++) {
                if (j >= w) {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-w] + v);
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        return dp[count][total];
    }

    /**
     * 可用一位数组简化
     * 因为dp[i][j]的i只与dp[i-1][xxx]有关
     * 所以i那维可以省略
     */
    public int packet01_1(int total, int[] values, int[] weights) {
        if (values.length != weights.length) {
            return 0;
        }

        int count = values.length;
        int[] dp = new int[total+1];

        for (int i = 1;i <= count;i++) {
            int w = weights[i-1];
            int v = values[i-1];
            for (int j = total;j >= w;j--) { //01背包，这里是逆序的，如果是完全背包则是顺序的
                dp[j] = Math.max(dp[j], dp[j-w] + v);
            }
        }

        return dp[total];
    }

    public static void main(String[] args) {
        Packet s = new Packet();
        s.packet01_1(4,new int[]{1,2,5},new int[]{1,2,5});
    }
}