package com.xuyang.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: allanyang
 * @Date: 2019/11/11 21:38
 * @Description:
 *
 * 找出所有相加之和为 n 的 k 个数的组合。组合中只允许含有 1 - 9 的正整数，并且每种组合中不存在重复的数字。
 *
 * 说明：
 *
 * 所有数字都是正整数。
 * 解集不能包含重复的组合。 
 * 示例 1:
 *
 * 输入: k = 3, n = 7
 * 输出: [[1,2,4]]
 * 示例 2:
 *
 * 输入: k = 3, n = 9
 * 输出: [[1,2,6], [1,3,5], [2,3,4]]
 *
 */
public class X_216_组合总和III {

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<Integer> list = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();

        process(list, res, k, n, 1);

        return res;
    }

    private void process(List<Integer> list, List<List<Integer>> res, int k, int n, int index) {
        if (0 == k && n == 0) {
            res.add(new ArrayList<>(list));
            return ;
        }

        if (k <= 0 || n <= 0) {
            return ;
        }

        for (int i = index;i <= 9;i++) {
            list.add(i);
            process(list, res, k-1, n - i, i+1);
            list.remove(list.size()-1);
        }
    }
}