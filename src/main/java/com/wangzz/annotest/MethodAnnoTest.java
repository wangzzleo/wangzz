package com.wangzz.annotest;

import java.lang.annotation.*;
import java.lang.reflect.Method;
import java.util.Arrays;

public class MethodAnnoTest {

    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.METHOD)
    @interface MethodAnno {
        String value();
    }

    interface SuperInterface {

        @MethodAnno("接口方法注解")
        int sMethod();

    }

    static class SubClass implements SuperInterface {
        @Override
        public int sMethod() {
            return 0;
        }
    }

    public static void main(String[] args) throws Exception {
//        SuperInterface s = new SubClass();
//        Method sMethod = s.getClass().getMethod("sMethod");
//        Annotation[] declaredAnnotations = sMethod.getDeclaredAnnotations();
//        System.out.println(Arrays.toString(declaredAnnotations));
        
    }

}
