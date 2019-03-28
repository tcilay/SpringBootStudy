package com.hy.demo.demo.java8.nashorn;

import jdk.nashorn.internal.runtime.ECMAException;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import java.math.BigDecimal;

/**
 * Nashorn 一个 javascript 引擎。
 * jjs是个基于Nashorn引擎的命令行工具。它接受一些JavaScript源代码为参数，并且执行这些源代码。
 * Java 中调用 JavaScript
 */
public class TestNashorn {


    public static void main(String[] args) {
        ScriptEngineManager scriptEngineManager = new ScriptEngineManager();
        ScriptEngine nashorn = scriptEngineManager.getEngineByName("nashorn");

        String name = "java 8 nashorn";
        Integer i = null;
        try {
            nashorn.eval("print('"+name+"')");
             i = (Integer) nashorn.eval("10+2");
        }catch (Exception e){
            System.out.println("输出脚本错误"+e.getMessage());
        }
        System.out.println(i);
    }
}
