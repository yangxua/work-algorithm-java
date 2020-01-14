package com.xuyang.algorithm.bat;

/**
 * @Auther: allanyang
 * @Date: 2020/1/13 17:50
 * @Description:
 */
public class 动态规划 {

    // 1.给定数组arr，arr中所有的值都为整数切不重复。每个值代表一中面值的货币，每种面值的货币可以使用任意张，在给定一个整数aim代表要找的钱数，求换钱有多少种方法。
    /**
     * 暴力搜索方法--》记忆搜索方法--》动态规划方法。
     */

    // 2.最长递增子序列
    /**
     * dp[i]:必须以dp[i]作为子序列最后元素的时候最长子序列长度。
     * dp[i] = max(dp[j] + 1) (0 <= j < i && dp[i] > dp[j])
     */

    // 3.最长公共子序列
    /**
     * dp[i][j]:选取str1[i]和str2[j]结尾时的最长公共子序列。
     * if (str1[i] == str2[j]) {
     *     dp[i][j] = 1 + dp[i-1][j-1]
     * } else {
     *     dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1])
     * }
     */

    // 4.最长公共字串
    /**
     * dp[i][j]:必须以str1[i]和str2[j]结尾时最长公共字串。
     * if (str1[i] == str2[j]) {
     *     dp[i][j] = dp[i-1][j-1] + 1;
     *     max = Math.max(max, dp[i][j]);
     * }
     */

    // 5.01背包
    /**
     * dp[i][j]:前i件物品，占用的重量不超过j的最大价值。
     *
     * dp[i][j] = Math.max(dp[i-1][j-weights[i-1]] + values[i], dp[i-1][j])
     */
}