package com.wangzz.redis;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import redis.clients.jedis.*;
import redis.clients.jedis.params.SetParams;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class JedisTest {

    Jedis commJedis;

    ThreadLocal<Jedis> jedisLocal = ThreadLocal.withInitial(() -> {
        Jedis jedis = new Jedis();
//        jedis1.auth("aD9X4AAi");
        return jedis;
    });

    @Before
    public void initJedis() {
        commJedis = new Jedis();
//        commJedis.auth("aD9X4AAi");
    }

    @Before
    public void closeJedis() {
        commJedis.close();
    }

    @Test
    public void basicTest() {
        String basictest = commJedis.get("basictest");
        System.out.println(basictest);
    }

    @Test
    public void limitTest() throws InterruptedException {
        String userBase = "user_";
        long l = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            System.out.println(System.currentTimeMillis() - l);
            TimeUnit.MILLISECONDS.sleep(50);
            System.out.println(userBase+i%10 + ":" + isAllow(userBase+i%10));
        }
    }

    public boolean isAllow(String userId) {
        Jedis jedis = jedisLocal.get();
        jedis.set(userId, "0", SetParams.setParams().nx().ex(3));
        return jedis.incr(userId) < 4;
    }

    public boolean isActionAllowed(String userId, String actionKey, int period, int maxCount) {
        String key = String.format("hist:%s:%s", userId, actionKey);
        long nowTs = System.currentTimeMillis();
        Pipeline pipe = commJedis.pipelined();
        pipe.multi();
        pipe.zadd(key, nowTs, "" + nowTs);
        pipe.zremrangeByScore(key, 0, nowTs - period * 1000);
        Response<Long> count = pipe.zcard(key);
        pipe.expire(key, period + 1);
        pipe.exec();
        pipe.close();
        return count.get() <= maxCount;
    }

    @Test
    public void pipLineTest() {
        Pipeline pipelined = commJedis.pipelined();
        pipelined.multi();
        pipelined.set("a", "1");
        pipelined.set("b", "1");
        pipelined.exec();
        //pipelined.discard();
    }

    @Test
    public void testWatch() {
        String key = "aaa";
        commJedis.watch(key);
        int value = Integer.parseInt(commJedis.get(key));
        value = value + 1;
        commJedis.set(key, "1111");
        Transaction tx = commJedis.multi();
        tx.set(key, String.valueOf(value));
        List<Object> exec = tx.exec();
        Assert.assertNull("执行失败", exec);
    }

    @Test
    public void testPubSub() {
        List<String> aa = commJedis.pubsubChannels("aa");

    }

    @Test
    public void jedisPoolTest() {
        JedisPool jedisPool = new JedisPool();
        Jedis resource = jedisPool.getResource();
        resource.set("a","a");
        resource.close();
    }

}
