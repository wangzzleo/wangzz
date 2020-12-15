package com.wangzz.designPatterns.filter;

public class ConcreteFilterB implements Filter<String,String> {

    private Filter<String,String> nextFilter;

    @Override
    public void setNext(Filter<String, String> filter) {
        nextFilter = filter;
    }

    @Override
    public String handle(String request) {
        System.out.println("ConcreteFilterB 处理中");
        if (nextFilter != null) {
            return nextFilter.handle(request);
        }
        return "ConcreteFilterB 处理完成";
    }
}
