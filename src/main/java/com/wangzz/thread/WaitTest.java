package com.wangzz.thread;

import java.sql.Connection;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class WaitTest {

    private static Lock lock = new ReentrantLock();
    private static Condition condition = lock.newCondition();
    private static volatile int flag = 0;

    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger(1);
        Thread a = new Thread(() -> {
            synMethod(atomicInteger.getAndIncrement());
        });

        Thread b = new Thread(() -> {
            synMethod(atomicInteger.getAndIncrement());
        });
        Thread c = new Thread(() -> {
            synMethod(atomicInteger.getAndIncrement());
        });

    }

    public static synchronized void synMethod(int id) {
        System.out.println("线程"+id+"执行任务中...");
    }

}
