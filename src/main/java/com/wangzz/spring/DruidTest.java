package com.wangzz.spring;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

import java.sql.SQLException;

public class DruidTest {

    public static void main(String[] args) {
        try {
            ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-dao.xml");
            DruidDataSource dataSource = (DruidDataSource) context.getBean("dataSource");
            dataSource.init();
            Thread.currentThread().join();
        } catch (Exception throwables) {
            throwables.printStackTrace();
        }
    }

}
