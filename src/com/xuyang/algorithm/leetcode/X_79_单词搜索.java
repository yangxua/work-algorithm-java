package com.xuyang.algorithm.leetcode;

/**
 * @Auther: allanyang
 * @Date: 2019/9/26 14:48
 * @Description:
 *
 * 给定一个二维网格和一个单词，找出该单词是否存在于网格中。
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 *
 * 示例:
 * board =
 * [
 *   ['A','B','C','E'],
 *   ['S','F','C','S'],
 *   ['A','D','E','E']
 * ]
 *
 * 给定 word = "ABCCED", 返回 true.
 * 给定 word = "SEE", 返回 true.
 * 给定 word = "ABCB", 返回 false.
 *
 */
public class X_79_单词搜索 {

    public boolean exist(char[][] board, String word) {
        if (board.length == 0 || board[0].length == 0) {
            return false;
        }

        boolean[][] invited = new boolean[board.length][board[0].length];
        for (int i = 0;i < board.length;i++) {
            for (int j = 0;j < board[0].length;j++) {
                if (board[i][j] == word.charAt(0) && process(invited,board,i,j,word,0)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean process(boolean[][] invited, char[][] board, int i, int j, String word, int level) {
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || invited[i][j] || word.charAt(level) != board[i][j]) {
            return false;
        }
        if (level == word.length()-1) {
            return true;
        }

        invited[i][j] = true;
        if (process(invited, board, i+1, j, word,level+1)
                || process(invited, board, i-1, j, word, level+1)
                || process(invited, board, i, j+1, word, level+1)
                || process(invited, board, i, j-1, word, level+1 )) {
            return true;
        }
        invited[i][j] = false;

        return false;
    }


}