package com.hy.demo.demo.java8.defualtinterface;

import sun.applet.Main;

/**
 * 当类中实现多个含有默认方法接口的时候
 *  1.重写默认方法
 *  2.或者指定调用哪个接口的默认方法TestDefaulterface1.super.print();
 */
public class TestClass implements TestDefaulterface1,TestDefaulterface2{
//    @Override
//    public void print() {
//        System.out.println("this is override method for interface");
//    }

    public static void main(String[] args){
        new TestClass().print();
    }

    @Override
    public void print() {
        TestDefaulterface1.super.print();
        TestDefaulterface1.staticMethod();
        TestDefaulterface2.super.print();
        System.out.println("this is a class ");
    }
}
