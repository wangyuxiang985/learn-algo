package com.wyx.algo.exampl.designpatterns.observer;

import java.util.Enumeration;
import java.util.Vector;

/**
 * @ClassName AbstractSubject
 * @Description 接口的抽象，实现一些默认通用的方法
 * @Author yuxiang
 * @Date 2021/8/15
 * @Version 1.0
 **/
public abstract class AbstractSubject implements Subject{

    private Vector<Observer> observers = new Vector<>();
    //新增观察者
    @Override
    public void addObserver(Observer observer){
        observers.add(observer);
    }
    //删除观察者
    @Override
    public void removeObserver(Observer observer){
        observers.remove(observer);
    }
    //通知所有观察者
    @Override
    public void notifyObserver(){
        Enumeration<Observer> elements = observers.elements();
        while (elements.hasMoreElements()) {
            elements.nextElement().update();
        }
    }
}
