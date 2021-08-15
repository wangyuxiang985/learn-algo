package com.wyx.algo.exampl.designpatterns.observer;

/**
 * @ClassName Observer1
 * @Description 其中一个观察者
 * @Author yuxiang
 * @Date 2021/8/15
 * @Version 1.0
 **/
public class Observer2 implements Observer{
    @Override
    public void update() {
        System.out.println("Obserer2 update()");
    }
}
