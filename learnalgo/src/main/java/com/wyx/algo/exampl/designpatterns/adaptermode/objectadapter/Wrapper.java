package com.wyx.algo.exampl.designpatterns.adaptermode.objectadapter;

/**
 * @ClassName Wrapper
 * @Description 对象的适配器模式  不继承Source类，而是持有Source类的实例
 * @Author yuxiang
 * @Date 2021/8/9
 * @Version 1.0
 **/
public class Wrapper implements Targetable{

    private Source source;

    public Wrapper(Source source){
        this.source = source;
    }

    @Override
    public void method1() {
        //直接调用source
        source.method1();
    }

    @Override
    public void method2() {
        System.out.println("this Wrapper method2()");
    }
}
