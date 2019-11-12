package com.xuyang.algorithm;

/**
 * @Auther: allanyang
 * @Date: 2019/11/6 18:05
 * @Description:
 * 开始的时候写在这个上面，如果已经ac之后再粘贴到对应的文件
 * 或已经cr的想再次练习，可以用这个文件
 */
public class Test {

    public int uniquePaths(int m, int n) {
        int[] dp = new int[n];

        for (int i = 0;i < n;i++) {
            dp[i] = 1;
        }

        for (int i = 1;i < m;i++) {
            for (int j = 1;j < n;j++) {
                dp[j] += dp[j-1];
            }
        }

        return dp[n];
    }



    public void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}