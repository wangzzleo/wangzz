package com.wangzz.thread;

public class DeadLockTest {


    static class Worker implements Runnable {

        private Object condition1;
        private Object condition2;

        public Worker(Object condition1, Object condition2) {
            this.condition1 = condition1;
            this.condition2 = condition2;
        }

        @Override
        public void run() {
            synchronized (condition1) {
                System.out.println(Thread.currentThread().getId() + " 正在执行condition1。。。");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (condition2) {
                    System.out.println(Thread.currentThread().getId() + " 正在执行condition2。。。");
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        Object condition1 = new Object();
        Object condition2 = new Object();
        Thread t1 = new Thread(new Worker(condition1, condition2));
        Thread t2 = new Thread(new Worker(condition2, condition1));
        t1.start();
        t2.start();
        t1.join();
        t2.join();
    }

}
