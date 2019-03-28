package com.hy.demo.demo.java8.functioninterface;

import java.awt.*;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * 函数式接口(FunctionalInterface)就是一个有且仅有一个抽象方法，但是可以有多个非抽象方法的接口。
 * 函数式接口可以被隐式转换为lambda表达式。
 * 函数式接口可以现有的函数友好地支持 lambda。
 *
 * JDK 1.8之前已有的函数式接口:
 * ·        java.lang.Runnable
 * ·        java.util.concurrent.Callable
 * ·        java.security.PrivilegedAction
 * ·        java.util.Comparator
 * ·        java.io.FileFilter
 * ·        java.nio.file.PathMatcher
 * ·        java.lang.reflect.InvocationHandler
 * ·        java.beans.PropertyChangeListener
 * ·        java.awt.event.ActionListener
 * ·        javax.swing.event.ChangeListener
 *
 * JDK 1.8 新增加的函数接口：
 *
 * ·        java.util.function
 *
 * java.util.function 它包含了很多类，用来支持 Java的函数式编程，该包中的函数式接口有：
 */
public class TestFunctionInterface {

    public static void main(String[] args){

        /**
         * Predicate<T>
         * 接受一个输入参数，返回一个布尔值结果。
         */
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);
        //输出所有数据
//      Predicate<Integer> predicate = n -> true;
//      handle(list,predicate);
        //同下写法
        handle(list,n->true);
        //输出所有偶数
        handle(list,n->n%2==0);
        //输出所有质数
        handle(list,n->n%2!=0);


    }

    public static void handle(List<Integer> list, Predicate<Integer> predicate){
        list.forEach(a->{if(predicate.test(a)){
            System.out.println(a);
        }});
    }
}



