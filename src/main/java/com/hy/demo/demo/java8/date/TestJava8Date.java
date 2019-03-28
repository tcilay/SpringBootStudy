package com.hy.demo.demo.java8.date;

import java.time.*;

/**
 * 旧版日期api 有很多问题
 * 非线程安全 − java.util.Date 是非线程安全的，所有的日期类都是可变的，这是Java日期类最大的问题之一。
 * 设计很差 − Java的日期/时间类的定义并不一致，在java.util和java.sql的包中都有日期类，此外用于格式化和解析的类在java.text包中定义。java.util.Date同时包含日期和时间，而java.sql.Date仅包含日期，将其纳入java.sql包并不合理。另外这两个类都有相同的名字，这本身就是一个非常糟糕的设计。
 *时区处理麻烦 − 日期类并不提供国际化，没有时区支持，因此Java引入了java.util.Calendar和java.util.TimeZone类，但他们同样存在上述所有的问题。
 *
 *
 * Java 8 在 java.time 包下提供了很多新的 API。以下为两个比较重要的 API：
 * ·        Local(本地) − 简化了日期时间的处理，没有时区的问题。
 * ·        Zoned(时区) − 通过制定的时区处理日期时间。
 * 新的java.time包涵盖了所有处理日期，时间，日期/时间，时区，时刻（instants），过程（during）与时钟（clock）的操作。
 *
 *
 */
public class TestJava8Date {

    public static void main(String[] args) {
        testLocalDateTime();

        testZonedDateTime();
    }

    public static void testLocalDateTime(){
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);
        LocalDate localDate = now.toLocalDate();
        System.out.println(localDate);
        Month month = now.getMonth();
        int day = now.getDayOfMonth();
        int seconds = now.getSecond();
        System.out.println("月: " + month + ", 日: " + day + ", 秒: " + seconds);

        LocalDateTime date2 = now.withDayOfMonth(10).withYear(2012);
        System.out.println("data2: "+date2);

        LocalDate date3 = LocalDate.of(2014, Month.DECEMBER, 12);
        System.out.println("date3: " + date3);

        LocalTime date4 = LocalTime.of(22, 15);
        System.out.println("date4: " + date4);

        LocalTime date5 = LocalTime.parse("20:15:30");
        System.out.println("date5: " + date5);
    }

    //使用时区的API
    public static void testZonedDateTime(){
        // 获取当前时间日期
        ZonedDateTime time = ZonedDateTime.parse("2019-03-28T10:15:30+05:30[Asia/Shanghai]");
        System.out.println(time);
        ZoneId id = ZoneId.of("Europe/Paris");
        System.out.println(id);
        ZoneId systemDefault = ZoneId.systemDefault();
        System.out.println("当前时区："+systemDefault);
    }
}
