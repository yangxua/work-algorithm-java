package com.xuyang.algorithm.leetcode;

import java.util.*;

/**
 * @Auther: allanyang
 * @Date: 2019/9/5 21:20
 * @Description:
 */
public class X_49_字母异位词分组 {

    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 0) {
            return new ArrayList<>();
        }

        Map<String,List<String>> map = new HashMap<>();

        for (String str : strs) {
            String s = sort(str);
            List<String> list = map.getOrDefault(s, new ArrayList<>());
            list.add(str);
            map.put(s, list);
        }

        return new ArrayList<>(map.values());
    }

    private String sort(String str) {
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        return String.valueOf(chars);
    }
}