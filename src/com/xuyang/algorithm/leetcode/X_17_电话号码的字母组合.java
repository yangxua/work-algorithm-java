package com.xuyang.algorithm.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Auther: allanyang
 * @Date: 2019/8/27 11:13
 * @Description:
 *
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 *
 * 输入："23"
 * 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 */
public class X_17_电话号码的字母组合 {

    private static String[] map = {
            " ",
            "",
            "abc",
            "def",
            "ghi",
            "jkl",
            "mno",
            "pqrs",
            "tuv",
            "wxyz",
    };

    /**
     * 回溯法
     */
    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) {
            return new ArrayList<>();
        }

        List<String> res = new ArrayList<>();
        process(res, "", digits);

        return res;
    }

    private void process(List<String> res, String str, String digits) {
        if (str.length() == digits.length()) {
            res.add(str);
            return;
        }

        char c = digits.charAt(str.length());
        String s = map[c - '0'];

        for(int i = 0;i < s.length();i++) {
            str += s.charAt(i);
            process(res, str, digits);
            str = str.substring(0, str.length()-1);
        }
    }

    /**
     * 迭代法
     * 类似于宽度优先遍历（BFS）
     */
    public List<String> letterCombinations1(String digits) {
        if (digits.length() == 0) {
            return new ArrayList<>();
        }

        LinkedList<String> res = new LinkedList<>();
        res.add("");

        while (res.peek().length() != digits.length()) {
            String prefix = res.removeFirst();
            String str = map[digits.charAt(prefix.length()) - '0'];
            for (char c : str.toCharArray()) {
                res.add(prefix + c);
            }
        }

        return res;
    }

}