package com.wyx.algo.exampl.designpatterns.adaptermode.classadapter;

/**
 *@ClassName Source
 *@Description 类的适配器模式
 *核心思想就是：有一个Source类，拥有一个方法，待适配，目标接口是Targetable，通过Adapter类，将Source的功能扩展到Targetable里
 **/
public class Source {
    public void method1(){
        System.out.println("this is source method1()");
    }
}
