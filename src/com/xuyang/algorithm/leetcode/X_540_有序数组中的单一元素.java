package com.xuyang.algorithm.leetcode;

/**
 * @Auther: allanyang
 * @Date: 2019/11/5 20:44
 * @Description:
 *
 * 给定一个只包含整数的有序数组，每个元素都会出现两次，唯有一个数只会出现一次，找出这个数。
 *
 * 示例 1:
 * 输入: [1,1,2,3,3,4,4,8,8]
 * 输出: 2
 * 示例 2:
 * 输入: [3,3,7,7,10,11,11]
 * 输出: 10
 * 注意: 您的方案应该在 O(log n)时间复杂度和 O(1)空间复杂度中运行。
 *
 */
public class X_540_有序数组中的单一元素 {

    public int singleNonDuplicate(int[] nums) {
        int left = 0;
        int right = nums.length-1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (mid % 2 == 1) {
                mid--;
            }
            if (nums[mid] == nums[mid+1]) {
                left = mid + 2;
            } else {
                right = mid;
            }
        }

        return nums[left];
    }
}