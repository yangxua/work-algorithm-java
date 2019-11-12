package com.xuyang.algorithm.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Auther: allanyang
 * @Date: 2019/11/11 11:01
 * @Description:
 *
 * 给定一个 m x n 的非负整数矩阵来表示一片大陆上各个单元格的高度。“太平洋”处于大陆的左边界和上边界，而“大西洋”处于大陆的右边界和下边界。
 * 规定水流只能按照上、下、左、右四个方向流动，且只能从高到低或者在同等高度上流动。
 * 请找出那些水流既可以流动到“太平洋”，又能流动到“大西洋”的陆地单元的坐标。
 *
 * 提示：
 * 输出坐标的顺序不重要
 * m 和 n 都小于150
 *
 * 示例：
 * 给定下面的 5x5 矩阵:
 *
 *   太平洋 ~   ~   ~   ~   ~
 *        ~  1   2   2   3  (5) *
 *        ~  3   2   3  (4) (4) *
 *        ~  2   4  (5)  3   1  *
 *        ~ (6) (7)  1   4   5  *
 *        ~ (5)  1   1   2   4  *
 *           *   *   *   *   * 大西洋
 *
 * 返回:
 *
 * [[0, 4], [1, 3], [1, 4], [2, 2], [3, 0], [3, 1], [4, 0]] (上图中带括号的单元).
 *
 */
public class X_417_太平洋大西洋水流问题 {

    private int[][] matrix;
    private int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return new ArrayList<>();
        }

        List<List<Integer>> res = new ArrayList<>();
        this.matrix = matrix;
        boolean[][] canReachP = new boolean[matrix.length][matrix[0].length];
        boolean[][] canReachA = new boolean[matrix.length][matrix[0].length];

        for (int i = 0;i < matrix.length;i++) {
            dfs(i, 0, canReachP);
            dfs(i, matrix[0].length-1, canReachA);
        }
        for (int j = 0;j < matrix[0].length;j++) {
            dfs(0, j, canReachP);
            dfs(matrix.length-1, j, canReachA);
        }

        for (int i = 0;i < matrix.length;i++) {
            for (int j = 0;j < matrix[0].length;j++) {
                if (canReachP[i][j] && canReachA[i][j]) {
                    res.add(Arrays.asList(i, j));
                }
            }
        }

        return res;
    }

    private void dfs(int i, int j, boolean[][] canReach) {
        canReach[i][j] = true;

        for (int[] direction : directions) {
            int nextX = i + direction[0];
            int nextY = j + direction[1];
            if (nextX < 0 || nextY < 0
                    || nextX >= canReach.length || nextY >= canReach[0].length
                    || matrix[i][j] > matrix[nextX][nextY] || canReach[nextX][nextY]) {
                continue;
            }

            dfs(nextX, nextY, canReach);
        }
    }

    public static void main(String[] args) {
        X_417_太平洋大西洋水流问题 s = new X_417_太平洋大西洋水流问题();
        int[][] arr = new int[][]{
                {1,2,2,3,5},
                {3,2,3,4,4},
                {2,4,5,3,1},
                {6,7,1,4,5},
                {5,1,1,2,4},
        };
        s.pacificAtlantic(arr);

    }
}