package com.xuyang.algorithm.leetcode;

/**
 * @Auther: allanyang
 * @Date: 2019/11/12 21:24
 * @Description:
 *
 * 如果一个数列至少有三个元素，并且任意两个相邻元素之差相同，则称该数列为等差数列。
 * 例如，以下数列为等差数列:
 *
 * 1, 3, 5, 7, 9
 * 7, 7, 7, 7
 * 3, -1, -5, -9
 * 以下数列不是等差数列。
 *
 * 1, 1, 2, 5, 7
 *
 * 数组 A 包含 N 个数，且索引从0开始。数组 A 的一个子数组划分为数组 (P, Q)，P 与 Q 是整数且满足 0<=P<Q<N 。
 * 如果满足以下条件，则称子数组(P, Q)为等差数组：
 * 元素 A[P], A[p + 1], ..., A[Q - 1], A[Q] 是等差的。并且 P + 1 < Q 。
 * 函数要返回数组 A 中所有为等差数组的子数组个数。
 *
 * 示例:
 * A = [1, 2, 3, 4]
 * 返回: 3, A 中有三个子等差数组: [1, 2, 3], [2, 3, 4] 以及自身 [1, 2, 3, 4]。
 *
 */
public class X_413_等差数列划分 {

    /**
     * dp[i] : 从index=i为尾节点时的总等差数列数（数组的头节点不一定时多少）
     * A[i] - A[i-1] == A[i-1] - A[i-2] : A[i-1]为中间轴，左右符合条件，则dp[i] = dp[i-1] + 1;
     * 把每个为尾节点组成的数相加即为所求解
     */
    public int numberOfArithmeticSlices(int[] A) {
        if (A == null || A.length < 3) {
            return 0;
        }

        int total = 0;
        int[] dp = new int[A.length];

        for (int i = 2;i < A.length;i++) {
            if (A[i] - A[i-1] == A[i-1] - A[i-2]) {
                dp[i] = dp[i-1] + 1;
            }
        }

        for (int i : dp) {
            total += i;
        }

        return total;
    }


    public static void main(String[] args) {
        X_413_等差数列划分 s = new X_413_等差数列划分();
        s.numberOfArithmeticSlices(new int[]{0,1,2});
    }
}