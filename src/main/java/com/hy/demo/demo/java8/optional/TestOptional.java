package com.hy.demo.demo.java8.optional;

import java.util.Optional;

/**
 * Optional 类是一个可以为null的容器对象。
 * 如果值存在则isPresent()方法会返回true，调用get()方法会返回该对象。
 * Optional 是个容器：它可以保存类型T的值，或者仅仅保存null。
 * Optional提供很多有用的方法，这样我们就不用显式进行空值检测。
 *
 * static <T> Optional<T> empty()
 * 返回空的 Optional 实例。
 *
 * boolean equals(Object obj)
 * 判断其他对象是否等于 Optional。
 *
 * Optional<T> filter(Predicate<? super <T> predicate)
 * 如果值存在，并且这个值匹配给定的 predicate，返回一个Optional用以描述这个值，否则返回一个空的Option Optional。
 *
 * <U> Optional<U> flatMap(Function<? super T,Optional<U>> mapper)
 * 如果值存在，返回基于Optional包含的映射方法的值，否则返回一个空的Optional
 *
 * T get()
 * 如果在这个Optional中包含这个值，返回值，否则抛出异常：NoSuchElementException
 *
 * void ifPresent(Consumer<? super T> consumer)
 * 如果值存在则使用该值调用 consumer , 否则不做任何事情。
 *
 * boolean isPresent()
 * 如果值存在则方法会返回true，否则返回 false。
 *
 * <U>Optional<U> map(Function<? super T,? extends U> mapper)
 * 如果存在该值，提供的映射方法，如果返回非null，返回一个Optional描述结果。
 *
 * static <T> Optional<T> of(T value)
 * 返回一个指定非null值的Optional。
 *
 * static <T> Optional<T> ofNullable(T value)
 * 如果为非空，返回 Optional 描述的指定值，否则返回空的 Optional。
 *
 * T orElse(T other)
 * 如果存在该值，返回值，否则返回 other。
 *
 * T orElseGet(Supplier<? extends T> other)
 * 如果存在该值，返回值，否则触发 other，并返回 other 调用的结果。
 *
 * <X extends Throwable> T orElseThrow(Supplier<? extends X> exceptionSupplier)
 * 如果存在该值，返回包含的值，否则抛出由 Supplier 继承的异常
 *
 * String toString()
 * 返回一个Optional的非空字符串，用来调试
 */
public class TestOptional {

    public static void main(String[] args){
        TestOptional t = new TestOptional();
        Integer i1 = null;
        Integer i2 = 10;
        Optional<Integer> o1 = Optional.ofNullable(i1);//允许传递为 null 参数
        Optional<Integer> o2 = Optional.of(i2);//如果传递的参数是 null，抛出异常 NullPointerException
        System.out.println(t.sum(o1,o2));

    }

    public Integer sum(Optional<Integer> o1,Optional<Integer> o2){
        Integer i1 = o1.orElse(new Integer(0));//如果值存在，返回它，否则返回默认值
        Integer i2 = o2.get();// 获取值，值需要存在
        return i1+i2;
    }
}
