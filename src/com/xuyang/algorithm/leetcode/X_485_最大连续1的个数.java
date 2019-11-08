package com.xuyang.algorithm.leetcode;

/**
 * @Auther: allanyang
 * @Date: 2019/11/8 11:08
 * @Description:
 */
public class X_485_最大连续1的个数 {

    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        int cur = 0;

        for (int i = 0;i < nums.length;i++) {
            cur = nums[i] == 1 ? cur+1 : 0;
            max = Math.max(cur, max);
        }

        return max;
    }
}