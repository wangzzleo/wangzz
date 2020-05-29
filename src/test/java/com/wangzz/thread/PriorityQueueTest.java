package com.wangzz.thread;

import org.junit.Test;

import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class PriorityQueueTest {
    @Test
    public void testPriority() {

        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 1, 0, TimeUnit.SECONDS, new PriorityBlockingQueue<>());
        for (int i = 1000; i > 0; i--) {
            threadPoolExecutor.execute(new MyWork(i));
        }
        try {
            threadPoolExecutor.awaitTermination(160, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    static class MyWork implements Comparable<MyWork>, Runnable {
        @Override
        public void run() {
            if (orderId == 1000) {
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("order is " + orderId);
        }

        public MyWork(int orderId) {
            this.orderId = orderId;
        }

        private int orderId;

        public int getOrderId() {
            return orderId;
        }

        public void setOrderId(int orderId) {
            this.orderId = orderId;
        }

        @Override
        public int compareTo(MyWork o) {
            return ( o.getOrderId() - this.getOrderId());
        }
    }

}
