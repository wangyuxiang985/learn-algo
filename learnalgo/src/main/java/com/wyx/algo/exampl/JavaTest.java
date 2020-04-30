package com.wyx.algo.exampl;

/**
 * @ClassName JavaTest
 * @Description java坑题
 * @Author yuxiang
 * @Date 2020/4/30
 * @Version 1.0
 **/
public class JavaTest {
    public static void main(String[] args) {
//        test1();
//        test2();
//        test3();
//        test4();
//        f(null); //编译出错1）精确匹配->2）基本数据类型（自动转换成更大范围）->3）封装类（自动拆箱与装箱）->4）子类向上转型依次匹配->5）可变参数匹配。
//        子类向上转型，两者的父类都是object类（null默认类型是object），因而会同时匹配上两者，编译器会报Ambiguous method call. Both错误
//        g(1);//1）精确匹配->2）基本数据类型（自动转换成更大范围）->3）封装类（自动拆箱与装箱）->4）子类向上转型依次匹配->5）可变参数匹配，本题是进行到第二步匹配上了。


    }



    private static void g(double d) {
        System.out.println("double:" + d);
    }
    private static void g(Integer i) {
        System.out.println("integer:" + i);
    }

    private static void f(String s) {
        System.out.println("String," + s);
    }
    private static void f(Integer s) {
        System.out.println("Integer," + s);
    }

    private static void test4() {
        //Double包装类下，public static final double NaN = 0.0d / 0.0；NAN表示非数字，它与任何值都不相等，甚至不等于它自己。
        System.out.println(0.0 / 0.0); //NaN
    }

    private static void test3() {
        //在整型运算中，除数是不能为0的，否则直接运行异常。但是在浮点数运算中，引入了无限这个概念。
        // 可以看一下源码Double的定义, public static final double POSITIVE_INFINITY = 1.0 / 0.0；
        System.out.println(1.0 / 0); // Infinity
    }

    private static void test2() {
        //类似十进制里面的分数1/3，就是无限循环数，无法精确表示出来，同理浮点数里有些数值也没法精确表示出来。
        double c = 0.8;
        double d = 0.7;
        double e = 0.6;
        System.out.println(c-d);
        System.out.println(d-e);
        System.out.println((c - d) == (d - e)); //false
    }

    private static void test1() {
        //浮点数是由符号位、指数位、有效数字三个部分组成，而0.125f、0.125d均可以精确的表示出来，不存在精度丢失，因而a-b==0.0。
        float a = 0.125f;
        double b = 0.125d;
        System.out.println(a-b);
        System.out.println((a - b) == 0.0); //true
    }
}
