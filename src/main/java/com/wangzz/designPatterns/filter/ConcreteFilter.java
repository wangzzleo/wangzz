package com.wangzz.designPatterns.filter;

public class ConcreteFilter implements Filter<String,String> {

    private Filter<String,String> nextFilter;

    @Override
    public void setNext(Filter<String, String> filter) {
        nextFilter = filter;
    }

    @Override
    public String handle(String request) {
        System.out.println("ConcreteFilter正在处理" + request);
        return null;
    }
}
