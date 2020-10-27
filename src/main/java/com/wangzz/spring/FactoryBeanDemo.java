package com.wangzz.spring;

import org.springframework.beans.factory.FactoryBean;

public class FactoryBeanDemo implements FactoryBean<DruidTest> {
    @Override
    public DruidTest getObject() throws Exception {
        return null;
    }

    @Override
    public Class<?> getObjectType() {
        return null;
    }
}
