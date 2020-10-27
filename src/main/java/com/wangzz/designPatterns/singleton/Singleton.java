package com.wangzz.designPatterns.singleton;

public class Singleton {

    private Singleton(){}

    private static class SingletonHolder {
        private static final Singleton INSTANCE = new Singleton();
    }

    public enum SingletonEnum {

        INSTANCE("wangzz", 18);

        private String name;
        private int age;
        SingletonEnum(String name, int age) {
            this.name = name;
            this.age = age;
        }

    }

    public static SingletonEnum getInstance() {
        return SingletonEnum.INSTANCE;
    }

    public static void main(String[] args) {
        System.out.println("singleton = " + getInstance().name);
    }

}
