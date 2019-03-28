package com.hy.demo.demo.java8.lambda;

/**
 * Lambda 表达式主要用来定义行内执行的方法类型接口
 * Lambda 表达式免去了使用匿名方法的麻烦
 * 使用Lambda 表达式可以使代码变的更加简洁紧凑。
 * lambda 表达式只能引用标记了 final 的外层局部变量，lambda 内部修改定义在域外的局部变量
 * lambda 表达式的局部变量可以不用声明为 final，但是必须不可被后面的代码修改（即隐性的具有final 的语义）
 *
 * 原理：
 * 在类编译时，会生成一个私有静态方法+一个内部类；
 * 在内部类中实现了函数式接口，在实现接口的方法中，会调用编译器生成的静态方法；
 * 在使用lambda表达式的地方，通过传递内部类实例，来调用函数式接口方法。
 *
 * 线程安全的
 *
 */
public class LambdaTest {

    public static void main(String[] arg){
        PrintString("test",(x)->System.out.println(x));
    }

    public static void PrintString(String s,Print<String> print){
        print.print(s);
    }

}
/**
 * 可以推断出最终执行代码如下
 */
//public class LambdaTest {
//    public static void PrintString(String s, Print<String> print) {
//        print.print(s);
//    }
//
//    public static void main(String[] args) {
//        PrintString("test", new LambdaTest$$Lambda$1());
//    }
//
//    private static void lambda$main$0(String x) {
//        System.out.println(x);
//    }
//
//    static final class LambdaTest$$Lambda$1 implements Print {
//        public void print(Object obj) {
//            LambdaTest.lambda$main$0((String) obj);
//        }
//        private LambdaTest$$Lambda$1() {
//        }
//    }
//
//}
