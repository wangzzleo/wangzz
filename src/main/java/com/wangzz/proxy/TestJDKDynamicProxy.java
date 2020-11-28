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
        Hello hello = (Hello)Proxy.newProxyInstance(Hello.class.getClassLoader(), new Class[]{Hello.class}, new HelloInvocationHandler());
        int b = hello.hashCode();
        Arrays.stream(hello.getClass().getInterfaces()).forEach(System.out::println);
        System.out.println(b);
    }

    interface Hello {
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
//
//        public HelloInvocationHandler(Object target) {
//            this.target = target;
//        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            System.out.println(proxy instanceof Hello);
            if (Object.class.equals(method.getDeclaringClass())) {
                return method.invoke(proxy, args);
            } else {
                System.out.println("正在执行：" + method.getName());
                return 1;
            }

//            System.out.println("before hello");
//
//            System.out.println("after hello");
        }
    }

}
