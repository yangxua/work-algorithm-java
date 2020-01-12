package com.xuyang.algorithm.leetcode;

/**
 * @Auther: allanyang
 * @Date: 2019/12/19 21:01
 * @Description:
 *
 * 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 *
 * 示例 1:
 * 输入: [3,2,3]
 * 输出: 3
 * 示例 2:
 * 输入: [2,2,1,1,1,2,2]
 * 输出: 2
 *
 */
public class X_169_多数元素 {

    public int majorityElement(int[] nums) {
        int res = nums[0];
        int count = 1;

        for (int i = 1;i < nums.length;i++) {
            if (nums[i] == res) {
                count++;
            } else {
                if (count-- == 0) {
                    count = 1;
                    res = nums[i];
                }
            }
        }

        return res;
    }
}