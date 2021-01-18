package com.wangzz.struct.heap;

public class HeapDemo {

    public static final double a = 0.0d/0.0;

    public static void main(String[] args) {
//        HeapDemo heapDemo = new HeapDemo();
//        int left = heapDemo.left(heapDemo.indexOf(0));
//        System.out.println(a == a);
        System.out.println(Double.longBitsToDouble(0x7ff8000000000000L));
    }

    int[] arr = new int[16];

    public int indexOf(int origin) {
        return origin + 1;
    }

    public int left(int index) {
        return index<<1;
    }

    public int right(int index) {
        return index<<1 + 1;
    }

}
