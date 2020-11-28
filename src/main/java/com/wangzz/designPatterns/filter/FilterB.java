package com.wangzz.designPatterns.filter;

public class FilterB implements Filter<String,String> {
    @Override
    public void setNext(Filter<String, String> filter) {

    }

    @Override
    public String handle(String request) {
        return null;
    }
}
