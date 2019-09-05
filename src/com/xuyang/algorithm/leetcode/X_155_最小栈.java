package com.xuyang.algorithm.leetcode;

import java.util.Stack;

/**
 * @Auther: allanyang
 * @Date: 2019/9/4 20:36
 * @Description:
 *
 * 设计一个支持 push，pop，top 操作，并能在常数时间内检索到最小元素的栈。
 *
 * push(x) -- 将元素 x 推入栈中。
 * pop() -- 删除栈顶的元素。
 * top() -- 获取栈顶元素。
 * getMin() -- 检索栈中的最小元素。
 * 示例:
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> 返回 -3.
 * minStack.pop();
 * minStack.top();      --> 返回 0.
 * minStack.getMin();   --> 返回 -2.
 *
 */
public class X_155_最小栈 {

    private Stack<Integer> stack;
    private Stack<Integer> minStack;
    public X_155_最小栈() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
        while (minStack.isEmpty() || minStack.peek() <= x) {
            minStack.push(x);
        }
    }

    public void pop() {
        Integer x = stack.pop();
        if (minStack.peek().equals(x)) {
            minStack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}