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

    Jedis jedis;

    @Before
    public void initJedis() {
        jedis = new Jedis("127.0.0.1");
    }

    @Before
    public void closeJedis() {
        jedis.close();
    }

    @Test
    public void pipLineTest() {
        Pipeline pipelined = jedis.pipelined();
        pipelined.multi();
        pipelined.set("a", "1");
        pipelined.set("b", "1");
        pipelined.exec();
        //pipelined.discard();
    }

    @Test
    public void testWatch() {
        String key = "aaa";
        jedis.watch(key);
        int value = Integer.parseInt(jedis.get(key));
        value = value + 1;
        jedis.set(key, "1111");
        Transaction tx = jedis.multi();
        tx.set(key, String.valueOf(value));
        List<Object> exec = tx.exec();
        Assert.assertNull("执行失败", exec);
    }

    @Test
    public void testPubSub() {
        List<String> aa = jedis.pubsubChannels("aa");

    }

    @Test
    public void jedisPoolTest() {
        JedisPool jedisPool = new JedisPool();
        Jedis resource = jedisPool.getResource();
        resource.set("a","a");
        resource.close();
    }

}
