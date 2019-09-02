package com.xuyang.algorithm.leetcode;

/**
 * @Auther: allanyang
 * @Date: 2019/8/24 14:28
 * @Description:
 *
 *
 * 判断一个 9x9 的数独是否有效。只需要根据以下规则，验证已经填入的数字是否有效即可。
 *
 * 数字 1-9 在每一行只能出现一次。
 * 数字 1-9 在每一列只能出现一次。
 * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
 *
 */
public class X_36_有效的数独 {

    /**
     * 回溯法
     *
     * board[i/3*3+j/3][i%3*3+j%3]这个地方是代表每个小9宫格是否符合要求，为什么这么表示我也不是很清楚
     */
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0;i < 9;i++) {
            char[] map1 = new char[128];
            char[] map2 = new char[128];
            char[] map3 = new char[128];
            for (int j = 0;j < 9;j++) {
                if (board[i][j] != '.') {
                    if (map1[board[i][j]] == 1) {
                        return false;
                    }
                    map1[board[i][j]] = 1;
                }
                if (board[j][i] != '.') {
                    if (map2[board[j][i]] == 1) {
                        return false;
                    }
                    map2[board[j][i]] = 1;
                }
                if (board[i/3*3+j/3][i%3*3+j%3] != '.') {
                    if (map3[board[i/3*3+j/3][i%3*3+j%3]] == 1) {
                        return false;
                    }
                    map3[board[i/3*3+j/3][i%3*3+j%3]] = 1;
                }
            }
        }

        return true;
    }
}