package com.xuyang.algorithm.offer;

/**
 * @Auther: allanyang
 * @Date: 2019/12/3 14:20
 * @Description:
 *
 * 求1+2+3+...+n，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 */
public class O_47_求前n和 {

    public int Sum_Solution(int n) {
        int res = n;
        boolean flag = (res > 0)&& ((res += Sum_Solution(--n)) != -1);
        return res;
    }
}