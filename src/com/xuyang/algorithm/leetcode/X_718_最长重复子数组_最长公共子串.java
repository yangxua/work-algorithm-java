package com.xuyang.algorithm.leetcode;

/**
 * @Auther: allanyang
 * @Date: 2019/11/13 17:26
 * @Description: （300,646,376, 583,718）
 *
 * 给两个整数数组 A 和 B ，返回两个数组中公共的、长度最长的子数组的长度。
 *
 * 示例 1:
 *
 * 输入:
 * A: [1,2,3,2,1]
 * B: [3,2,1,4,7]
 * 输出: 3
 * 解释:
 * 长度最长的公共子数组是 [3, 2, 1]。
 *
 */
public class X_718_最长重复子数组_最长公共子串 {

    public int findLength(int[] A, int[] B) {
        int[] nums1 = A;
        int[] nums2 = B;
        int m = nums1.length;
        int n = nums2.length;

        int max = 0;
        int[][] dp = new int[m+1][n+1];

        for (int i = 1;i <= m;i++) {
            for (int j = 1;j <= n;j++) {
                if (nums1[i-1] == nums2[j-1]) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                    max = Math.max(max, dp[i][j]);
                }
            }
        }

        return max;
    }
}