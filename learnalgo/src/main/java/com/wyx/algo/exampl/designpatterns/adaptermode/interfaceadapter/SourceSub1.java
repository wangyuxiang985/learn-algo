package com.wyx.algo.exampl.designpatterns.adaptermode.interfaceadapter;

/**
 * @ClassName SourceSub1
 * @Description 实现类1，继承抽象类，只实现部分方法
 * @Author yuxiang
 * @Date 2021/8/9
 * @Version 1.0
 **/
public class SourceSub1 extends Wrapper2{

    public void method1(){
        System.out.println("this is SourceSub1 method1()");
    }
}
