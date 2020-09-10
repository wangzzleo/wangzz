package com.wangzz.thread;

public class LockTest {

    //定义类A
    public static class A{
        int i = 3;
    }
    //等会要实验的静态引用a


private static A b = null;

    public static A a = new A();
    public static void main(String[] args) throws InterruptedException {
        synchronized (b) {

        }
        //实例化线程t1
        Thread t1 = new Thread(new TestRun(a));
        t1.start();
        //为了先让t1进如synchronized，所以让主线程睡1s
        Thread.sleep(1000);
        //手动调用full gc 回收a
        a=null;
        //System.gc();
        System.out.println("set a = null and do a full GC");
        //等待线程t1结束
        t1.join();
        System.out.println("finish");
    }

    public void testA(A a1) {
        a1 = null;
    }

    public void testB() {
        a = null;
    }

    static class TestRun implements Runnable {

        private A a;

        public TestRun(A a) {
            this.a =  a;
        }

        @Override
        public void run() {
            System.out.println("enter1");
            //睡三秒好让主线程gc
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("show a value");
            //因为a已经被垃圾回收，看看是否报错
            System.out.println(a.i);
            System.out.println("leave1");
        }
    }

}
