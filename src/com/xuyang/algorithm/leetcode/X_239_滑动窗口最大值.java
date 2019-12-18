package com.xuyang.algorithm.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Auther: allanyang
 * @Date: 2019/12/17 21:46
 * @Description:
 *
 * 给定一个数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 *
 * 返回滑动窗口中的最大值。
 *
 *  
 *
 * 示例:
 *
 * 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
 * 输出: [3,3,5,5,6,7]
 * 解释:
 *
 *   滑动窗口的位置                最大值
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 *  1 [3  -1  -3] 5  3  6  7       3
 *  1  3 [-1  -3  5] 3  6  7       5
 *  1  3  -1 [-3  5  3] 6  7       5
 *  1  3  -1  -3 [5  3  6] 7       6
 *  1  3  -1  -3  5 [3  6  7]      7
 *
 */
public class X_239_滑动窗口最大值 {

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k <= 1) {
            return nums;
        }

        List<Integer> list = new ArrayList<>();
        LinkedList<Integer> window = new LinkedList<>();
        int begin;
        for (int i = 0;i < nums.length;i++) {
            begin = i - k + 1;
            if (!window.isEmpty() && window.peekFirst() < begin) {
                window.pollFirst();
            }
            while (!window.isEmpty() && nums[window.peekLast()] <= nums[i]) {
                window.pollLast();
            }
            window.add(i);
            if (begin >= 0) {
                list.add(nums[window.peekFirst()]);
            }
        }

        return listToArray(list);
    }

    private int[] listToArray(List<Integer> list) {
        int[] res = new int[list.size()];
        for (int i = 0;i < res.length;i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}