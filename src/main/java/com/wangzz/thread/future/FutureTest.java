package com.wangzz.thread.future;


import com.wangzz.http.HttpClientDemo;
import io.netty.util.concurrent.DefaultThreadFactory;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.concurrent.*;

public class FutureTest {

    public static void main(String[] args) throws InterruptedException {
        ThreadPoolExecutor threadPoolExecutor =
                new ThreadPoolExecutor(2, 2, 2, TimeUnit.SECONDS, new SynchronousQueue<>(), new DefaultThreadFactory("Future-task-"));
//        threadPoolExecutor.allowCoreThreadTimeOut(true);
//        Future future = threadPoolExecutor.submit(() -> {
//            System.out.println(Thread.currentThread().getName() + "正在执行..");
//            try {
//                sayHi("wangzz");
//            } catch (Throwable throwable) {
//                throwable.printStackTrace();
//            }
//        });
//        System.out.println(threadPoolExecutor.getPoolSize());
//        // 异常测试
//        try {
//            Object o = future.get(1, TimeUnit.SECONDS);
//        } catch (TimeoutException e) {
//            future.cancel(true);
//        } catch (ExecutionException e) {
//            e.printStackTrace();
//        }


        for (int i=0;i<6;i++) {
            try {
                Future f = threadPoolExecutor.submit(() -> {
                    System.out.println(Thread.currentThread().getName() + "正在执行..");
                    throw new RuntimeException("yichang");
                });
                Object o = f.get();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
//        Thread.sleep(500);
//        System.out.println(threadPoolExecutor.getPoolSize());

    }


    private static void sayHi(String name) throws RuntimeException {
        String printStr = "【thread-name:" + Thread.currentThread().getName() + ",执行方式:" + name + "】";
        System.out.println(printStr);
        throw new RuntimeException(printStr + ",我异常啦!哈哈哈!");
    }
}
