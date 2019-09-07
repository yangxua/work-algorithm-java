package com.xuyang.algorithm.leetcode;

import java.util.Arrays;

/**
 * @Auther: allanyang
 * @Date: 2019/9/5 17:01
 * @Description:
 *
 * 给定一个包含 n + 1 个整数的数组 nums，其数字都在 1 到 n 之间（包括 1 和 n），可知至少存在一个重复的整数。假设只有一个重复的整数，找出这个重复的数。
 *
 * 示例 1:
 * 输入: [1,3,4,2,2]
 * 输出: 2
 * 示例 2:
 * 输入: [3,1,3,4,2]
 * 输出: 3
 * 说明：
 *
 * 不能更改原数组（假设数组是只读的）。
 * 只能使用额外的 O(1) 的空间。
 * 时间复杂度小于 O(n2) 。
 * 数组中只有一个重复的数字，但它可能不止重复出现一次。
 *
 */
public class X_287_寻找重复数 {

    /**
     * 链表有环方法判断
     */
    public int findDuplicate(int[] nums) {
        int fast = nums[0];
        int slow = nums[0];

        do {
            fast = nums[nums[fast]];
            slow = nums[slow];
        } while (fast != slow);

        fast = nums[0];
        while (fast != slow) {
            fast = nums[fast];
            slow = nums[slow];
        }

        return nums[fast];
    }

    /**
     * 排序
     */
    public int findDuplicate1(int[] nums) {
        if (nums.length <= 2) {
            return nums[0];
        }

        Arrays.sort(nums);

        int left = 0;
        int right = nums.length-1;
        while (left < right) {
            int mid = (left + right + 1) >>> 1;
            if (nums[mid] < mid+1 ) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }

        return nums[left];
    }
}