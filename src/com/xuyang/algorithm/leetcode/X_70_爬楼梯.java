package com.xuyang.algorithm.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: allanyang
 * @Date: 2019/8/22 19:45
 * @Description: 建议阅读509（斐波那契数）
 *
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * 注意：给定 n 是一个正整数。
 *
 *
 *
 * 示例 1：
 * 输入： 2
 * 输出： 2
 * 解释： 有两种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶
 * 2.  2 阶
 *
 * 示例 2：
 * 输入： 3
 * 输出： 3
 * 解释： 有三种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶 + 1 阶
 * 2.  1 阶 + 2 阶
 * 3.  2 阶 + 1 阶
 *
 */
public class X_70_爬楼梯 {

    /**
     * 暴力递归法
     */
    public int climbStairs(int n) {
        if (n <=2 ) {
            return n;
        }

        return climbStairs(n-1) + climbStairs(n-2);
    }

    /**
     * 记忆搜索法
     */
    private Map<Integer, Integer> map = new HashMap<>();
    public int climbStairs1(int n) {
        if (n <= 2) {
            return n;
        }

        if (map.containsKey(n)) {
            return map.get(n);
        }

        int res = climbStairs1(n-1) + climbStairs1(n-2);
        map.put(n, res);

        return res;
    }

    /**
     * 动态规划
     */
    public int climbStairs2(int n) {
        if (n <= 2) {
            return n;
        }

        int res = 0;
        int back1 = 2;
        int back2 = 1;
        for (int i = 3;i <= n;i++) {
            res = back1+back2;
            back2 = back1;
            back1 = res;
        }

        return res;
    }

    /**
     * 枚举法
     */
    private static final int[] ANSWER = new int[]{0,1,2,3,5,8,13,21,34,55,89,144,233,377,610,987,1597,2584,4181,6765,10946,17711,28657,46368,75025,121393,196418,317811,514229,832040,1346269,2178309,3524578,5702887,9227465,14930352,24157817,39088169,63245986,102334155,165580141,267914296,433494437,701408733,1134903170,1836311903};
    public int climbStairs3(int n) {
        return ANSWER[n];
    }

}