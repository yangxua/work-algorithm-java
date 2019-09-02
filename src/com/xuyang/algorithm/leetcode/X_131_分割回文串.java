package com.xuyang.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: allanyang
 * @Date: 2019/8/26 21:40
 * @Description: 类型题集合（39，40，46，47，77，78，131）
 *
 * 给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。
 * 返回 s 所有可能的分割方案。
 *
 * 示例:
 * 输入: "aab"
 * 输出:
 * [
 *   ["aa","b"],
 *   ["a","a","b"]
 * ]
 *
 */
public class X_131_分割回文串 {

    public List<List<String>> partition(String s) {
        if (s.length() <= 0) {
            return new ArrayList<>();
        }

        List<List<String>> res = new ArrayList<>();
        List<String> list = new ArrayList<>();

        process(res,list,s,0);

        return res;
    }

    private void process(List<List<String>> res, List<String> list, String s, int level) {
        if (level == s.length()) {
            res.add(new ArrayList<>(list));
            return ;
        }

        for (int i = level; i < s.length();i++) {
            if (isPalindrome(s,level,i)) {
                list.add(s.substring(level, i+1));
                process(res, list, s, i+1);
                list.remove(list.size()-1);
            }
        }
    }

    private boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left++) != s.charAt(right--)) {
                return false;
            }
        }
        return true;
    }
}