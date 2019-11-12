package com.xuyang.algorithm.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Auther: allanyang
 * @Date: 2019/8/26 21:21
 * @Description: 类型题集合（39，40，46，47，77，78，131）
 *
 * 给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * candidates 中的每个数字在每个组合中只能使用一次。
 *
 * 说明：
 * 所有数字（包括目标数）都是正整数。
 * 解集不能包含重复的组合。 
 *
 * 示例 1:
 * 输入: candidates = [10,1,2,7,6,1,5], target = 8,
 * 所求解集为:
 * [
 *   [1, 7],
 *   [1, 2, 5],
 *   [2, 6],
 *   [1, 1, 6]
 * ]
 *
 * 示例 2:
 * 输入: candidates = [2,5,2,1,2], target = 5,
 * 所求解集为:
 * [
 *   [1,2,2],
 *   [5]
 * ]
 *
 */
public class X_40_组合总和Ⅱ{

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if (candidates.length <= 0) {
            return new ArrayList<>();
        }

        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();

        process(res, list, candidates, target, 0);

        return res;
    }

    private void process(List<List<Integer>> res, List<Integer> list, int[] candidates, int target, int level) {
        if (target == 0) {
            res.add(new ArrayList<>(list));
            return ;
        }
        if (target < 0) {
            return ;
        }

        for (int i = level;i < candidates.length; i++) {
            if (i > level && candidates[i] == candidates[i-1]) {
                continue;
            }
            list.add(candidates[i]);
            process(res, list, candidates, target-candidates[i], i+1);
            list.remove(list.size()-1);
        }
    }
}
