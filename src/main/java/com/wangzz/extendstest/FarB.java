package com.wangzz.extendstest;

public interface FarB {

    default String sayHello() {
        return "Hello World in FarB!";
    }

}
