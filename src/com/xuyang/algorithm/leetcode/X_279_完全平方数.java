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

        for (int i = 0;i * i <= n;i++) {
            res.add(i * i);
        }

        return res;
    }

    public static void main(String[] args) {
        X_279_完全平方数 s = new X_279_完全平方数();
        System.out.println(s.numSquares(12));
    }
}