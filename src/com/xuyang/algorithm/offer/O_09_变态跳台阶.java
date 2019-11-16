package com.xuyang.algorithm.offer;

/**
 * @Auther: allanyang
 * @Date: 2019/11/16 12:26
 * @Description:
 *
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
 */
public class O_09_变态跳台阶 {

    /**
     * 排列组合问题，每个台接都可以选择条或者不跳（不可以回调），所以右2 ^ (n-1)中跳法
     */
    public int JumpFloorII(int target) {

        return 1 << (target-1);
    }
}