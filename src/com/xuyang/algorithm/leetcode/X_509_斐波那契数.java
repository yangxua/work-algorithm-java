package com.xuyang.algorithm.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: allanyang
 * @Date: 2019/8/22 19:21
 * @Description: 建议阅读70（爬楼梯）
 *
 * 斐波那契数，通常用 F(n) 表示，形成的序列称为斐波那契数列。该数列由 0 和 1 开始，后面的每一项数字都是前面两项数字的和。也就是：
 * F(0) = 0,   F(1) = 1
 * F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
 * 给定 N，计算 F(N)。
 *
 *
 * 示例 1：
 *
 * 输入：2
 * 输出：1
 * 解释：F(2) = F(1) + F(0) = 1 + 0 = 1.
 * 示例 2：
 *
 * 输入：3
 * 输出：2
 * 解释：F(3) = F(2) + F(1) = 1 + 1 = 2.
 * 示例 3：
 *
 * 输入：4
 * 输出：3
 * 解释：F(4) = F(3) + F(2) = 2 + 1 = 3.
 */
public class X_509_斐波那契数 {

    /**
     * 暴力法
     *
     * 时间：由于要形成一颗深度为N的树，所以时间复杂度为O（2^n）
     */
    public int fib(int N) {
        return N < 2 ? N : fib(N-1) + fib(N-2);
    }

    /**
     * 记忆搜索法
     *
     * 时间：O（N）
     * 空间: O（N）
     *
     */
    private Map<Integer, Integer> map = new HashMap<>();
    public int fib1(int N) {
        if (N < 2) {
            return N;
        }

        if (map.containsKey(N)) {
            return map.get(N);
        }

        int res = fib1(N-1) + fib1(N-2);
        map.put(N, res);

        return res;
    }


    /**
     * 动态规划法
     * 时间：O（N）
     * 空间：O(1)
     *
     */
    public int fib2(int N) {
        if (N < 2) {
            return N;
        }

        int res = 0;
        int back1 = 1; //指回退一步，也就是fib（N-1）
        int back2 = 0; //指回退两步，也就是fib（N-2）
        for (int i = 2; i <= N;i++) {
            res = back1 + back2;
            back2 = back1;
            back1 = res;
        }

        return res;
    }

    /**
     * 枚举法
     *
     * 提前把数据准备好，直接用
     * 类似于大数据情况下，spark的计算是很慢的，因此需要提前计算好结果，但是往往这种情况都是T+1
     */
    private final static int[] FIB = new int[]{0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610,
            987, 1597, 2584, 4181, 6765, 10946, 17711, 28657, 46368, 75025, 121393, 196418, 317811, 514229, 832040};
    public int fib3(int N) {
        return FIB[N];
    }
}