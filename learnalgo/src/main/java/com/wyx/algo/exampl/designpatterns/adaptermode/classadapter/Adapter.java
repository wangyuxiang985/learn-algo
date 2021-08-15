package com.wyx.algo.exampl.designpatterns.adaptermode.classadapter;

/**
 *@ClassName Adapter
 *@Description Adapter类继承Source类，实现Targetable接口
 *@Author yuxiang
 *@Date 2021/8/9
 *@Version 1.0
 **/
public class Adapter extends Source implements Targetable{
    @Override
    public void method2() {
        System.out.println("this is Adapter method2()");
    }
}
