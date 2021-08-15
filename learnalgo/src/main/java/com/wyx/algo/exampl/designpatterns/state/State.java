package com.wyx.algo.exampl.designpatterns.state;

/**
 * @ClassName State
 * @Description 核心思想就是：当对象的状态改变时，同时改变其行为，很好理解！就拿QQ来说，有几种状态，在线、隐身、忙碌等，
 * 每个状态对应不同的操作，而且你的好友也能看到你的状态，所以，状态模式就两点：1、可以通过改变状态来获得不同的行为。2、你的好友能同时看到你的变化
 * @Author yuxiang
 * @Date 2021/8/15
 * @Version 1.0
 **/
public class State {
    private String value;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }


    public void method1(){
        System.out.println("state method1 ...");
    }

    public void method2(){
        System.out.println("state method2 !!!");
    }
}
