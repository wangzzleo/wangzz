package com.wangzz.time;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author wangzz
 * @date
 */
public class TimeTest {

    public static void main(String[] args) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime a1 = LocalDateTime.parse("2019-07-01 10:45:52", dateTimeFormatter);
        LocalDateTime a2 = LocalDateTime.parse("2019-07-01 10:45:56", dateTimeFormatter);
        LocalDateTime b = LocalDateTime.parse("2019-06-30 22:40:53", dateTimeFormatter);
        Duration between1 = Duration.between(a1, b);
        Duration between2 = Duration.between(a2, b);
        System.out.println(-between1.toMillis()/1000);
        System.out.println(-between2.toMillis()/1000);
    }

}
