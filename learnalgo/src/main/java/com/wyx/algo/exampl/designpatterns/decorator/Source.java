package com.wyx.algo.exampl.designpatterns.decorator;

/**
 * @ClassName Source
 * @Description 被装饰类
 * @Author yuxiang
 * @Date 2021/8/10
 * @Version 1.0
 **/
public class Source implements Sourceable{
    @Override
    public void method() {
        System.out.println("this is Source method()");
    }
}
