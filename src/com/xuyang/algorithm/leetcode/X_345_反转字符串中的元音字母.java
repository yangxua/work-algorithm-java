package com.xuyang.algorithm.leetcode;

import java.util.Arrays;
import java.util.List;

/**
 * @Auther: allanyang
 * @Date: 2019/11/8 15:44
 * @Description:]
 *
 * 编写一个函数，以字符串作为输入，反转该字符串中的元音字母。
 *
 * 示例 1:
 * 输入: "hello"
 * 输出: "holle"
 * 示例 2:
 * 输入: "leetcode"
 * 输出: "leotcede"
 * 说明:
 * 元音字母不包含字母"y"。
 */
public class X_345_反转字符串中的元音字母 {

    private static final List<Character> list = Arrays.asList('a','e','i','o','u','A','E','I','O','U');

    public String reverseVowels(String s) {
        if (s.length() <= 1) {
            return s;
        }

        int left = 0;
        int right = s.length()-1;
        char[] chars = s.toCharArray();

        while (left < right) {
            while (left < right && !list.contains(chars[left])) {
                left++;
            }
            while (left < right && !list.contains(chars[right])) {
                right--;
            }
            char before = s.charAt(left);
            char after = s.charAt(right);

            chars[left++] = after;
            chars[right--] = before;
        }

        return new String(chars);
    }

    public static void main(String[] args) {
        X_345_反转字符串中的元音字母 s = new X_345_反转字符串中的元音字母();
        System.out.println(s.reverseVowels("hello"));
    }
}