package com.wyx.algo.exampl.designpatterns.decorator;

/**
 * @ClassName Decorator
 * @Description 装饰类，持有被装饰类对象 并实现公共接口
 * @Author yuxiang
 * @Date 2021/8/10
 * @Version 1.0
 **/
public class Decorator implements Sourceable{

    private Source source;

    public Decorator(Source source){
        this.source = source;
    }

    @Override
    public void method() {
        System.out.println("before Decorator \tmethod()");
        source.method();
        System.out.println("after Decorator \t method()");
    }
}
