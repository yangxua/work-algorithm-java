package com.xuyang.algorithm.leetcode;

/**
 * @Auther: allanyang
 * @Date: 2019/9/5 14:57
 * @Description:
 *
 * 实现 int sqrt(int x) 函数。
 * 计算并返回 x 的平方根，其中 x 是非负整数。
 *
 * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 *
 * 示例 1:
 * 输入: 4
 * 输出: 2
 *
 * 示例 2:
 * 输入: 8
 * 输出: 2
 * 说明: 8 的平方根是 2.82842...,
 *      由于返回类型是整数，小数部分将被舍去。
 *
 */
public class X_69_x的平方根 {

    /**
     * 此题也可以采用遍历法和牛顿法。
     * 遍历法写法比较简单，不写出代码实现
     * 牛顿法设计到的数学知识较多，虽然比二分法要更好一些，但是不具有普遍性，如果有兴趣可以自行百度学习
     */
    public int mySqrt(int x) {
        if (x <= 1) {
            return x;
        }

        long left = 0;
        long right = x;
        while (left < right) {
            long mid = (left+right+1)>>>1;
            if (mid * mid > x) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }

        return (int) left;
    }
}