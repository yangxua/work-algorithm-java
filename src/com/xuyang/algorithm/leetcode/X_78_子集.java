package com.xuyang.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: allanyang
 * @Date: 2019/8/26 20:42
 * @Description: 类型题集合（39，40，46，47，77，78，131）
 *
 * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 * 说明：解集不能包含重复的子集。
 *
 * 示例:
 * 输入: nums = [1,2,3]
 * 输出:
 * [
 *   [3],
 *   [1],
 *   [2],
 *   [1,2,3],
 *   [1,3],
 *   [2,3],
 *   [1,2],
 *   []
 * ]
 *
 */
public class X_78_子集 {

    public List<List<Integer>> subsets(int[] nums) {
        if (nums.length == 0) {
            return new ArrayList<>();
        }
        //Arrays.sort(nums); 根据题意，有时需要排序，有时不需要
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        process(nums, 0, list, res);

        return res;
    }

    private void process(int[] nums, int level, List<Integer> list, List<List<Integer>> res) {
        res.add(new ArrayList<>(list));

        for (int i = level;i < nums.length;i++) {
            list.add(nums[i]);
            process(nums, i+1, list, res);
            list.remove(list.size()-1);
        }
    }
}