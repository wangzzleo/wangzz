package com.wangzz.jvm;

import com.wangzz.mybatisLearn.TestSqlSession;

public class ClassLoaderTest extends ClassLoader {
    @Override
    public Class<?> loadClass(String name) throws ClassNotFoundException {
        return super.loadClass(name);
    }

    public static void main(String[] args) {
        System.out.println(SubClass.c);
    }

    static class SuperClass {
        public static int a = 12;

        static {
            System.out.println("SuperClass init!");
        }
    }

    static class SubClass extends SuperClass {

        public static int b = 12;
        public static final int c = 123;
        static {
            System.out.println("SubClass init!");
        }
    }

    static interface Inter1 {
        int a = 1;
    }

}
