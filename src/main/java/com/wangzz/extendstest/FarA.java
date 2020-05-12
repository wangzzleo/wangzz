package com.wangzz.extendstest;

public interface FarA {

    default String sayHello() {
        return "Hello World in FarA!";
    }

}
