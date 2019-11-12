package com.xuyang.algorithm.leetcode;

/**
 * @Auther: allanyang
 * @Date: 2019/8/24 12:36
 * @Description:
 *
 * n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 *
 * 给定一个整数 n，返回 n 皇后不同的解决方案的数量。
 *
 * 示例:
 * 输入: 4
 * 输出: 2
 * 解释: 4 皇后问题存在如下两个不同的解法。
 *
 * [
 *  [".Q..",  // 解法 1
 *   "...Q",
 *   "Q...",
 *   "..Q."],
 *
 *  ["..Q.",  // 解法 2
 *   "Q...",
 *   "...Q",
 *   ".Q.."]
 * ]
 *
 */
public class X_52_N皇后Ⅱ {

    /**
     * 回溯法
     *
     * record[i]含义 : 再第i行，第record[i] = j类的位置放了一个皇后
     *
     * 当到达了最后一行的时候，总数+1。
     */
    public int totalNQueens(int n) {
        int[] record = new int[n];

        return process(n, 0, record);
    }

    private int process(int n, int i, int[] record) {
        if (i == n) {
            return 1;
        }

        int res= 0;
        for (int j = 0;j < n;j++) {
            if (isValid(record, i, j)) {
                record[i] = j;
                res += process(n, i+1, record);
            }
        }

        return res;
    }

    private boolean isValid(int[] record, int i, int j) {
        for (int k = 0; k < i; k++) {
            if (record[k] == j || Math.abs(i-k) == Math.abs(record[k] - j)) {
                return false;
            }
        }

        return true;
    }

    /**
     * 位运算
     *
     * 思想与回溯相同
     */
    public int totalNQueens1(int n) {
        if (n < 1 || n > 32) {
            return 0;
        }

        return process(n, 0, 0, 0, 0);
    }

    /**
     * (~(col | pie | na)) 获取所有可以放置皇后的位置，并且取反（取反的目的是即将要在这里放置皇后，方便后面运算，实际上后面取反也可以，就是代码不整洁。也就是拿最后一个位置的皇后）
     * ((1 << n)-1) 把n位上的位都变成1
     * bits & -bits 获取最后一位1
     * bits & bits-1 把最后一位1划掉
     *
     */
    private int process(int n, int row, int col, int pie, int na) {
        if (n == row) {
            return 1;
        }

        //获取所有可以放置皇后的位置，并用1标志
        int bits = (~(col | pie | na)) & ((1 << n)-1);
        int res = 0;
        while (bits != 0) {
            //拿最后一个放皇后的位置
            int mostOfRightBit = bits & -bits;
            //把刚刚拿的最后位置放置皇后
            res += process(n, row+1, col | mostOfRightBit, (pie | mostOfRightBit) << 1, (na | mostOfRightBit) >> 1);
            //既然已经防止皇后了，就把位置占上
            bits &= bits-1;
        }

        return res;
    }
}