package com.wangzz.thread;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolTest {

    public static void main(String[] args) {
        try {
            ThreadPoolExecutor threadPoolExecutor =  new ThreadPoolExecutor(2,2,1, TimeUnit.SECONDS, new LinkedBlockingQueue<>(1)) {

                void onShutdown() {

                }

                @Override
                protected void terminated() {
                    super.terminated();
                    System.out.println("thread is " + Thread.currentThread().getName());
                    System.out.println("stats is " + this.toString());
                    System.out.println("execute the terminated...");
                }
            };
            threadPoolExecutor.allowCoreThreadTimeOut(true);
            System.out.println("线程状态：" + threadPoolExecutor.toString());
//            threadPoolExecutor.execute(() -> {
//                try {
//                    Thread.sleep(1000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                System.out.println("running first thread...");
//            });
//            threadPoolExecutor.execute(() -> {
//                try {
//                    Thread.sleep(1000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                System.out.println("running second thread...");
//            });
//            threadPoolExecutor.execute(() -> {
//                try {
//                    Thread.sleep(3000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                System.out.println("running third thread...");
//            });
//            System.out.println("线程状态：" + threadPoolExecutor.toString());
//            try {
//                threadPoolExecutor.execute(() -> {
//                    try {
//                        Thread.sleep(10000);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                    System.out.println("running fourth thread...");
//                });
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
            Thread.sleep(5000);
            System.out.println("线程状态：" + threadPoolExecutor.toString());
            threadPoolExecutor.shutdown();
            threadPoolExecutor.awaitTermination(10, TimeUnit.SECONDS);
            System.out.println("thread count "+ threadPoolExecutor.getPoolSize());
            System.out.println("线程状态：" + threadPoolExecutor.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
