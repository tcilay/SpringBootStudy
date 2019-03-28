package com.hy.demo.demo.java8.methodreference;

import io.lettuce.core.output.KeyValueStreamingChannel;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

/**
 * 方法引用通过方法的名字来指向一个方法。
 * 方法引用可以使语言的构造更紧凑简洁，减少冗余代码。
 * 方法引用使用一对冒号 :: 。
 *
 *
 *
 */
public class TestMethodReference {
    public static TestMethodReference create(Supplier<TestMethodReference> supplier){
        return supplier.get();
    }

    public static void method1(final TestMethodReference tmr){
        System.out.println("method1" + tmr.toString());
    }

    public void method2( TestMethodReference tmr){
        System.out.println("method2"+ tmr.toString());
    }

    public void method3(){
        System.out.println("method3"+this.toString());
    }

    public static void method4(String s){
        System.out.println("hello , "+s);
    }

    public void method5(String s){
        System.out.println("hello method , "+s);
    }
    public void method6(String s,int a){
        System.out.println("hello method , "+s+" , int is "+a);
    }

    public void method7(String s,String a){
        System.out.println("hello method , "+s+" , int is "+a);
    }



    public static void main(String[] args){
        //调用构造器
        TestMethodReference tmr = TestMethodReference.create(TestMethodReference::new);
        TestMethodReference tmr4 = new TestMethodReference();
        List<TestMethodReference> tmrList = Arrays.asList(tmr, tmr4);

        //静态方法调用
        tmrList.forEach(TestMethodReference::method1);
        //指定对象方法的引用
        final TestMethodReference trmInstance = TestMethodReference.create(TestMethodReference::new);
        tmrList.forEach(trmInstance::method2);

        //类对象任意方法的引用(只能匹配无参数方法)
        tmrList.forEach(TestMethodReference::method3);

        Consumer<String> consumer1 = (str)->System.out.println(str);
        consumer1.accept("this is test");

        Consumer<String> consumer2 = System.out::println;
        consumer2.accept("this is test 2");

        Consumer<String> consumer3 =  TestMethodReference::method4;
        consumer3.accept("zsb");
        TestMethodReference aNew = TestMethodReference.create(TestMethodReference::new);
        //调用一个参数的方法
        Consumer<String> consumer4 =  aNew::method5;
        consumer4.accept("aaa");

        //调用两个参数的方法
        BiConsumer<String, Integer> consumer5 = aNew::method6;
        consumer5.accept("bbbb",24);

    }
}

interface Supplier<T>{
    T get();
}
