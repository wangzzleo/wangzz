package com.wangzz.thread;

import java.sql.Connection;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class WaitTest {

    private static Lock lock = new ReentrantLock();
    private static Condition condition = lock.newCondition();
    private static volatile int flag = 0;

    public static void main(String[] args) {
        Thread a = new Thread(() -> {
            System.out.println("线程1执行任务中...");
            lock.lock();
            try {
                System.out.println("线程1正在等待线程2的结果...");
                condition.await();
                System.out.println("线程1继续执行");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        });

        Thread b = new Thread(() -> {
            System.out.println("线程2执行任务中...");
            lock.lock();
            try {
                TimeUnit.SECONDS.sleep(3);
                condition.signalAll();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
            System.out.println("线程2执行完成...");
        });
        a.start();
        b.start();
        try {
            a.join();
            b.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
