package com.wyx.algo.exampl.designpatterns.adaptermode.objectadapter;

/**
 *@ClassName Source
 *@Description
 *核心思想就是：不继承Source类，而是持有Source类的实例，以达到解决兼容性的问题
 **/
public class Source {
    public void method1(){
        System.out.println("this is source method1()");
    }
}
