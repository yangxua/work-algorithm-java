package com.xuyang.algorithm.leetcode;

import java.util.*;

/**
 * @Auther: allanyang
 * @Date: 2019/9/26 17:01
 * @Description:
 *
 * 给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
 * 示例 1:
 * 输入: nums = [1,1,1,2,2,3], k = 2
 * 输出: [1,2]
 * 示例 2:
 * 输入: nums = [1], k = 1
 * 输出: [1]
 *
 */
public class X_347_前K个高频元素 {


    public List<Integer> topKFrequent(int[] nums, int k) {
        if (nums.length == 0) {
            return new ArrayList<>();
        }

        List<Integer> res = new ArrayList<>(k);
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        ArrayList<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, (o1, o2) -> o2.getValue() - o1.getValue());

        for (int i = 0;i < k;i++) {
            res.add(list.get(i).getKey());
        }

        return res;
    }
}