package com.xuyang.algorithm.leetcode;

/**
 * @Auther: allanyang
 * @Date: 2019/11/8 16:06
 * @Description:
 *
 * 给定一个非空字符串 s，最多删除一个字符。判断是否能成为回文字符串。
 *
 * 示例 1:
 * 输入: "aba"
 * 输出: True
 * 示例 2:
 * 输入: "abca"
 * 输出: True
 * 解释: 你可以删除c字符。
 *
 * 注意:
 * 字符串只包含从 a-z 的小写字母。字符串的最大长度是50000。
 */
public class X_680_验证回文字符串Ⅱ {

    public boolean validPalindrome(String s) {
        if (s.length() <= 1) {
            return true;
        }

        int left = 0;
        int right = s.length()-1;

        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return isPalindrome(s, left, right-1) || isPalindrome(s, left+1, right);
            }

            left++;
            right--;
        }

        return true;
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