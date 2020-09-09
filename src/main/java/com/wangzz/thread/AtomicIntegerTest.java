package com.wangzz.thread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicStampedReference;

public class AtomicIntegerTest {


    static AtomicInteger value = new AtomicInteger(0);

    static class IncreaseValue implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 10000000; i++) {
                value.incrementAndGet();
            }
        }
    }

    static class DecreaseValue implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 10000000; i++) {
                value.decrementAndGet();
            }
        }
    }

    /**
     * Code take from
     * https://programmer.help/blogs/do-you-know-cas-what-about-aba-of-atomic-integer.html
     */
    static AtomicReference<Integer> atomicReference = new AtomicReference<>(100);
    static AtomicStampedReference<Integer> atomicStampedReference = new AtomicStampedReference<>(100, 1);
    public static void main(String[] args) throws Exception {
        System.out.println("======ABA Problem arising======");

        new Thread(() -> {
            atomicReference.compareAndSet(100, 101);
            atomicReference.compareAndSet(101, 100);
        }, "t1").start();

        new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();

            }
            System.out.println(atomicReference.compareAndSet(100, 2019) + "\t" + atomicReference.get().toString());
        }, "t2").start();

        try { TimeUnit.SECONDS.sleep(2); } catch (InterruptedException e) { e.printStackTrace(); }

        System.out.println("======ABA Problem solving======");
        new Thread(() -> {
            int stamp = atomicStampedReference.getStamp();
            System.out.println(Thread.currentThread().getName() + "\t First edition number: " + stamp);
            try { TimeUnit.SECONDS.sleep(1); } catch (InterruptedException e) { e.printStackTrace(); }
            atomicStampedReference.compareAndSet(100,101,
                    atomicStampedReference.getStamp(),atomicStampedReference.getStamp()+1);
            System.out.println(Thread.currentThread().getName() + "\t Second edition number: " + atomicStampedReference.getStamp());
            atomicStampedReference.compareAndSet(101,100,
                    atomicStampedReference.getStamp(),atomicStampedReference.getStamp()+1);
            System.out.println(Thread.currentThread().getName() + "\t Third edition number: " + atomicStampedReference.getStamp());
        }, "t3").start();

        new Thread(() -> {
            int stamp = atomicStampedReference.getStamp();
            System.out.println(Thread.currentThread().getName() + "\t First edition number: " + stamp);
            try { TimeUnit.SECONDS.sleep(3); } catch (InterruptedException e) { e.printStackTrace(); }
            boolean result=atomicStampedReference.compareAndSet(100,2019,
                    stamp,stamp+1);
            System.out.println(Thread.currentThread().getName()+"\t Successful modification:"+result+"  Current latest version number"+atomicStampedReference.getStamp());
            System.out.println(Thread.currentThread().getName()+"\t Current actual value:"+atomicStampedReference.getReference());
        }, "t4").start();
    }

}
