package com.wangzz.spring;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import java.util.stream.Stream;

public class AwareTestBean implements BeanFactoryAware, ApplicationContextAware, BeanNameAware , InitializingBean {
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("invoke afterPropertiesSet");
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("invoke setBeanName");
    }

    private ApplicationContext applicationContext;

    public AwareTestBean() {
        System.out.println();
    }

    public void init() {
        System.out.println("invoke init");
    }

    public void printBeanNames() {
        System.out.println(this.toString());
    }


    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("invoke setBeanFactory");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("invoke setApplicationContext");
        this.applicationContext = applicationContext;
    }

    @Override
    public String toString() {
        return "AwareTestBean toString 方法";
    }
}
