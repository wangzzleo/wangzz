package com.wangzz.optional;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import lombok.Data;

import java.util.*;
import java.util.concurrent.*;

public class TestOptional {

    public static void main(String[] args) {
        User user = new User();
        user.setId(1);
        user.setName("wangzz");
        user.setOrders(Arrays.asList("1","2"));
        Optional<User> userEmpty = Optional.empty();
        //Optional<User> userOfNull = Optional.of(null); NullPointerException
        Optional<User> userOf = Optional.of(user);
        Optional<User> userOfNullable = Optional.ofNullable(user);
        Optional<User> nullUser = Optional.ofNullable(null);
        //System.out.println(nullUser.isPresent());  false
        //System.out.println(userOfNullable.isPresent()); true

        //System.out.println(userEmpty.get());   java.util.NoSuchElementException: No value present
        //System.out.println(userOf.get());

        userOf.ifPresent(System.out::println);
        System.out.println(userOf.map(User::getOrders).orElse(Collections.emptyList()));
        System.out.println(userOf.map(User::getName).map(String::toUpperCase).orElse("123"));


        ThreadFactory threadFactory = new ThreadFactoryBuilder().setNameFormat("demo-pool-%d").build();
        ExecutorService service =  new ThreadPoolExecutor(10, 10, 1000, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>(), threadFactory);
        service.execute(System.out::println);


        //foreach
        //Random random = new Random(35);
        //random.ints().limit(10).forEach(i -> System.out.println(i*i));
        //random.ints(5).forEach(System.out::println);
    }

    @Data
    public static class User {

        private int id;
        private String name;
        private List<String> orders;



    }

}
