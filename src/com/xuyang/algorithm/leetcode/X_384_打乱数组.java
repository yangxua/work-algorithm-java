package com.xuyang.algorithm.leetcode;

import java.util.Arrays;
import java.util.Collections;

/**
 * @Auther: allanyang
 * @Date: 2019/9/4 20:19
 * @Description:
 *
 * 打乱一个没有重复元素的数组。
 *
 * 示例:
 *
 * // 以数字集合 1, 2 和 3 初始化数组。
 * int[] nums = {1,2,3};
 * Solution solution = new Solution(nums);
 *
 * // 打乱数组 [1,2,3] 并返回结果。任何 [1,2,3]的排列返回的概率应该相同。
 * solution.shuffle();
 *
 * // 重设数组到它的初始状态[1,2,3]。
 * solution.reset();
 *
 * // 随机返回数组[1,2,3]打乱后的结果。
 * solution.shuffle();
 *
 */
public class X_384_打乱数组 {

    /**
     * 一下代码放到leetcode上面是错误的，不知道题意是想干嘛。。。
     */

    private int[] nums;
    public X_384_打乱数组(int[] nums) {
        this.nums = nums;
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return nums;
    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        int[] tmp = nums.clone();
        Collections.shuffle(Arrays.asList(tmp));
        return tmp;
    }
}