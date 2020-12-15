package com.wangzz.mybatisLearn.interceptor;

import com.wangzz.mybatisLearn.bean.Blog;
import com.wangzz.mybatisLearn.mapper.BlogMapper;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.*;

import java.util.Properties;

@Intercepts({@Signature(type = BlogMapper.class, method = "selectAllBlog", args = {})})
public class ExamplePlugin implements Interceptor {
    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        System.out.println("执行拦截器 intercept");
        return invocation.proceed();
    }

    @Override
    public Object plugin(Object target) {
        System.out.println("执行拦截器 plugin" );
        return Plugin.wrap(target,this);
    }

    @Override
    public void setProperties(Properties properties) {
        System.out.println("执行拦截器 setProperties");
    }
}
