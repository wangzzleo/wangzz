package com.wangzz.thread;

public class VolatileTest {

    private static int i = 0;

    static class Calc implements Runnable{
        @Override
        public void run() {
            for (int j = 0; j < 10000; j++) {
                i++;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        Thread t1 = new Thread(new Reader());
        Thread t2 = new Thread(new Writer());
        t1.start();
        t2.start();
        Thread.currentThread().join();
    }

    public static void testEx() throws Exception {
        try {
            throw new RuntimeException("aaa");
        } finally {
            throw new NullPointerException("bbb");
        }
    }

    static class Reader implements Runnable {
        @Override
        public void run() {
            for (int j = 0; j < 100; j++) {
                System.out.print(i+" ");
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println();
        }
    }

    static class Writer implements Runnable{
        @Override
        public void run() {
            for (int j = 0; j < 100; j++) {
                i++;
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            try {
                Thread.currentThread().join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
