package com.xuyang.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: allanyang
 * @Date: 2019/8/26 16:43
 * @Description:
 *
 * 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
 *
 * 例如，给出 n = 3，生成结果为：
 *
 * [
 *   "((()))",
 *   "(()())",
 *   "(())()",
 *   "()(())",
 *   "()()()"
 * ]
 *
 *
 */
public class X_22_括号生成 {

    public List<String> generateParenthesis(int n) {
        if (n == 0) {
            return new ArrayList<>();
        }

        List<String> res = new ArrayList<>();

        process(res, n, n, "");

        return res;
    }

    private void process(List<String> res, int left, int right, String s) {
        if (left == 0 && right == 0) {
            res.add(s);
            return ;
        }

        if (left > right || left < 0 || right < 0) {
            return;
        }

        s += '(';
        process(res, left-1, right, s);
        s = s.substring(0, s.length()-1);

        s += ')';
        process(res, left, right-1, s);
        //这里不用回溯，因为以后不再用到，其实循环的最后一次回溯都是用不到的
    }
}