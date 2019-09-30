package com.xuyang.algorithm.leetcode;

/**
 * @Auther: allanyang
 * @Date: 2019/9/16 20:03
 * @Description:
 *
 * 给定一个 m x n 的矩阵，如果一个元素为 0，则将其所在行和列的所有元素都设为 0。请使用原地算法。
 * 示例 1:
 *
 * 输入:
 * [
 *   [1,1,1],
 *   [1,0,1],
 *   [1,1,1]
 * ]
 * 输出:
 * [
 *   [1,0,1],
 *   [0,0,0],
 *   [1,0,1]
 * ]
 * 示例 2:
 *
 * 输入:
 * [
 *   [0,1,2,0],
 *   [3,4,5,2],
 *   [1,3,1,5]
 * ]
 * 输出:
 * [
 *   [0,0,0,0],
 *   [0,4,5,0],
 *   [0,3,1,0]
 * ]
 *
 */
public class X_73_矩阵置零 {

    public void setZeroes(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return ;
        }

        boolean row0 = false;
        boolean col0 = false;
        int row = matrix.length;
        int col = matrix[0].length;

        for (int i = 0;i < row;i++) {
            if (matrix[i][0] == 0) {
                row0 = true;
                break;
            }
        }
        for (int j = 0;j < col;j++) {
            if (matrix[0][j] == 0) {
                col0 = true;
                break;
            }
        }

        for (int i = 1;i < row;i++) {
            for (int j = 1;j < col;j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        for (int i = 1;i < row;i++) {
            if (matrix[i][0] == 0) {
                for (int j = 1;j < col;j++) {
                    matrix[i][j] = 0;
                }
            }
        }
        for (int j = 1;j < col;j++) {
            if (matrix[0][j] == 0) {
                for (int i = 1;i < row;i++) {
                    matrix[i][j] = 0;
                }
            }
        }

        if (row0) {
            for (int i = 0;i < row;i++) {
                matrix[i][0] = 0;
            }
        }
        if (col0) {
            for (int j = 0;j < col;j++) {
                matrix[0][j] = 0;
            }
        }
    }
}