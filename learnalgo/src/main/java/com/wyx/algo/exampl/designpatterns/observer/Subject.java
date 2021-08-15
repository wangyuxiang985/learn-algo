package com.wyx.algo.exampl.designpatterns.observer;

/**
 * @Author yuxiang
 * @Description //实现对观察者的增删改查及自身的操作
 * @Date 2021/8/15
 * @Param
 * @return
**/
public interface Subject {

    //新增观察者
    public void addObserver(Observer observer);
    //删除观察者
    public void removeObserver(Observer observer);
    //通知所有观察者
    public void notifyObserver();
    //自身具体方法
    public void operation();
}
