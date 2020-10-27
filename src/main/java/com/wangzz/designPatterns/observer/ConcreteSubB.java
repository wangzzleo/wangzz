package com.wangzz.designPatterns.observer;

public class ConcreteSubB implements Subscriber {
    @Override
    public void update(String param) {
        System.out.println("ConcreteSubB 接受通知: " + param);
    }
}
