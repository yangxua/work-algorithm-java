package com.xuyang.algorithm.leetcode;

/**
 * @Auther: allanyang
 * @Date: 2019/9/5 21:46
 * @Description:
 *
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 *
 * 示例 1：
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * 示例 2：
 * 输入: "cbbd"
 * 输出: "bb"
 *
 */
public class X_05_最长回文字串 {

    public String longestPalindrome(String s) {
        if (s.length() < 2) {
            return s;
        }

        boolean[][] flag = new boolean[s.length()][s.length()];
        String res = s.substring(0,1);

        for (int r = 1;r < s.length();r++) {
            for (int l = 0;l < r;l++) {
                if (s.charAt(l) == s.charAt(r) && (r - l <= 2 || flag[l+1][r-1])) {
                    flag[l][r] = true;
                    if (r - l + 1 > res.length()) {
                        res = s.substring(l,r+1);
                    }
                }
            }
        }

        return res;
    }
}