package com.wangzz.redis;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.redisson.Redisson;
import org.redisson.api.RBucket;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.redisson.client.codec.StringCodec;
import org.redisson.config.Config;

import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class RedissonTest {

    private static String DATABASE_CONFIG_FILE = "/temp.properties";
    private static Properties properties;
    RedissonClient redisson;

    @Before
    public void before() {
//        properties = new Properties();
//        InputStream in = null;
//        try {
//            in = Class.forName("com.wangzz.redis.RedissonTest").getResourceAsStream(DATABASE_CONFIG_FILE);
//            properties.load(in);
//        } catch (Exception e) {
//            System.err
//                    .println("Error reading conf properties in AccountPertiesUtils.loadProps() "
//                            + e);
//            e.printStackTrace();
//        } finally {
//            try {
//                in.close();
//            } catch (Exception e) {
//            }
//        }
        Config config = new Config();
        config.useSingleServer().setAddress("redis://localhost:6379");
        redisson = Redisson.create(config);
    }

    @After
    public void after() {
        redisson.shutdown();
    }

    @Test
    public void testBucket() {
        RLock testlock = redisson.getLock("testlock");
        testlock.lock();
        try {
            Thread.sleep(15000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        testlock.unlock();
    }

    @Test
    public void testDel() {
        boolean name_test = redisson.getBucket("name_test").delete();

    }

    @Test
    public void testSetNX() {
        boolean name_test = redisson.<String> getBucket("name_test", new StringCodec()).trySet("wangzz");
        System.out.println(name_test);
    }

    @Test
    public void testGetSet() {
        String name_test = redisson.<String> getBucket("name_test", new StringCodec()).getAndSet("wangzz");
        System.out.println(name_test);
    }

    @Test
    public void testTryLock() throws Exception {
        RLock wangzz_test = redisson.getLock("wangzz_test");
        if (wangzz_test.tryLock(0, 1, TimeUnit.SECONDS)) {
            System.out.println("加锁成功");
            try {
                Thread.sleep(2500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                wangzz_test.unlock();
                System.out.println("解锁了");
            }
        }


    }

}
