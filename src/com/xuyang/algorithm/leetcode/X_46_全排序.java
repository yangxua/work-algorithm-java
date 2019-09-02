package com.xuyang.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: allanyang
 * @Date: 2019/8/26 20:33
 * @Description: 类型题集合（39，40，46，47，77，78，131）
 *
 * 给定一个没有重复数字的序列，返回其所有可能的全排列。
 *
 * 示例:
 * 输入: [1,2,3]
 *
 * 输出:
 * [
 *   [1,2,3],
 *   [1,3,2],
 *   [2,1,3],
 *   [2,3,1],
 *   [3,1,2],
 *   [3,2,1]
 * ]
 *
 */
public class X_46_全排序 {

    public List<List<Integer>> permute(int[] nums) {
        if (nums.length <= 0) {
            return new ArrayList<>();
        }

        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        process(nums, list,res);

        return res;
    }

    private void process(int[] nums,  List<Integer> list, List<List<Integer>> res) {
        if (list.size() == nums.length) {
            res.add(new ArrayList<>(list));
            return ;
        }

        for (int i = 0;i < nums.length;i++) {
            if (!list.contains(nums[i])) {
                list.add(nums[i]);
                process(nums,  list, res);
                list.remove(list.size()-1);
            }
        }
    }
}