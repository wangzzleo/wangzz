package com.wangzz.designPatterns.observer;

import java.util.ArrayList;
import java.util.List;

public class Publisher {

    List<Subscriber> subscribers = new ArrayList<>();

    public void subscribe(Subscriber subscriber) {
        subscribers.add(subscriber);
    }

    public void unSubscribe(Subscriber subscriber) {
        subscribers.remove(subscriber);
    }

    public void notifySubscribers(String param) {
        for (Subscriber subscriber : subscribers) {
            subscriber.update(param);
        }
    }

}
