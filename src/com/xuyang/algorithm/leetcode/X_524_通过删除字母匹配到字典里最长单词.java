package com.xuyang.algorithm.leetcode;

import java.util.List;

/**
 * @Auther: allanyang
 * @Date: 2019/11/8 17:30
 * @Description:
 *
 * 给定一个字符串和一个字符串字典，找到字典里面最长的字符串，该字符串可以通过删除给定字符串的某些字符来得到。如果答案不止一个，返回长度最长且字典顺序最小的字符串。如果答案不存在，则返回空字符串。
 *
 * 示例 1:
 * 输入:
 * s = "abpcplea", d = ["ale","apple","monkey","plea"]
 * 输出:
 * "apple"
 * 示例 2:
 * 输入:
 * s = "abpcplea", d = ["a","b","c"]
 * 输出:
 * "a"
 *
 */
public class X_524_通过删除字母匹配到字典里最长单词 {

    public String findLongestWord(String s, List<String> d) {
        String res = "";

        for (String cur : d) {
            int resLength = res.length();
            int curLength = cur.length();
            if (curLength < resLength
                    || (curLength == resLength && res.compareTo(cur) < 0)) {
                continue;
            }

            if (isSubStr(s, cur)) {
                res = cur;
            }
        }

        return res;
    }

    private boolean isSubStr(String s, String cur) {
        int i = 0;
        int j = 0;

        while (i < s.length() && j < cur.length()) {
            if (s.charAt(i++) == cur.charAt(j)) {
                j++;
            }
        }

        return j == cur.length();
    }


}