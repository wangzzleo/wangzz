package com.wangzz.ref;

import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.Arrays;

public class WeakRefDemo {

    public static void main(String[] args) {
        WeakRefObject weakRefObject = testWeakRef();
        System.out.println(weakRefObject.get());
        System.out.println(weakRefObject.get());
//        byte[] array = new byte[15*1024*1024];
        System.gc();
        System.out.println(weakRefObject.get());
    }

    static WeakRefObject testWeakRef() {
        return new WeakRefObject(new Object());
    }

    static SoftRefObject testSoftRef() {
        return new SoftRefObject(new BigObject());
    }

    static class BigObject {
        byte[] array = new byte[20*1024*1024];

        @Override
        public String toString() {
            return "BigObject{" +
                    "array size=" + array.length +
                    '}';
        }
    }

    static class SoftRefObject extends SoftReference<BigObject> {

        public SoftRefObject(BigObject o) {
            super(o);
        }
    }

    static class WeakRefObject extends WeakReference<Object> {

        public WeakRefObject(Object o) {
            super(o);
        }
    }

}
