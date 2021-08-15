package com.wyx.algo.exampl.designpatterns.bridge;

/**
 * @ClassName MyBridge
 * @Description TODO
 * @Author yuxiang
 * @Date 2021/8/11
 * @Version 1.0
 **/
public class MyBridge extends Bridge{

    public void method(){
        getSource().method();
    }
}
