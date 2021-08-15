package com.wyx.algo.exampl.designpatterns.adaptermode.interfaceadapter;

/**
 * @ClassName SourceSub1
 * @Description 实现类2，继承抽象类，只实现部分方法
 * @Author yuxiang
 * @Date 2021/8/9
 * @Version 1.0
 **/
public class SourceSub2 extends Wrapper2{

    public void method2(){
        System.out.println("this is SourceSub2 method2()");
    }
}
