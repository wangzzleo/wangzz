package com.wangzz.designPatterns.filter;

public class ConcreteFilterA implements Filter<String,String> {

    private Filter<String,String> nextFilter;

    @Override
    public void setNext(Filter<String, String> filter) {

    }

    @Override
    public String handle(String request) {
        System.out.println("ConcreteFilter");
        return null;
    }
}
