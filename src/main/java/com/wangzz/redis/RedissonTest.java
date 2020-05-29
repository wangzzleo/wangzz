package com.wangzz.redis;

import org.redisson.Redisson;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;

import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class RedissonTest {

    private static String DATABASE_CONFIG_FILE = "/temp.properties";
    private static Properties properties = null;

    public static void main(String[] args) {
        Config config = new Config();
        config.useSingleServer().setAddress(getvalue("redis.host"))
                .setPassword(getvalue("redis.password"));
        RedissonClient redisson = Redisson.create(config);
        RLock wangzztets = redisson.getLock("wangzztets");
//        Thread t1 = new Thread() {
//            @Override
//            public void run() {
//                wangzztets.lock();
//                System.out.println(Thread.currentThread() + "t1获得锁，开始执行");
//                try {
//                    Thread.sleep(10000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                System.out.println(Thread.currentThread() + "t1获得锁，执行完成");
//                wangzztets.unlock();
//            }
//        };
//        t1.start();
//        try {
//            Thread.sleep(500);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        Thread t2 = new Thread() {
            @Override
            public void run() {
                try {
                    if (wangzztets.tryLock()) {
                        System.out.println(Thread.currentThread() + "t2获得锁，开始执行");
                        Thread.sleep(300000);
                        System.out.println(Thread.currentThread() + "t2获得锁，执行完成");
                        wangzztets.unlock();
                    } else {
                        System.out.println(Thread.currentThread() + "t2未获得锁");
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        };
        t2.start();
        try {
            Thread.sleep(1000000000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    static {
        properties = new Properties();
        InputStream in = null;
        try {
            in = Class.forName("com.wangzz.redis.RedissonTest").getResourceAsStream(DATABASE_CONFIG_FILE);
            properties.load(in);
        } catch (Exception e) {
            System.err
                    .println("Error reading conf properties in AccountPertiesUtils.loadProps() "
                            + e);
            e.printStackTrace();
        } finally {
            try {
                in.close();
            } catch (Exception e) {
            }
        }
    }

    public static String getvalue(String name) {
        return properties.getProperty(name);
    }

}
