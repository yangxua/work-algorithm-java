package com.xuyang.algorithm.leetcode;

/**
 * @Auther: allanyang
 * @Date: 2019/8/22 20:59
 * @Description:
 *
 *实现 pow(x, n) ，即计算 x 的 n 次幂函数。
 *
 * 示例 1:
 * 输入: 2.00000, 10
 * 输出: 1024.00000
 *
 * 示例 2:
 * 输入: 2.10000, 3
 * 输出: 9.26100
 *
 * 示例 3:
 * 输入: 2.00000, -2
 * 输出: 0.25000
 * 解释: 2-2 = 1/22 = 1/4 = 0.25
 *
 */
public class X_50_x的n次方 {

    /**
     * 递归方法
     * 注意n为最小值时会溢出，因此需要特殊处理。将其加以加以变成奇数，按照奇数的方法再乘以一个刚刚加的加一位1
     */
    public double myPow(double x, int n) {
        if (n == Integer.MIN_VALUE) {
            n++;
            x = 1/x;
            n = -n;
            return x * x * myPow(x * x , n / 2);
        }
        if (n == 0){
            return 1;
        }
        if (n < 0) {
            x = 1/x;
            n = -n;
        }

        return (n % 2 == 0) ? myPow(x * x , n / 2) : x * myPow(x * x , n / 2);
    }


    /**
     * 位方法
     *
     * N = 9 = 2^3 + 2^0 = 1001 in binary. Then:
     * x^9 = x^(2^3) * x^(2^0)
     * ---   -------   -------
     * 我们将用---标记起来的值用res来保存。
     */
    public double myPow1(double x, int n) {
        double res = 1;
        long absN = Math.abs((long)n);

        while (absN != 0) {
            if ((absN&1) == 1) {
                res *= x;
            }
            absN >>= 1;
            x *= x;
        }

        return n > 0 ? res : 1/res;
    }

}