package com.wangzz.spring;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

public class TestSingleton {

    public static void main(String[] args) {
//        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");
//        SingletonClass singletonClass = (SingletonClass) context.getBean("singletonClass");
//        System.out.println(singletonClass.getPrototypeClass() == singletonClass.getPrototypeClass());
//        System.out.println(singletonClass.getPrototypeClass());
//        System.out.println(singletonClass.getPrototypeClass());

//        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
//        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(beanFactory);
//        xmlBeanDefinitionReader.loadBeanDefinitions(new ClassPathResource("spring-context.xml"));
//
//        SingletonClass singletonClass = (SingletonClass) beanFactory.getBean("singletonClass");
//        PrototypeClass prototypeClass = singletonClass.getPrototypeClass();
//        System.out.println(prototypeClass);
//        System.out.println(prototypeClass);
//        System.out.println(prototypeClass);
//        System.out.println(prototypeClass);
//        System.out.println(prototypeClass);
//        System.out.println(prototypeClass);
        //PrototypeClass prototypeClass1 = singletonClass.getPrototypeClass();
        //System.out.println(prototypeClass1);
        //System.out.println(prototypeClass == prototypeClass1);


        PrototypeClass prototypeClass = new PrototypeClass();
        System.out.println(prototypeClass);
        System.out.println(prototypeClass);
        System.out.println(prototypeClass);
        System.out.println(prototypeClass);
        System.out.println(prototypeClass);
    }

}
