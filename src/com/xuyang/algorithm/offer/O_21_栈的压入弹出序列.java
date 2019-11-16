package com.xuyang.algorithm.offer;

import java.util.Stack;

/**
 * @Auther: allanyang
 * @Date: 2019/11/16 15:31
 * @Description:
 *
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否可能为该栈的弹出顺序。假设压入栈的所有数字均不相等。例如序列1,2,3,4,5是某栈的压入顺序，序列4,5,3,2,1是该压栈序列对应的一个弹出序列，但4,3,5,1,2就不可能是该压栈序列的弹出序列。（注意：这两个序列的长度是相等的）
 */
public class O_21_栈的压入弹出序列 {


    public boolean IsPopOrder(int [] pushA,int [] popA) {
        Stack<Integer> s = new Stack<>();
        int n = pushA.length;

        int pushIndex = 0;
        int popIndex = 0;
        while (pushIndex < n) {
            s.push(pushA[pushIndex++]);
            while (popIndex < n && !s.isEmpty()
                    && popA[popIndex] == s.peek()) {
                s.pop();
                popIndex++;
            }
        }

        return s.isEmpty();
    }
}