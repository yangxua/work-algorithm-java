package com.xuyang.algorithm.leetcode;

import java.util.Arrays;

/**
 * @Auther: allanyang
 * @Date: 2019/11/13 16:15
 * @Description: (300,646,376, 583,718)
 *
 * 给出 n 个数对。 在每一个数对中，第一个数字总是比第二个数字小。
 * 现在，我们定义一种跟随关系，当且仅当 b < c 时，数对(c, d) 才可以跟在 (a, b) 后面。我们用这种形式来构造一个数对链。
 * 给定一个对数集合，找出能够形成的最长数对链的长度。你不需要用到所有的数对，你可以以任何顺序选择其中的一些数对来构造。
 *
 * 示例 :
 * 输入: [[1,2], [2,3], [3,4]]
 * 输出: 2
 * 解释: 最长的数对链是 [1,2] -> [3,4]
 *
 */
public class X_646_最长数对链 {

    public int findLongestChain(int[][] pairs) {
        if (pairs == null || pairs.length == 0) {
            return 0;
        }

        int res = 0;
        int[] dp = new int[pairs.length];
        Arrays.sort(pairs, (a, b) -> (a[0] - b[0]));

        for (int i = 0;i < pairs.length;i++) {
            dp[i] = 1;
            for (int j = 0;j < i;j++) {
                if (pairs[i][0] > pairs[j][1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            res = Math.max(res, dp[i]);
        }

        return res;
    }
}