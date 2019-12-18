package com.xuyang.algorithm.leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * @Auther: allanyang
 * @Date: 2019/12/17 20:59
 * @Description:
 */
public class X_225_用队列实现栈 {
}

class MyStack {

    List<Integer> queue1;
    List<Integer> queue2;

    /** Initialize your data structure here. */
    public MyStack() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        if (queue1.isEmpty()) {
            queue2.add(x);
        } else {
            queue1.add(x);
        }
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        if (queue1.isEmpty()) {
            while (queue2.size() != 1) {
                queue1.add(queue2.remove(0));
            }
            return queue2.remove(0);
        } else {
            while (queue1.size() != 1) {
                queue2.add(queue1.remove(0));
            }
            return queue1.remove(0);
        }
    }

    /** Get the top element. */
    public int top() {
        if (queue1.isEmpty()) {
            while (queue2.size() != 1) {
                queue1.add(queue2.remove(0));
            }
            int tmp = queue2.remove(0);
            queue1.add(tmp);
            return tmp;
        } else {
            while (queue1.size() != 1) {
                queue2.add(queue1.remove(0));
            }
            int tmp = queue1.remove(0);
            queue2.add(tmp);
            return tmp;
        }
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue1.isEmpty() && queue2.isEmpty();
    }
}