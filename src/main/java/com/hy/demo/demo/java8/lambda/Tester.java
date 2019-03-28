package com.hy.demo.demo.java8.lambda;

public class Tester {

    public static void main(String[] args){
        Tester test = new Tester();
        //类型声明
        Add add1 = (int a,int b)->a+b;
        //不用类型声明
        Add add2 = (a,b)->a+b;
        //返回语句
        Add add3 =  (a,b)->{return a*b;};



    }
}

interface Add{
    int operation(int a,int b);
}
