package com.wangzz.struct.set;


import java.util.Comparator;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author wangzz
 * @date
 */
public class WhatSortedSet implements Comparable<WhatSortedSet> {

    public WhatSortedSet(long createTime) {
        this.createTime = createTime;
    }

    public WhatSortedSet() {
        this.createTime = System.currentTimeMillis();
    }

    @Override
    public int compareTo(WhatSortedSet o) {
        return (int) (this.createTime - o.getCreateTime());
    }

    private long createTime;

    public long getCreateTime() {
        return createTime;
    }

    public static void main(String[] args) throws Exception {
        Comparator<WhatSortedSet> comparator = (o1, o2) -> (int)(o2.getCreateTime() - o1.getCreateTime());
        SortedSet<WhatSortedSet> sortedSets = new TreeSet<>(comparator);
        for (int i = 0; i < 20; i++) {
            Thread.sleep(100);
            sortedSets.add(new WhatSortedSet());
        }
        System.out.println(sortedSets);

    }

    @Override
    public int hashCode() {
        return (int) (createTime & Integer.MAX_VALUE);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        if (o instanceof  WhatSortedSet) {
            return ((WhatSortedSet) o).getCreateTime() == this.createTime;
        }
        return false;
    }

    @Override
    public String toString() {
        return createTime + "";
    }
}
