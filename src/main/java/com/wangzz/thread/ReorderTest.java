package com.wangzz.thread;

public class ReorderTest {

    public static void main(String[] args) {
        for (int i=0;i<100;i++) {
            Calc calc = new Calc();
            Thread t1 = new Thread(new Writer(calc));
            Thread t2 = new Thread(new Reader(calc));
            t1.start();
            t2.start();
        }
    }

    static class Calc {
        static int count = 0;
        int a = 0;
        int b = 0;
        int c = 0;
        int d = 0;
        int e = 0;
        int f = 0;
        int g = 0;
        boolean flag = false;

        public void writ() {
            a = 1;
            b = 1;
            c = 1;
            d = 1;
            e = 1;
            f = 1;
            g = 1;
            int a = 0x8888 * 0x5bd2;
            int b = 0x8888 * 0x5bd2;
            int c = 0x8888 * 0x5bd2;
            int d = 0x8888 * 0x5bd2;
            int e = 0x8888 * 0x5bd2;
            int f = 0x8888 * 0x5bd2;
            int g = 0x8888 * 0x5bd2;
            flag = true;
        }

        public void read() {
            if (flag) {
                System.out.println(++count);
                try {
                    int b1 = 100/a;
                    int b2 = 100/b;
                    int b3 = 100/c;
                    int b4 = 100/d;
                    int b5 = 100/e;
                    int b6 = 100/f;
                    int b7 = 100/g;
                } catch (Exception e) {
                    System.out.println("发生重排序");
                }
            }
        }
    }

    static class Writer implements Runnable {

        private Calc calc;

        public Writer(Calc calc) {
            this.calc = calc;
        }

        @Override
        public void run() {
            calc.writ();
        }
    }

    static class Reader implements Runnable {

        private Calc calc;

        public Reader(Calc calc) {
            this.calc = calc;
        }

        @Override
        public void run() {
            calc.read();
        }
    }

}
