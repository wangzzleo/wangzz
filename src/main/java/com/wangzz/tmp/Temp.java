package com.wangzz.tmp;

import com.alibaba.fastjson.JSON;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

public class Temp {

    public static void main(String[] args) {
//        InnerClass innerClass = new InnerClass();
//        InnerClass.InnerSubClass innerSubClass = innerClass.new InnerSubClass();
//        new InnerClass.InnerStaticSubClass();
//        System.out.println("aaa");
//
//        loop:
//        while (true) {
//            System.out.println("bbb");
//
//            while (true) {
//                System.out.println("ccc");
//                continue loop;
//            }
//        }
       // System.out.println("ddd");
        int a = 1;
        {
            a = 2;
        }
        testStack();
    }

    private static void testStack() {
        testStack();
        List<String> list = new ArrayList<>(2);
        list.add("a");
        list.add("b");
        list.add("b");
    }

}
