package com.xuyang.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: allanyang
 * @Date: 2019/8/26 21:09
 * @Description: 类型题集合（39，40，46，47，77，78，131）
 *
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * candidates 中的数字可以无限制重复被选取。
 *
 *
 * 说明：
 *
 * 所有数字（包括 target）都是正整数。
 * 解集不能包含重复的组合。 
 * 示例 1:
 *
 * 输入: candidates = [2,3,6,7], target = 7,
 * 所求解集为:
 * [
 *   [7],
 *   [2,2,3]
 * ]
 * 示例 2:
 *
 * 输入: candidates = [2,3,5], target = 8,
 * 所求解集为:
 * [
 *   [2,2,2,2],
 *   [2,3,3],
 *   [3,5]
 * ]
 *
 */
public class X_39_组合总数 {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates.length == 0) {
            return new ArrayList<>();
        }

        //Arrays.sort(candidates);

        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();

        process(res, list, candidates, 0, target);

        return res;
    }

    private void process(List<List<Integer>> res, List<Integer> list, int[] candidates, int level, int target) {
        if (target == 0) {
            res.add(new ArrayList<>(list));
            return ;
        }
        if (target < 0) {
            return ;
        }

        for (int i = level; i < candidates.length;i++) {
            if (target < candidates[i]) {
                return;
            }
            list.add(candidates[i]);
            process(res, list, candidates, i, target-candidates[i]);
            list.remove(list.size()-1);
        }
    }


}