package com.wangzz.thread;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@SuppressWarnings({"AlibabaThreadShouldSetName", "AlibabaUndefineMagicConstant", "AliControlFlowStatementWithoutBraces"})
public class ThreadPoolTest {

    public static void main(String[] args) {
        try {
            ThreadPoolExecutor threadPoolExecutor =  new ThreadPoolExecutor(10,10,2,
                    TimeUnit.SECONDS, new LinkedBlockingQueue<>(1));
            System.out.println("线程状态：" + threadPoolExecutor.toString());
            new Thread("dddd"){
                @Override
                public void run() {
                    testLock();
                }
            }.start();
            threadPoolExecutor.allowCoreThreadTimeOut(true);
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(100);
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
                threadPoolExecutor.execute(ThreadPoolTest::testLock);
            }
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
