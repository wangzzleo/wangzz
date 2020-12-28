package com.wangzz.hash;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * equals相等，hashcode一定相等；
 * equals不等，hashcode一定不等；
 * hashcode相等，equals不一定相等；
 * hashcode不等，equals一定不等；
 *
 * hashcode相等是equals相等的充分不必要条件。
 */
public class HashCodeDemo {


    public static void main(String[] args) {
        Thread thread = new Thread(new TestWorker());
        thread.start();
        try {
            Thread.sleep(100000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread.interrupt();
    }

    static class TestWorker implements Runnable {
        @Override
        public void run() {
            Set<Integer> hashcodes = new HashSet<>(2*1024*1024);
            int hashcode=0;
            while (!hashcodes.contains((hashcode = testGc()))) {
                System.out.println(hashcode);
                if (Thread.currentThread().isInterrupted()) {
                    System.out.println("地址未出现");
                    break;
                }
            }
            System.out.println("地址出现");
        }
    }

    private static boolean flag = true;

    private static int nextHashCode = 0;

    private final int hashCode = (flag = !flag) ? nextHashCode : ++nextHashCode;

    @Override
    public int hashCode() {
        return hashCode;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    public static int testGc() {
        return new Object().hashCode();
    }

}
