package com.wangzz.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author wangzz
 * @date
 */
public class TestJDKDynamicProxy {

    public static void main(String[] args) {
        Hello hello = (Hello)Proxy.newProxyInstance(Hello.class.getClassLoader(), new Class[]{Hello.class}, new HelloInvocationHandler(new MyHello()));
        hello.hashCode();
    }

    static interface Hello {
        void sayHello();
    }

    static class MyHello implements Hello {
        @Override
        public void sayHello() {
            System.out.println("MyHello say hello!");
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
