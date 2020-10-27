package com.wangzz.designPatterns.observer;

public class Client {
    public static void main(String[] args) {
        Publisher publisher = new Publisher();
        // 订阅
        publisher.subscribe(new ConcreteSub());
        publisher.subscribe(new ConcreteSubB());
        // 通知
        publisher.notifySubscribers("通知");
    }
}
