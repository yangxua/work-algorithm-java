package com.xuyang.algorithm.leetcode.multi;

import java.util.concurrent.Semaphore;

/**
 * @Auther: allanyang
 * @Date: 2019/11/8 18:02
 * @Description:
 *
 * 我们提供一个类：
 * class FooBar {
 *   public void foo() {
 *     for (int i = 0; i < n; i++) {
 *       print("foo");
 *     }
 *   }
 *
 *   public void bar() {
 *     for (int i = 0; i < n; i++) {
 *       print("bar");
 *     }
 *   }
 * }
 * 两个不同的线程将会共用一个 FooBar 实例。其中一个线程将会调用 foo() 方法，另一个线程将会调用 bar() 方法。
 *
 * 请设计修改程序，以确保 "foobar" 被输出 n 次。
 *
 * 示例 1:
 *
 * 输入: n = 1
 * 输出: "foobar"
 * 解释: 这里有两个线程被异步启动。其中一个调用 foo() 方法, 另一个调用 bar() 方法，"foobar" 将被输出一次。
 * 示例 2:
 *
 * 输入: n = 2
 * 输出: "foobarfoobar"
 * 解释: "foobar" 将被输出两次。
 *
 */
public class X_1115_交替打印FooBar {


    public static void main(String[] args) throws InterruptedException {
        FooBar fb = new FooBar(1);

        Runnable job1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("foo");
            }
        };

        Runnable job2 = new Runnable() {
            @Override
            public void run() {
                System.out.println("bar");
            }
        };

        fb.bar(job2);
        fb.foo(job1);
    }


}

class FooBar {
    private int n;

    private Semaphore foo = new Semaphore(1);
    private Semaphore bar = new Semaphore(0);

    public FooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            // printFoo.run() outputs "foo". Do not change or remove this line.
            foo.acquire();
            printFoo.run();
            bar.release();
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            // printBar.run() outputs "bar". Do not change or remove this line.
            bar.acquire();
            printBar.run();
            foo.release();
        }
    }


}