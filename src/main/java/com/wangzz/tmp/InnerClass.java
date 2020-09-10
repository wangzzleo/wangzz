package com.wangzz.tmp;

public class InnerClass {

    public static void main(String[] args) {
        InnerParClass innerParClass = new InnerSubClass();
        innerParClass.b();
    }

    private int a;

    public static class InnerParClass {

        public void b() {
            a();
        }

        public void a() {
            System.out.println("InnerParClass a");
        }
    }

    public static class InnerSubClass extends InnerParClass {



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
