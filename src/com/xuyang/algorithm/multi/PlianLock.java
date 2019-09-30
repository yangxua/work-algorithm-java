package com.xuyang.algorithm.multi;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;

/**
 * @Auther: allanyang
 * @Date: 2019/9/12 11:11
 * @Description:
 */
public class PlianLock {

    private static class Sync extends AbstractQueuedSynchronizer {

        @Override
        protected boolean tryAcquire(int arg) {
            return compareAndSetState(0, 1);
        }

        @Override
        protected boolean tryRelease(int arg) {
            setState(0);
            return true;
        }

        @Override
        protected boolean isHeldExclusively() {
            return getState() == 1;
        }
    }

    private Sync sync = new Sync();

    public void lock() {
        sync.tryAcquire(1);
    }

    public void unlock() {
        sync.tryRelease(1);
    }
}