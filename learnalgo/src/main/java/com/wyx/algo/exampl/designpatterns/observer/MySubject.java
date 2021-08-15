package com.wyx.algo.exampl.designpatterns.observer;

/**
 * @ClassName MySubject
 * @Description TODO
 * @Author yuxiang
 * @Date 2021/8/15
 * @Version 1.0
 **/
public class MySubject extends AbstractSubject{
    @Override
    public void operation() {
        System.out.println("MySubject operation()...");
        //通知所有观察者
        notifyObserver();
    }
}
