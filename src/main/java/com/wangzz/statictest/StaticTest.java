package com.wangzz.statictest;

public class StaticTest {
    public static void main(String[] args) {
        System.out.println(a);
    }
    public static int a =2;
    static {
//        step(1);
        a = 1;
    }

//    public static int step_2 = step(2);
    static {
        step(3);
    }
    public int step_8 = step(8);
    public StaticTest(int unused) {
        super();
        step(10);
    }

    {
        step(9);
    }

    // Just for demonstration purposes:
    public static int step(int step) {
        System.out.println("Step " + step);
        return step;
    }

}
