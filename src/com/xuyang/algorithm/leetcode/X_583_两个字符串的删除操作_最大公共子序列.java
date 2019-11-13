package com.xuyang.algorithm.leetcode;

/**
 * @Auther: allanyang
 * @Date: 2019/11/13 17:29
 * @Description: （300,646,376, 583,718）
 *
 * 给定两个单词 word1 和 word2，找到使得 word1 和 word2 相同所需的最小步数，每步可以删除任意一个字符串中的一个字符。
 *
 * 示例 1:
 * 输入: "sea", "eat"
 * 输出: 2
 * 解释: 第一步将"sea"变为"ea"，第二步将"eat"变为"ea"
 *
 */
public class X_583_两个字符串的删除操作_最大公共子序列 {

    public int minDistance(String word1, String word2) {
        char[] chars1 = word1.toCharArray();
        char[] chars2 = word2.toCharArray();

        int m = chars1.length;
        int n = chars2.length;

        int max = 0;
        int[][] dp = new int[m+1][n+1];

        for (int i = 1;i <= m;i++) {
            for (int j = 1;j <= n;j++) {
                if (chars1[i-1] == chars2[j-1]) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
                max = Math.max(max, dp[i][j]);
            }
        }

        return m + n - 2 * dp[m][n];
    }
}