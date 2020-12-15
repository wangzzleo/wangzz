package com.wangzz.designPatterns.filter;

public class Client {

    public static void main(String[] args) {
        Filter<String,String> filter1 = new ConcreteFilter();
        Filter<String,String> filter2 = new ConcreteFilterA();
        Filter<String,String> filter3 = new ConcreteFilterB();
        filter1.setNext(filter2);
        filter2.setNext(filter3);


    }

}
