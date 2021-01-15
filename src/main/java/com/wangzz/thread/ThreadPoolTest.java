package com.wangzz.thread;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

@SuppressWarnings({"AlibabaThreadShouldSetName", "AlibabaUndefineMagicConstant", "AliControlFlowStatementWithoutBraces"})
public class ThreadPoolTest {

    public static void main(String[] args) {
        try {
            ThreadPoolExecutor threadPoolExecutor =  new ThreadPoolExecutor(10,12,2,
                    TimeUnit.SECONDS, new LinkedBlockingQueue<>(10)) {

            };
            AtomicInteger atomicInteger = new AtomicInteger(1);
            for (int i = 0; i < 5; i++) {
                threadPoolExecutor.execute(() -> {
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(atomicInteger.getAndIncrement());
                });
            }
            threadPoolExecutor.shutdownNow();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            threadPoolExecutor.execute(() -> {
                System.out.println("执行shutdown之后添加");
            });
            System.out.println(threadPoolExecutor.awaitTermination(1, TimeUnit.SECONDS));
            System.out.println(threadPoolExecutor.isTerminated());
            System.out.println(threadPoolExecutor.isTerminating());
            System.out.println(threadPoolExecutor.isShutdown());

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void testLock() {
        System.out.println(Thread.currentThread().getName() + " : 准备进入锁...");
        synchronized (ThreadPoolTest.class) {
            try {
                if ("dddd".equals(Thread.currentThread().getName())) Thread.sleep(5000);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " : 正在执行同步块代码...");
        }
    }

}
