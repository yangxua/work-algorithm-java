package com.xuyang.algorithm.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Auther: allanyang
 * @Date: 2019/8/26 21:00
 * @Description: 类型题集合（39，40，46，47，77，78，131）
 * 英文版leetcode有讲解
 *
 * 给定一个可包含重复数字的序列，返回所有不重复的全排列。
 *
 * 示例:
 * 输入: [1,1,2]
 * 输出:
 * [
 *   [1,1,2],
 *   [1,2,1],
 *   [2,1,1]
 * ]
 *
 */
public class X_47_全排序Ⅱ {

    public List<List<Integer>> permuteUnique(int[] nums) {
        if (nums.length <= 0) {
            return new ArrayList<>();
        }

        boolean[] flag = new boolean[nums.length];
        List<Integer> list = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();

        Arrays.sort(nums);
        process(nums, list, res, flag);

        return res;
    }

    private void process(int[] nums, List<Integer> list, List<List<Integer>> res, boolean[] flag) {
        if (list.size() == nums.length) {
            res.add(new ArrayList<>(list));
            return ;
        }

        for (int i = 0;i < nums.length;i++) {
            if (flag[i]) {
                continue;
            }
            if (i > 0 && nums[i] == nums[i-1] && !flag[i-1]) {
                continue;
            }

            flag[i] = true;
            list.add(nums[i]);
            process(nums, list, res, flag);
            list.remove(list.size()-1);
            flag[i] = false;
        }
    }

}