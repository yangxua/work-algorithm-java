package com.xuyang.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: allanyang
 * @Date: 2019/8/26 11:34
 * @Description: 类型题集合（39，40，46，47，77，78，131）
 *
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 *
 * 示例:
 * 输入: n = 4, k = 2
 * 输出:
 * [
 *   [2,4],
 *   [3,4],
 *   [2,3],
 *   [1,2],
 *   [1,3],
 *   [1,4],
 * ]
 *
 */
public class X_77_组合 {

    public List<List<Integer>> combine(int n, int k) {
        if (n < k) {
            return new ArrayList<>();
        }

        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        
        process(res, list, n, k, 1);
        
        return res;
    }

    private void process(List<List<Integer>> res, List<Integer> list, int n, int k, int index) {
        if (list.size() == k) {
            res.add(new ArrayList<>(list));
            return ;
        }

        for (int i = index;i <= n;i++) {
            list.add(i);
            process(res, list, n, k, i+1);
            list.remove(list.size()-1);
        }
    }
}