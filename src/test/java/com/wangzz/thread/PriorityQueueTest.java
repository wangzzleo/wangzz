package com.wangzz.thread;

import org.junit.Test;

import java.util.concurrent.*;

public class PriorityQueueTest {
    @Test
    public void testPriority() {
        BlockingQueue<Runnable> objects = new PriorityBlockingQueue<>();
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 10, 0, TimeUnit.SECONDS, objects);
        for (int i = 20; i > 0; i--) {
            threadPoolExecutor.execute(new MyWork(i));
        }
        System.out.println(objects.size());
        try {
            threadPoolExecutor.awaitTermination(160, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    static class MyWork implements Comparable<MyWork>, Runnable {
        @Override
        public void run() {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
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
