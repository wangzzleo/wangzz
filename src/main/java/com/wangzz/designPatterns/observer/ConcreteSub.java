package com.wangzz.designPatterns.observer;

public class ConcreteSub implements Subscriber {
    @Override
    public void update(String param) {
        System.out.println("ConcreteSub 接受通知: " + param);
    }
}
