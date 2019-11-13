package com.xuyang.algorithm.leetcode;

/**
 * @Auther: allanyang
 * @Date: 2019/11/12 21:11
 * @Description:
 *
 * 给定一个整数数组  nums，求出数组从索引 i 到 j  (i ≤ j) 范围内元素的总和，包含 i,  j 两点。
 *
 * 示例：
 *
 * 给定 nums = [-2, 0, 3, -5, 2, -1]，求和函数为 sumRange()
 *
 * sumRange(0, 2) -> 1
 * sumRange(2, 5) -> -1
 * sumRange(0, 5) -> -3
 *
 *
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(i,j);
 */
public class X_303_区域和检索数组不可变 {

    public static void main(String[] args) {
        NumArray obj = new NumArray(new int[]{1,2,3,4,5});

        for (int i : obj.sum) {
            System.out.println(i);
        }
    }
}

class NumArray {

    public int[] sum;

    public NumArray(int[] nums) {
        sum = new int[nums.length+1];

        for (int i = 1;i <= nums.length;i++) {
            sum[i] = sum[i-1] + nums[i-1];
        }
    }

    public int sumRange(int i, int j) {
        return sum[j+1] - sum[i];
    }
}