package com.xuyang.algorithm.offer;

/**
 * @Auther: allanyang
 * @Date: 2019/11/16 13:13
 * @Description:
 *
 * 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
 */
public class O_11_二进制中1的个数 {

    public int NumberOf1(int n) {
        int count = 0;

        while (n != 0) {
            n &= n-1;
            count++;
        }

        return count;
    }
}