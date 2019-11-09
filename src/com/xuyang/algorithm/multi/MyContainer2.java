package com.xuyang.algorithm.multi;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Auther: allanyang
 * @Date: 2019/11/9 15:02
 * @Description:
 */
public class MyContainer2 {

    private int count = 0;
    private List<Integer> list = new ArrayList<>();

    private Lock lock = new ReentrantLock();
    private Condition consumer = lock.newCondition();
    private Condition producer = lock.newCondition();

    public void put(Integer i) throws InterruptedException {
        try {
            lock.lock();

            while (list.size() == 10) {
                producer.await();
            }

            list.add(i);
            count++;
            consumer.signalAll();
        } finally {
            lock.unlock();
        }
    }

    public Integer get() throws InterruptedException {
        Integer res = null;
        try {
            lock.lock();

            while (list.size() == 0) {
                consumer.await();
            }

            res = list.get(0);
            count--;
            producer.signalAll();
        } finally {
            lock.unlock();
        }

        return res;
    }
}