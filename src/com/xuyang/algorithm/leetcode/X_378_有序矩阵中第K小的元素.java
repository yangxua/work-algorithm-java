package com.xuyang.algorithm.leetcode;

/**
 * @Auther: allanyang
 * @Date: 2019/11/8 11:28
 * @Description:
 *
 * 给定一个 n x n 矩阵，其中每行和每列元素均按升序排序，找到矩阵中第k小的元素。
 * 请注意，它是排序后的第k小元素，而不是第k个元素。
 *
 * 示例:
 * matrix = [
 *    [ 1,  5,  9],
 *    [10, 11, 13],
 *    [12, 13, 15]
 * ],
 * k = 8,
 * 返回 13。
 *
 */
public class X_378_有序矩阵中第K小的元素 {

    public int kthSmallest(int[][] matrix, int k) {
        int length = matrix.length;
        int width = matrix[0].length;
        int left = matrix[0][0];
        int right = matrix[length-1][width-1];

        while (left < right) {
            int mid = (left + right) / 2;
            int cnt = leMidCnt(matrix, mid);
            if (cnt < k) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }

    private int leMidCnt(int[][] matrix, int mid) {
        int cnt = 0;

        for (int i = 0;i < matrix.length;i++) {
            for (int j = 0;j < matrix[0].length;j++) {
                if (matrix[i][j] <= mid) {
                    cnt++;
                }
            }
        }

        return cnt;
    }

    public static void main(String[] args) {
        X_378_有序矩阵中第K小的元素 s = new X_378_有序矩阵中第K小的元素();
        int[][] arr = new int[][]{
                {1,  5,  9},
                {10, 11, 13},
                {12, 13, 15}
        };
        s.kthSmallest(arr, 8);
    }
}