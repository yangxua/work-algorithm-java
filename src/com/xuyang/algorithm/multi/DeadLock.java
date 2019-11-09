package com.xuyang.algorithm.multi;

/**
 * @Auther: allanyang
 * @Date: 2019/9/10 10:48
 * @Description:
 */
public class DeadLock {

    private static final Object lock1 = new Object();
    private static final Object lock2 = new Object();
   // private static final CyclicBarrier barrier = new CyclicBarrier(2);

    public static void main(String[] args) {
        Runnable job1 = new Runnable() {
            @Override
            public void run() {
               /* try {
                    barrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }*/

                synchronized (lock1) {
                    try {
                        System.out.println("job1--lock1");
                        Thread.sleep(1000);
                        synchronized (lock2) {
                            System.out.println("job1--lock2");
                        }
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        };

        Runnable job2 = new Runnable() {
            @Override
            public void run() {
               /* try {
                    barrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }*/

                synchronized (lock2) {
                    System.out.println("job2--lock2");
                    try {
                        Thread.sleep(1000);
                        synchronized (lock1) {
                            System.out.println("job2-lock1");
                        }
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        };

        new Thread(job1).start();
        new Thread(job2).start();

    }
}