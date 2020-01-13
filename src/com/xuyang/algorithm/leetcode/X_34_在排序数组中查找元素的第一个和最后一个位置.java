package com.xuyang.algorithm.leetcode;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * @Auther: allanyang
 * @Date: 2019/9/29 14:06
 * @Description:
 *
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 * 你的算法时间复杂度必须是 O(log n) 级别。
 * 如果数组中不存在目标值，返回 [-1, -1]。
 *
 * 示例 1:
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: [3,4]
 * 示例 2:
 * 输入: nums = [5,7,7,8,8,10], target = 6
 * 输出: [-1,-1]
 *
 */
public class X_34_在排序数组中查找元素的第一个和最后一个位置 {

    /**
     * 用两次二分法即可，一个很好的练习二分法的题目
     * 一般选取左中位数，结果一般都大于等于于其结果（当大于时候是不存在的情况）
     * 而选取又中位数，正好相反，结果一般小于等于棋结果。
     * 如下提如果把if()中不存在去掉，可以看到其结果（再leetcode上看一下就知道现象）
     */
    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) {
            return new int[]{-1, -1};
        }

        int [] res = new int[2];
        int left = 0;
        int right = nums.length-1;
        while (left < right) {
            int mid = left + right >>> 1;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        if (nums[left] != target) {
            return new int[]{-1, -1};
        }

        res[0] = left;

        left = 0;
        right = nums.length-1;
        while (left < right) {
            int mid = (left + right + 1) >>> 1;
            if (nums[mid] <= target) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        res[1] = left;

        return res;
    }
}