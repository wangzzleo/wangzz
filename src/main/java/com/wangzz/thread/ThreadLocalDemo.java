package com.wangzz.thread;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author wangzz
 * @date
 */
public class ThreadLocalDemo {

    private static ThreadLocal<Integer> threadLocal = new ThreadLocal<>();

    private static ThreadLocal<String> threadLocal2 = new ThreadLocal<>();

    public static void main(String[] args) {
        ExecutorService service = new ThreadPoolExecutor(10,10,0,TimeUnit.DAYS,new LinkedBlockingQueue<>());
        AtomicInteger integer = new AtomicInteger(1);
        for (int i = 0; i < 10; i++) {
            service.execute(() -> {
                setNum(integer.getAndIncrement());
//                setString(Thread.currentThread().getName());
                System.out.println(Thread.currentThread().getName() +" 取出 " + getNum());
//                System.out.println(Thread.currentThread().getName() +" 取出 " + getString());
            });
        }
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        threadLocal = null;
        System.gc();
//        System.out.println(Thread.currentThread().getName() +" 取出 " + getNum());
        service.execute(() -> {
//            setNum(integer.getAndIncrement());
//                setString(Thread.currentThread().getName());
            ThreadLocal<String> temp = new ThreadLocal<>();
            temp.get();
//                System.out.println(Thread.currentThread().getName() +" 取出 " + getString());
        });
    }

    private static void setNum(int num) {
        System.out.println(Thread.currentThread().getName() +" 设置为 " + num);
        threadLocal.set(num);
    }

    private static Integer getNum() {
        return threadLocal.get();
    }

    private static void setString(String num) {
        System.out.println(Thread.currentThread().getName() +" 设置为 " + num);
        threadLocal2.set(num);
    }

    private static String getString() {
        return threadLocal2.get();
    }

    public static class ThreadId {
        // Atomic integer containing the next thread ID to be assigned
        private static final AtomicInteger nextId = new AtomicInteger(0);

        // Thread local variable containing each thread's ID
        private static final ThreadLocal<Integer> threadId =
                ThreadLocal.withInitial(() -> nextId.getAndIncrement());

        // Returns the current thread's unique ID, assigning it if necessary
        public static int get() {
            return threadId.get();
        }
    }

}
