package com.xuyang.algorithm.offer;

/**
 * @Auther: allanyang
 * @Date: 2019/11/19 09:36
 * @Description:
 *
 * 求出1~13的整数中1出现的次数,并算出100~1300的整数中1出现的次数？为此他特别数了一下1~13中包含1的数字有1、10、11、12、13因此共出现6次,但是对于后面问题他就没辙了。ACMer希望你们帮帮他,并把问题更加普遍化,可以很快的求出任意非负整数区间中1出现的次数（从1 到 n 中1出现的次数）。
 *
 *
 */
public class O_31_整数中1出现的次数从1到n整数中1出现的次数 {

    /**
     * https://www.nowcoder.com/profile/2461664/codeBookDetail?submissionId=14820234
     */
    public int NumberOf1Between1AndN_Solution(int n) {
        int ones = 0;
        for(int m = 1; m <= n; m *= 10){
            ones += (n/m + 8) / 10 * m + (n/m%10 == 1 ? n%m+1 : 0);
        }
        return ones;
    }
}