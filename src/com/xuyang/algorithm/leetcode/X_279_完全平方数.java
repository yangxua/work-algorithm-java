package com.xuyang.algorithm.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Auther: allanyang
 * @Date: 2019/11/9 13:11
 * @Description:
 *
 * 给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。
 *
 * 示例 1:
 * 输入: n = 12
 * 输出: 3
 * 解释: 12 = 4 + 4 + 4.
 * 示例 2:
 * 输入: n = 13
 * 输出: 2
 * 解释: 13 = 4 + 9.
 *
 */
public class X_279_完全平方数 {

    /**
     * 宽度优先遍历
     */
    public int numSquares(int n) {
        List<Integer> squares = generateSquares(n);
        LinkedList<Integer> queue = new LinkedList<>();
        boolean[] flag = new boolean[n+1];
        queue.add(n);
        flag[n] = true;
        int level = 0;

        while (queue.size() > 0) {
            int size = queue.size();
            level++;

            while (size-- > 0) {
                Integer cur = queue.poll();

                for (int square : squares) {
                    int next = cur - square;

                    if (next < 0) {
                        break;
                    }
                    if (next == 0) {
                        return level;
                    }
                    if (flag[next]) {
                        continue;
                    }
                    queue.add(next);
                    flag[next] = true;
                }
            }
        }

        return n;
    }

    private List<Integer> generateSquares(int n) {
        List<Integer> res = new ArrayList<>();

        for (int i = 1;i * i <= n;i++) {
            res.add(i * i);
        }

        return res;
    }


    /**
     * 动态规划
     */
    public int numSquares1(int n) {
        int[] dp = new int[n+1];

        for (int i = 1;i <= n;i++) {
            //最差的情况下每次都用1来当平方数
            dp[i] = i;
            for (int j = 1;j * j <= i;j++) {
                //dp[i-j*j]+1的含义是当i=7,j=2时，dp[i-j*j]=dp[3]的最小数加上1，这个1代表的相差的4可以用2*2来标识
                dp[i] = Math.min(dp[i-j*j] + 1, dp[i]);
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {
        X_279_完全平方数 s = new X_279_完全平方数();
        System.out.println(s.numSquares1(12));
    }
}