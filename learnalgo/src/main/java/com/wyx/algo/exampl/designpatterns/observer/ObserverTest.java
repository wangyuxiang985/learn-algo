package com.wyx.algo.exampl.designpatterns.observer;

/**
 * @ClassName ObserverTest
 * @Description MySubject类就是我们的主对象，Observer1和Observer2是依赖于MySubject的对象，
 * 当MySubject变化时，Observer1和Observer2必然变化。AbstractSubject类中定义着需要监控的对象列表，
 * 可以对其进行修改：增加或删除被监控对象，且当MySubject变化时，负责通知在列表内存在的对象。
 * @Author yuxiang
 * @Date 2021/8/15
 * @Version 1.0
 **/
public class ObserverTest {
    public static void main(String[] args) {
        Subject subject = new MySubject();
        Observer observer1 = new Observer1();
        subject.addObserver(observer1);
        subject.operation();
        System.out.println("再添加一个订阅者");
        subject.addObserver(new Observer2());
        subject.operation();
        System.out.println("移除第一个订阅者");
        subject.removeObserver(observer1);
        subject.operation();
    }
}
