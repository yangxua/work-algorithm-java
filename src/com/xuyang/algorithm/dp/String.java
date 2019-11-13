package com.xuyang.algorithm.dp;

/**
 * @Auther: allanyang
 * @Date: 2019/11/13 16:53
 * @Description:
 *
 * 最长公共子序列
 * dp[i][j]:nums1[i]的i作为结尾，nums2[j]的j作为结尾的最长公共子序列长度。
 *
 * 公式：
 * 1.当nums1[i] == nums2[j],  -->   dp[i][j] = dp[i-1][j-1] + 1;
 * 2.当nums1[i] != nums2[j],  -->   dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1])
 */
public class String {

    /**
     * 最长公共子序列
     * dp[i][j]:nums1到i，nums2到j的最长公共子序列长度。（i,j不一定作为结尾）所以dp[m][n]即为max
     *
     * 公式：
     * 1.当nums1[i] == nums2[j],  -->   dp[i][j] = dp[i-1][j-1] + 1;
     * 2.当nums1[i] != nums2[j],  -->   dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1])
     */
    public int lengthOfLCSeq(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;

        //这里不需要max也可以，因为不是以i,j结尾，但是为了和公共字串代码相似，加了max
        int max = 0;
        int[][] dp = new int[m+1][n+1];

        for (int i = 1;i <= m;i++) {
            for (int j = 1;j <= n;j++) {
                if (nums1[i-1] == nums2[j-1]) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
                max = Math.max(max, dp[i][j]);
            }
        }

        return max;
    }

    /**
     * dp[i][j]:必须以nums1[i]和nums2[j]为结尾
     *
     * 最长公共字串
     */
    public int lengthOfLCSub(int[] nums1, int[] nums2) {
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