package com.xuyang.algorithm.leetcode;

/**
 * @Auther: allanyang
 * @Date: 2019/9/29 11:14
 * @Description:
 *
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 * 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
 * 你可以假设数组中不存在重复的元素。
 * 你的算法时间复杂度必须是 O(log n) 级别。
 *
 * 示例 1:
 * 输入: nums = [4,5,6,7,0,1,2], target = 0
 * 输出: 4
 * 示例 2:
 * 输入: nums = [4,5,6,7,0,1,2], target = 3
 * 输出: -1
 *
 */
public class X_33_搜索旋转排序数组 {

    public int search(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        }

        int left = 0;
        int right = nums.length-1;

        while (left < right) {
            int mid = left + right >>> 1;
            //eg: 3 4 5 6 7 1 2
            if (nums[mid] > nums[right]) {
                if (nums[mid] < target || target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
                //eg: 6 7 1 2 3 4 5
            } else {
                if (nums[mid] < target && target <= nums[right] ) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
        }

        return nums[left] == target ? left : -1;
    }
}