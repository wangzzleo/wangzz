package com.wangzz.guava;

import com.google.common.util.concurrent.RateLimiter;

public class RateLimiterTest {

    public static RateLimiterTest rateLimiterTest = new RateLimiterTest();
    public static int count1;
    public static int count2 = 0;

    private RateLimiterTest() {
        count1++;
        count2++;
    }

    public static RateLimiterTest getInstance() {
        return rateLimiterTest;
    }

    public static void main(String[] args) {
        RateLimiterTest instance = RateLimiterTest.getInstance();
        System.out.println(instance.count1);
        System.out.println(instance.count1);

    }

}
