package com.xuyang.algorithm.leetcode;

/**
 * @Auther: allanyang
 * @Date: 2019/11/13 09:11
 * @Description:
 *
 * 给定一个正整数 n，将其拆分为至少两个正整数的和，并使这些整数的乘积最大化。 返回你可以获得的最大乘积。
 *
 * 示例 1:
 * 输入: 2
 * 输出: 1
 * 解释: 2 = 1 + 1, 1 × 1 = 1。
 *
 * 示例 2:
 * 输入: 10
 * 输出: 36
 * 解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36。
 * 说明: 你可以假设 n 不小于 2 且不大于 58。
 *
 */
public class X_343_整数拆分 {

    /**
     * dp[i]:i结尾的最大乘积
     * 注：此题也可用数学法求解，从7以后，dp[i] = 3 dp[i-3].
     * 并可以将时间复杂度从O（N^2）-》O（N），空间复杂度O（N）-》O（1）
     * 有感兴趣的可以自行查阅资料
     * https://leetcode-cn.com/problems/integer-break/solution/zheng-shu-chai-fen-shu-xue-fang-fa-han-wan-zheng-t/
     */
    public int integerBreak(int n) {
        if (n <= 1) {
            return 0;
        }

        int[] dp = new int[n+1];

        for (int i = 2;i <= n;i++) {
            for (int j = 1;j < i;j++) {
                //这里加dp[i]的作用是当i=6是，j=3是，最大是3*3=9。当下一次j=4的时候，2*4=8，如果不加dp[i]会将9覆盖成8.
                dp[i] = Math.max(dp[i], Math.max(j * (i-j), j * dp[i-j]));
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {
        X_343_整数拆分 s = new X_343_整数拆分();
        s.integerBreak(10);
    }
}