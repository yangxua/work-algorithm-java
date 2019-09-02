package com.xuyang.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: allanyang
 * @Date: 2019/8/24 13:18
 * @Description:
 *
 *
 * n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 *
 * 给定一个整数 n，返回所有不同的 n 皇后问题的解决方案。
 * 每一种解法包含一个明确的 n 皇后问题的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
 *
 * 示例:
 * 输入: 4
 * 输出: [
 *  [".Q..",  // 解法 1
 *   "...Q",
 *   "Q...",
 *   "..Q."],
 *
 *  ["..Q.",  // 解法 2
 *   "Q...",
 *   "...Q",
 *   ".Q.."]
 * ]
 * 解释: 4 皇后问题存在两个不同的解法。
 */
public class X_51_N皇后 {

    /**
     * 回溯法
     *
     * 思考：用位运算应该也是可以解决此题，为什么？
     */
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        int[] record = new int[n];
        char[][] ch = new char[n][n];

        process3(record, n, 0, res, new ArrayList<>(), ch);

        return res;
    }

    private  void process3(int[] record, int n, int i, List<List<String>> res, ArrayList list, char[][] ch) {
        if (n == i) {
            List<String> tmp = new ArrayList<>(n);
            for (int k = 0;k < n;k++) {
                tmp.add(new String(ch[k]));
            }
            res.add(tmp);
            return ;
        }

        for (int j = 0;j < n;j++) {
            if (isValid(record, i, j)) {
                for (int k = 0;k < n;k++) {
                    ch[i][k] = '.';
                }
                ch[i][j] = 'Q';
                record[i] = j;
                process3(record, n, i+1, res, list, ch);
            }
        }
    }

    private boolean isValid(int[] record, int i, int j) {
        for (int k = 0;k < i;k++) {
            if (record[k] == j || Math.abs(record[k]-j) == Math.abs(k - i)) {
                return false;
            }
        }

        return true;
    }
}