package com.hy.demo.demo.java8.stream;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Random;
import java.util.function.Consumer;
import java.util.stream.Collectors;

/**
 * Java 8 API添加了一个新的抽象称为流Stream，可以让你以一种声明的方式处理数据。
 * Stream API可以极大提高Java程序员的生产力，让程序员写出高效率、干净、简洁的代码。
 * Stream（流）是一个来自数据源的元素队列并支持聚合操作
 * 元素：是特定类型的对象，形成一个队列。Java中的Stream并不会存储元素，而是按需计算。
 * 数据源 ：流的来源。可以是集合，数组，I/O channel，产生器generator等。
 * 聚合操作： 类似SQL语句一样的操作，比如filter, map, reduce, find,match, sorted等。
 * 和以前的Collection操作不同，Stream操作还有两个基础的特征：
 * Pipelining:：中间操作都会返回流对象本身。这样多个操作可以串联成一个管道，如同流式风格（fluent style）。这样做可以对操作进行优化，比如延迟执行(laziness)和短路( short-circuiting)。
 * 内部迭代：以前对集合遍历都是通过Iterator或者For-Each的方式,显式的在集合外部进行迭代，这叫做外部迭代。Stream提供了内部迭代的方式，通过访问者模式(Visitor)实现。
 *
 * stream() −为集合创建串行流。
 * parallelStream() − 为集合创建并行流。
 */
public class TestStream {

    public static void main(String[] args){

        //输出五个随机数
        Random random = new Random();
        random.ints().limit(5).forEach(System.out::println);

        // 获取对应的平方数
        List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
        numbers.stream().map(i -> i * i).distinct().collect(Collectors.toList()).forEach(System.out::println);

        // 获取空字符串的数量
        List<String>strings = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl");
        int count = (int) strings.stream().filter(string -> string.isEmpty()).count();
        print(count);

        //随机输出10个排序
        random.ints().limit(10).sorted().forEach(System.out::println);

        //流并行处理
        int count1 = (int) strings.parallelStream().filter(string -> string.isEmpty()).count();
        print(count1);

        //Collectors 类实现了很多归约操作，例如将流转换成集合和聚合元素
        List<String> filtered = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.toList());
        System.out.println("筛选列表: " + filtered);
        String mergedString = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.joining(", "));
        System.out.println("合并字符串: " + mergedString);

        //统计
        IntSummaryStatistics stats = numbers.stream().mapToInt((x) -> x).summaryStatistics();
        System.out.println("列表中最大的数 : " + stats.getMax());
        System.out.println("列表中最小的数 : " + stats.getMin());
        System.out.println("所有数之和 : " + stats.getSum());
        System.out.println("平均数 : " + stats.getAverage());

    }

    public static <T> void print(T t){
        System.out.println(t);
    }

}
