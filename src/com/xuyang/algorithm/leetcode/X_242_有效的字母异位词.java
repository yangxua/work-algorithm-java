package com.xuyang.algorithm.leetcode;

/**
 * @Auther: allanyang
 * @Date: 2019/9/3 17:53
 * @Description:
 *
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 * 注：异位词就是打算元素的顺序
 *
 * 示例 1:
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 * 示例 2:
 * 输入: s = "rat", t = "car"
 * 输出: false
 *
 */
public class X_242_有效的字母异位词 {

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int[] arr = new int[52];
        for (int i = 0;i < s.length();i++) {
            arr[s.charAt(i)-'a']++;
            arr[t.charAt(i)-'a']--;
        }

        for (int i = 0;i < arr.length;i++) {
            if (arr[i] != 0) {
                return false;
            }
        }

        return true;
    }
}