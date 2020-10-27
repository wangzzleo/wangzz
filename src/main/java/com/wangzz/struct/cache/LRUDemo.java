package com.wangzz.struct.cache;

import java.util.LinkedList;
import java.util.Queue;

public class LRUDemo implements Cache {

    private Queue<Integer> cache = new LinkedList<>();

    private int capacity;

    public LRUDemo(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public int get(int key) {
        return 0;
    }

    @Override
    public void put(int key, int value) {

    }
}
