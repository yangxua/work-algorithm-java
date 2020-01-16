package com.xuyang.algorithm.interview;

/**
 * @Auther: allanyang
 * @Date: 2020/1/14 16:58
 * @Description:
 */
public class 分布式 {

    // 1.全局性id怎么生成？
    /**
     * 1.单独弄一个数据库，来生成id：性能低，可用性低
     * 2.多个数据库，并可以预缓存：当系统挂掉的时候会造成部分id丢失。
     * 3.uuid：可读性差，当作主键后性能差
     * 4.redis：单机性能可能会出现瓶颈，如果集群又会出现数据库集群问题，如果原系统不依赖redis又要引入依赖。（相对较好）
     * 5.snowflake:
     *      0   101010000010100001010111000101001100001110   10111  00011  101011100110
     *      A                       B                          C      D         E
     *  A：固定是0，表示是正整数
     *  B：请求时间时间戳
     *  C：机房id
     *  D：机器id
     *  E：前边固定的时候，第一个请求为1，第二个是2，一次类推
     */

    public static void main(String[] args) {
        String substring = "1101010000010100001010111000101001100001110101110".substring(1, 43);
        System.out.println(substring.length());
        System.out.println(substring);
    }
}