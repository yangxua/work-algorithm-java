package com.xuyang.algorithm.leetcode;

/**
 * @Auther: allanyang
 * @Date: 2019/11/12 10:12
 * @Description:
 *
 * 编写一个程序，通过已填充的空格来解决数独问题。
 * 一个数独的解法需遵循如下规则：
 *
 * 数字 1-9 在每一行只能出现一次。
 * 数字 1-9 在每一列只能出现一次。
 * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
 *
 */
public class X_37_解数独 {

    public void solveSudoku(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return ;
        }

        process(board);
    }

    private boolean process(char[][] board) {
        for (int i = 0;i < board.length;i++) {
            for (int j = 0;j < board[0].length;j++) {
                if (board[i][j] == '.') {
                    for (char k = '1'; k <= '9';k++) {
                        if (isValid(board, i, j, k)) {
                            board[i][j] = k;
                            if (process(board)) {
                                return true;
                            }
                            board[i][j] = '.';
                        }
                    }
                    return false;
                }
            }
        }

        return true;

    }

    private boolean isValid(char[][] board, int row, int col, char c) {
        for (int i = 0;i < 9;i++) {
            if (board[i][col] == c) {
                return false;
            }
            if (board[row][i] == c) {
                return false;
            }
            if (board[row/3*3 + i/3][col/3*3 + i%3] == c) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        for (int i = 0;i < 9;i++) {
            int row = 5 / 3 * 3 + i / 3;
            int col = 5 / 3 * 3 + i % 3;
            System.out.println(row + "----"+col);
        }
    }
}