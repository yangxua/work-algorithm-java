package com.xuyang.algorithm.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Auther: allanyang
 * @Date: 2019/8/26 20:52
 * @Description:
 *
 * 给定一个可能包含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 * 说明：解集不能包含重复的子集。
 *
 * 示例:
 * 输入: [1,2,2]
 * 输出:
 * [
 *   [2],
 *   [1],
 *   [1,2,2],
 *   [2,2],
 *   [1,2],
 *   []
 * ]
 *
 */
public class X_90_组合Ⅱ {

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        if (nums.length <= 0) {
            return new ArrayList<>();
        }

        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();

        process(res, list, nums, 0);

        return res;
    }

    private void process(List<List<Integer>> res, List<Integer> list, int[] nums, int level) {
        res.add(new ArrayList<>(list));

        for (int i = level; i < nums.length;i++) {
            if (i > level && nums[i] == nums[i-1]) {
                continue;
            }
            list.add(nums[i]);
            process(res,list,nums,i+1);
            list.remove(list.size()-1);
        }
    }
}