package com.xuyang.algorithm.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: allanyang
 * @Date: 2019/9/3 15:46
 * @Description:
 *
 * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
 *
 * 案例:
 * s = "leetcode"
 * 返回 0.
 *
 * s = "loveleetcode",
 * 返回 2.
 *
 */
public class X_387_字符串中的第一个唯一字符 {

    public int firstUniqChar(String s) {
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0;i < s.length();i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0)+1);
        }

        for (int i = 0;i < s.length();i++) {
            if (map.get(s.charAt(i)).equals(1)) {
                return i;
            }
        }

        return -1;
    }
}