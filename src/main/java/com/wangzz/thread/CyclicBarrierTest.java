package com.wangzz.thread;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierTest extends Thread{

    private CyclicBarrier cyclicBarrier;

    public CyclicBarrierTest(CyclicBarrier cyclicBarrier) {
        this.cyclicBarrier = cyclicBarrier;
    }

    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(10, () -> {
            System.out.println("exec end!");
        });
        Thread[] threads = new CyclicBarrierTest[10];
        for (int i = 0;i<10;i++) {
            threads[i] = new CyclicBarrierTest(cyclicBarrier);
            threads[i].start();
        }

    }

    @Override
    public void run() {
        super.run();
        long id = Thread.currentThread().getId();
        System.out.println(id + " exec CyclicBarrierTest");
        try {
            System.out.println(id + " exec CyclicBarrierTest, arriving is " + cyclicBarrier.await());
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}
