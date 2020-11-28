package com.wangzz.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author wangzz
 * @date
 */
public class ThreadLocalDemo {

    private static ThreadLocal<Integer> threadLocal = new ThreadLocal<>();

    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(10);
        AtomicInteger integer = new AtomicInteger(0);
        for (int i = 0; i < 10; i++) {
            service.execute(() -> {
                setNum(integer.getAndIncrement());
                try {
                    TimeUnit.MILLISECONDS.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() +" 取出 " + getNum());
            });
        }
        System.gc();
    }

    private static void setNum(int num) {
        System.out.println(Thread.currentThread().getName() +" 设置为 " + num);
        threadLocal.set(num);
    }

    private static int getNum() {
        return threadLocal.get();
    }

}
