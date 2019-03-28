package com.hy.demo.demo.java8.defualtinterface;

public interface TestDefaulterface1 {

    default void print(){
        System.out.println("this is test 1");
    }

    //接口中实现静态方法
    static void staticMethod(){
        System.out.println("this is a staticMethod");
    }
}
