package com.wangzz.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author wangzz
 * @date
 */
public class ThreadLocalDemo {

    private static ThreadLocal<Integer> threadLocal = new ThreadLocal<>();

    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(10);
//        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor();
        service.execute(() -> {

        });
    }

    private static void setNum() {
    }

}
