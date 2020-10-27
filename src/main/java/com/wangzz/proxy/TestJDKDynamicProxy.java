package com.wangzz.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author wangzz
 * @date
 */
public class TestJDKDynamicProxy {

    public static void main(String[] args) {
        Hello hello = (Hello)Proxy.newProxyInstance(Hello.class.getClassLoader(), new Class[]{Hello.class}, new HelloInvocationHandler(new MyHello()));
        int b = hello.sayHello();
        Arrays.stream(hello.getClass().getInterfaces()).forEach(System.out::println);
        System.out.println(b);
    }

    static interface Hello {
        int sayHello();
    }

    static class MyHello implements Hello {
        @Override
        public int sayHello() {
            System.out.println("MyHello say hello!");
            return 1;
        }
    }

    static class HelloInvocationHandler implements InvocationHandler {

        private Object target;

        public HelloInvocationHandler(Object target) {
            this.target = target;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            System.out.println("before hello");
            Object invoke = method.invoke(target, args);
            System.out.println("after hello");
            return invoke;
        }
    }

}
