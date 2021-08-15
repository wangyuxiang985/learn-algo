package com.wyx.algo.exampl.designpatterns.adaptermode.classadapter;

/**
 *@ClassName AdapterTest
 *@Description 测试类Targetable接口的实现类就具有了Source类的功能
 *@Author yuxiang
 *@Date 2021/8/9
 *@Version 1.0
 **/
public class AdapterTest {
    public static void main(String[] args) {
        Targetable targetable = new Adapter();
        targetable.method1();
        targetable.method2();
    }
}
