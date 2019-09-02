package com.xuyang.algorithm.leetcode;

/**
 * @Auther: allanyang
 * @Date: 2019/8/23 10:13
 * @Description:
 *
 * 在第一行我们写上一个 0。接下来的每一行，将前一行中的0替换为01，1替换为10。
 * 给定行数 N 和序数 K，返回第 N 行中第 K个字符。（K从1开始）
 *
 *
 * 例子:
 * 输入: N = 1, K = 1
 * 输出: 0
 * 输入: N = 2, K = 1
 * 输出: 0
 * 输入: N = 2, K = 2
 * 输出: 1
 * 输入: N = 4, K = 5
 * 输出: 1
 *
 * 解释:
 * 第一行: 0
 * 第二行: 01
 * 第三行: 0110
 * 第四行: 01101001
 *
 *
 * //附图
 * //序号
 * //              1
 * //          /        \
 * //      1                2
 * //    /   \            /    \
 * //  1       2        3       4
 * // / \     /  \     /  \    / \
 * //1   2   3    4   5    6  7   8
 *
 * //01排列
 * //              0
 * //          /        \
 * //      0                1
 * //    /   \            /    \
 * //  0       1        1       0
 * // / \     /  \     /  \    / \
 * //0   1   1    0   1    0  0   1
 *
 */
public class X_779_第K个语法符号 {

    /**
     *  1：当K < len(N/2)时, 等于（N-1，K）
     *  2：当K > len(N/2)时，等（N-1，K-preLen）的另一个值，因为只有0和1，因此用1-kthGrammar(N-1, K-preLen)来达到取反的效果
     *
     *  注：此题也可以根据K的就奇偶性来根据前一行做判断，但是此类型题类似于观察题，只做这一种简单解法
     */
    public int kthGrammar(int N, int K) {
        if (N == 1) {
            return 0;
        }
        if (N == 2) {
            return K == 1 ? 0 : 1;
        }

        int preLen = (1 << (N-1)) / 2;

        if (K <= preLen) {
            return kthGrammar(N-1, K);
        } else {
            return 1-kthGrammar(N-1, K-preLen);
        }
    }
}