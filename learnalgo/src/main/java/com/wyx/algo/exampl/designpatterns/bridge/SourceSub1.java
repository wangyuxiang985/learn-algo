package com.wyx.algo.exampl.designpatterns.bridge;

/**
 * @ClassName SourceSub1
 * @Description TODO
 * @Author yuxiang
 * @Date 2021/8/11
 * @Version 1.0
 **/
public class SourceSub1 implements Sourceable{
    @Override
    public void method() {
        System.out.println("this is SourceSub1 method()");
    }
}
