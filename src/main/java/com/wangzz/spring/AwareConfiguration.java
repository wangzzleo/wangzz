package com.wangzz.spring;

import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class AwareConfiguration {

    @Bean(initMethod = "init")
    public AwareTestBean bbb() {
        return new AwareTestBean();
    }

    @Bean
    public BeanPostProcessor aa() {
        return new BeanPostProcessorDemo();
    }

}
