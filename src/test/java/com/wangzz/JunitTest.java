package com.wangzz;

import com.wangzz.proxy.TestCglibDynamicProxy;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import org.junit.Test;
import sun.misc.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.URL;
import java.net.URLConnection;

public class JunitTest {

    @Test
    public void test() {
        try {
            Enhancer enhancer = new Enhancer();
            enhancer.setSuperclass(URL.class);
            enhancer.setCallback(new HttpProxy());
            URL url = (URL)enhancer.create(new Class[]{String.class}, new Object[]{"https://www.baidu.com"});
            URLConnection urlConnection = url.openConnection();
            InputStream inputStream = urlConnection.getInputStream();
            byte[] bytes = IOUtils.readFully(inputStream, -1, false);
            System.out.println(new String(bytes));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static class HttpProxy implements MethodInterceptor {
        @Override
        public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
            Object rst;
            if ("openConnection".equals(method.getName())) {
                long t0 = System.nanoTime();
                rst = proxy.invokeSuper(obj, args);
                long time = System.nanoTime() - t0;
                System.out.printf("耗时：%d ms", time/1000);
            } else {
                rst = method.invoke(obj, args);
            }
            return rst;
        }

    }

}
