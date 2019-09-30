package com.xuyang.algorithm.multi;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;

/**
 * @Auther: allanyang
 * @Date: 2019/9/12 11:18
 * @Description:
 */
public class DoubleLock {

    private static class Sync extends AbstractQueuedSynchronizer {

        public Sync() {
            super();
            setState(2);
        }

        @Override
        protected int tryAcquireShared(int arg) {
            while (true) {
                int cur = getState();
                int next = cur - arg;
                if (compareAndSetState(cur, next)) {
                    return next;
                }
            }
        }

        @Override
        protected boolean tryReleaseShared(int arg) {
            while (true) {
                int cur = getState();
                int next = cur + arg;
                if (compareAndSetState(cur, next)) {
                    return true;
                }
            }
        }
    }


    private Sync sync = new Sync();

    public void lock() {
        sync.tryAcquireShared(1);
    }

    public void unlock() {
        sync.tryReleaseShared(1);
    }
}