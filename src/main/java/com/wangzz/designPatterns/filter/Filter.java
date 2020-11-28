package com.wangzz.designPatterns.filter;

public interface Filter<T,R> {
    void setNext(Filter<T,R> filter);
    R handle(T request);
}
