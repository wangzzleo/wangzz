package com.wangzz.thread;

public class SynchronizedFairTest {

    static final Object LOCK = new Object();

    public static void main(String[] args) {
        for (int i = 0; i < 4; i++) {
            Thread thread = new Thread(new TestThread());
            thread.setName("Thread-"+i);
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            thread.start();
        }
        while (Thread.activeCount() > 1) {
            Thread.yield();
        }
    }

    static void printThread() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        synchronized (LOCK) {
            System.out.println(Thread.currentThread().getName() + " is running...");
        }
    }

    static class TestThread implements Runnable {
        @Override
        public void run() {
            printThread();
        }
    }

}
