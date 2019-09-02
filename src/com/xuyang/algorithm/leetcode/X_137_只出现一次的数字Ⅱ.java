package com.xuyang.algorithm.leetcode;

/**
 * @Auther: allanyang
 * @Date: 2019/8/27 17:51
 * @Description:
 *
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现了三次。找出那个只出现了一次的元素。
 *
 * 说明：
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 *
 * 示例 1:
 * 输入: [2,2,3,2]
 * 输出: 3
 *
 * 示例 2:
 * 输入: [0,1,0,1,0,1,99]
 * 输出: 99
 *
 */
public class X_137_只出现一次的数字Ⅱ {

    /**
     * 万能法
     *
     * 每个数出现三次，那么我们把所有的位出现的次数统计出来，当不是3的的时候就是那个单独的数在这一位是1
     * 当每个数出现k次的时候，那么不是k的时候那个单独的数在这一位是1
     */
    public int singleNumber(int[] nums) {
        int res = 0;

        for (int i = 0;i < 32;i++) {
            int cnt = 0;
            int mask = 1 << i;

            for (int num : nums) {
                if ((num & mask) != 0) {
                   cnt++;
                }
            }

            if ((cnt % 3) != 0) {
                res |= mask;
            }
        }

        return res;
    }

    /**
     * 位运算
     *
     * 当出现三次的时候，就将其变成0
     * 如果把题中只有一个数出现两次，那么返回twos
     *
     * debug一下就知道算法干的什么
     *
     * 0 ^ x = x,
     * x ^ x = 0；
     * x & ~x = 0,
     * x & ~0 =x;
     */
    public int singleNumber1(int[] nums) {
        int ones = 0, twos = 0;

        for(int i = 0; i < nums.length; i++){
            ones = (ones ^ nums[i]) & ~twos;
            twos = (twos ^ nums[i]) & ~ones;
        }

        return ones;
    }

    public static void main(String[] args) {
        X_137_只出现一次的数字Ⅱ s = new X_137_只出现一次的数字Ⅱ();
        s.singleNumber1(new int[]{2,2,2,3});
    }
}