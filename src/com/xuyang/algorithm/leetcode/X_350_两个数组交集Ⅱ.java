package com.xuyang.algorithm.leetcode;

import java.util.*;

/**
 * @Auther: allanyang
 * @Date: 2019/8/28 21:08
 * @Description:
 *
 * 给定两个数组，编写一个函数来计算它们的交集。
 *
 * 示例 1:
 * 输入: nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出: [2,2]
 *
 * 示例 2:
 * 输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出: [4,9]
 * 说明：
 *
 * 输出结果中每个元素出现的次数，应与元素在两个数组中出现的次数一致。
 * 我们可以不考虑输出结果的顺序。
 *
 */
public class X_350_两个数组交集Ⅱ {

    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> tmp = new ArrayList<>();

        for (int num : nums1) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (int num : nums2) {
            if (map.getOrDefault(num, 0) > 0) {
                tmp.add(num);
                map.put(num, map.get(num)-1);
            }
        }

        int[] arr = new int[tmp.size()];
        for (int i = 0;i < tmp.size();i++) {
            arr[i] = tmp.get(i);
        }

        return arr;
    }
}