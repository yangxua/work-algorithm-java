package com.xuyang.algorithm.multi;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Auther: allanyang
 * @Date: 2019/11/9 14:16
 * @Description:
 */
public class MyContainer1 {

    private volatile List<Integer> list = new ArrayList<>();
    private static Lock lock = new ReentrantLock();
    private static Condition finish = lock.newCondition();

    public void add(Integer i) {
        list.add(i);
    }

    public int size() {
        return list.size();
    }


    public static void main(String[] args)  {
        MyContainer1 list = new MyContainer1();


        Runnable job1 = new Runnable() {
            @Override
            public void run() {
                try {
                    lock.lock();
                    for (int i = 0;i < 10;i++) {
                        list.add(i);
                        System.out.println("add" + i);

                        if (i == 5) {
                            finish.signalAll();
                            try {
                                finish.await();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                } finally {
                    lock.unlock();
                }
            }
        };

        Runnable job2 = new Runnable() {
            @Override
            public void run() {
                try {
                    lock.lock();
                    if (list.size() != 5) {
                        try {
                            finish.await();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println("-------------");
                    finish.signalAll();
                } finally {
                    lock.unlock();
                }
            }
        };

        new Thread(job2).start();
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(job1).start();
    }
}