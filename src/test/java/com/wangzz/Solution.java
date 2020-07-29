package com.wangzz;

import org.junit.Test;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Queue;

public class Solution {

    @Test
    public void testFib() {
        for (int i=0;i<100;i++) {
            System.out.println(fib(i));
        }
    }

    /**
     * 1 1 2 3 5 8 13
     * @param n
     * @return
     */
    int fib(int n) {
        int a = 1;
        int b = 1;
        int value = 1;
        for (int i = 3; i <= n; i++) {
            value = a + b;
            a = b;
            b = value;
        }
        return value;
    }

    public int fib2(int N) {
        if (N <= 1) {
            return N;
        }
        return memoize(N);
    }

    public int memoize(int N) {
        int[] cache = new int[N + 1];
        cache[1] = 1;

        for (int i = 2; i <= N; i++) {
            cache[i] = cache[i-1] + cache[i-2];
        }
        return cache[N];
    }


    public static class LRUCache<K, V> extends LinkedHashMap<K,V> {
        private final int MAX_CACHE_SIZE;

        public LRUCache(int cacheSize) {
            super((int) Math.ceil(cacheSize / 0.75) + 1, 0.75f, true);
            MAX_CACHE_SIZE = cacheSize;
        }
        @Override
        protected boolean removeEldestEntry(Map.Entry eldest) {
            return size() > MAX_CACHE_SIZE;
        }

    }

}
