package com.xuyang.algorithm.leetcode;

/**
 * @Auther: allanyang
 * @Date: 2019/11/14 20:47
 * @Description:
 *
 * 给定两个单词 word1 和 word2，计算出将 word1 转换成 word2 所使用的最少操作数 。
 *
 * 你可以对一个单词进行如下三种操作：
 *
 * 插入一个字符
 * 删除一个字符
 * 替换一个字符
 * 示例 1:
 *
 * 输入: word1 = "horse", word2 = "ros"
 * 输出: 3
 * 解释:
 * horse -> rorse (将 'h' 替换为 'r')
 * rorse -> rose (删除 'r')
 * rose -> ros (删除 'e')
 * 示例 2:
 *
 * 输入: word1 = "intention", word2 = "execution"
 * 输出: 5
 * 解释:
 * intention -> inention (删除 't')
 * inention -> enention (将 'i' 替换为 'e')
 * enention -> exention (将 'n' 替换为 'x')
 * exention -> exection (将 'n' 替换为 'c')
 * exection -> execution (插入 'u')
 *
 */
public class X_72_编辑距离 {

    /**
     * dp[i][j] : word1从0-i的字符，变成word2的0-j的字符的花费
     *
     * insertCount：插入的花费
     * deleteCount：删除的花费
     * replaceCount：替换的花费
     */
    public int minDistance(String word1, String word2) {
        int insertCount = 1;
        int deleteCount = 1;
        int replaceCount = 1;

        int len1 = word1.length() + 1;
        int len2 = word2.length() + 1;

        int[][] dp = new int[len1][len2];

        for (int i = 1;i < len1;i++) {
            dp[i][0] = deleteCount * i;
        }
        for (int j = 1;j < len2;j++) {
            dp[0][j] = insertCount * j;
        }

        for (int i = 1;i < len1;i++) {
            for (int j = 1;j < len2;j++) {
                if (word1.charAt(i-1) == word2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1];
                } else {
                    dp[i][j] = dp[i-1][j-1] + replaceCount;
                }

                dp[i][j] = Math.min(dp[i][j], dp[i-1][j] + insertCount);
                dp[i][j] = Math.min(dp[i][j], dp[i][j-1] + deleteCount);
            }
        }

        return dp[word1.length()][word2.length()];
    }
}