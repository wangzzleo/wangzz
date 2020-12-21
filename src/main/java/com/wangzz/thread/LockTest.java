package com.wangzz.thread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockTest {

    public static class LockA {
        byte[] bytes = new byte[1024*1024];
        byte[] bytes2 = new byte[1024*1024];
    }

    public static Lock a = new ReentrantLock();

    static Object condition = new Object();

    public static void main(String[] args) throws InterruptedException {
        //实例化线程t1
        Thread t1 = new Thread(() -> {
            try {
                Thread.sleep(100);
                System.out.println("wait for lock");
                a.lockInterruptibly();
                System.out.println("running in lock");
                a.unlock();
                System.out.println("lock sucess");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        });
        t1.start();
        a.lock();
        try {
            Thread.sleep(1000);
            t1.interrupt();
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        a.unlock();
    }

}
