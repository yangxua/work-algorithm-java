package com.xuyang.algorithm.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Auther: allanyang
 * @Date: 2019/8/26 21:00
 * @Description: 类型题集合（39，40，46，47，77，78，131）
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
            if (target < candidates[i]) {
                break;
            }
            list.add(candidates[i]);
            process(res, list, candidates, target-candidates[i], i+1);
            list.remove(list.size()-1);
        }
    }
}