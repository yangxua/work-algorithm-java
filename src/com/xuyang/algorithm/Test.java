package com.xuyang.algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: allanyang
 * @Date: 2019/11/6 18:05
 * @Description:
 * 开始的时候写在这个上面，如果已经ac之后再粘贴到对应的文件
 * 或已经cr的想再次练习，可以用这个文件
 */
public class Test {

    public int lengthOfLIS(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }

        int res = 0;
        int[] dp = new int[nums.length];

        for (int i = 0;i < nums.length;i++) {
            dp[i] = 1;
            for (int j = 0;j < i;j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            res = Math.max(res, dp[i]);
        }

        return res;
    }

    private List<Integer> generateSquares(int n) {
        List<Integer> res = new ArrayList<>();

        for (int i = 1;i <= n;i++) {
            res.add(i * i);
        }

        return res;
    }


    public void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}