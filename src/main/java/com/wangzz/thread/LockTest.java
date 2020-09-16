package com.wangzz.thread;

import java.util.concurrent.TimeUnit;

public class LockTest {

    public static class LockA {
        byte[] bytes = new byte[1024*1024];
        byte[] bytes2 = new byte[1024*1024];
    }

    public static LockA a = new LockA();

    static Object condition = new Object();

    public static void main(String[] args) throws InterruptedException {
        //实例化线程t1
        Thread t1 = new Thread(() -> {
            synchronized (a) {}
            System.out.println("enter others thread， then lock");
            //睡三秒好让主线程gc
            try {
//                TimeUnit.SECONDS.sleep(3);
                a.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        t1.start();
        TimeUnit.SECONDS.sleep(1);
        // 尝试回收锁对象
        a = null;
        System.gc();
        t1.join();
    }

}
