package com.xuyang.algorithm.leetcode;

import java.util.LinkedList;

/**
 * @Auther: allanyang
 * @Date: 2019/11/9 11:41
 * @Description:
 *
 * 在一个 N × N 的方形网格中，每个单元格有两种状态：空（0）或者阻塞（1）。
 *
 * 一条从左上角到右下角、长度为 k 的畅通路径，由满足下述条件的单元格 C_1, C_2, ..., C_k 组成：
 *
 * 相邻单元格 C_i 和 C_{i+1} 在八个方向之一上连通（此时，C_i 和 C_{i+1} 不同且共享边或角）
 * C_1 位于 (0, 0)（即，值为 grid[0][0]）
 * C_k 位于 (N-1, N-1)（即，值为 grid[N-1][N-1]）
 * 如果 C_i 位于 (r, c)，则 grid[r][c] 为空（即，grid[r][c] == 0）
 * 返回这条从左上角到右下角的最短畅通路径的长度。如果不存在这样的路径，返回 -1 。
 *
 */
public class X_1091_二进制矩阵中的最短路径 {

    private static final int[][] direction = new int[][]{{0,1},{0,-1},{1,0},{-1,0},{1,-1},{-1,1},{-1,-1},{1,1}};


    public int shortestPathBinaryMatrix(int[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) {
            return -1;
        }
        if (grid[0][0] == 1 || grid[grid.length-1][grid[0].length-1] == 1) {
            return -1;
        }

        int length = grid.length;
        int width = grid[0].length;

        boolean[][] flag = new boolean[length][width];
        LinkedList<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0,0});
        int count = 0;

        while (queue.size() > 0) {
            int size = queue.size();
            count++;
            while (size-- > 0) {
                int[] cur = queue.poll();
                if (cur[0] == length-1 && cur[1] == width-1) {
                    return count;
                }

                for (int[] dir : direction) {
                    int nextX = cur[0] + dir[0];
                    int nextY = cur[1] + dir[1];

                    if (nextX < length && nextY < width && nextX >= 0 && nextY >=0 && !flag[nextX][nextY] && grid[nextX][nextY] == 0) {
                        queue.add(new int[]{nextX, nextY});
                        flag[nextX][nextY] = true;
                    }
                }
            }
        }

        return -1;
    }
}