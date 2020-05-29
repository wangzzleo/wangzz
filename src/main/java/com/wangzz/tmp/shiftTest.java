package com.wangzz.tmp;

public class shiftTest {

    public static void main(String[] args) {
        System.out.println(doShift(291));
        System.out.println(doShift(35));
    }

    public static long doShift(int shift) {
        return 4L<<shift;
    }

}
