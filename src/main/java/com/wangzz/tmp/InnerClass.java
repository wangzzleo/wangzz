package com.wangzz.tmp;

public class InnerClass {

    public static void main(String[] args) {
        new InnerSubClass();
    }

    private int a;

    public static class InnerParClass {

        private int fa;

        public void b() {
            a();
        }

        static {
            System.out.println("父类静态代码块");
        }

        {
            fa = 1;
            System.out.println("父类普通代码块");
        }

        public InnerParClass() {
            System.out.println("父类构造器");
        }

        public void a() {
            System.out.println("InnerParClass a");
        }
    }

    public static class InnerSubClass extends InnerParClass {

        public InnerSubClass() {
            System.out.println("子类构造器");
        }

        {
            System.out.println("子类普通代码块");
        }

        static {
            System.out.println("子类静态代码块");
        }

        private int b;
        @Override
        public void a() {
            System.out.println("InnerSubClass a");
        }
    }

    public static class InnerStaticSubClass {
        private int b;
    }

}
