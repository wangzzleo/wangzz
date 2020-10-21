package com.wangzz.redis;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.Pipeline;
import redis.clients.jedis.Transaction;

import java.util.List;

public class JedisTest {

    Jedis commJedis;

    ThreadLocal<Jedis> jedisLocal = ThreadLocal.withInitial(() -> {
        Jedis jedis1 = new Jedis("192.168.100.129");
        jedis1.auth("aD9X4AAi");
        return jedis1;
    });

    @Before
    public void initJedis() {
        commJedis = new Jedis("192.168.100.129");
        commJedis.auth("aD9X4AAi");
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
    public void limitTest() {
        String userBase = "user_";
        for (int i = 0; i < 10; i++) {

        }
    }

    public boolean isAllow(String userId) {
        Jedis jedis = jedisLocal.get();
        jedis.setnx(userId, "0");
        return jedis.incr(userId) < 4;
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
