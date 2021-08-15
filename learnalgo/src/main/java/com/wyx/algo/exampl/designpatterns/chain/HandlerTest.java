package com.wyx.algo.exampl.designpatterns.chain;

/**
 * @ClassName HandlerTest
 * @Description 责任链模式，有多个对象，每个对象持有对下一个对象的引用，这样就会形成一条链，请求在这条链上传递，直到某一对象决定处理该请求。
 * 但是发出者并不清楚到底最终那个对象会处理该请求，所以，责任链模式可以实现，在隐瞒客户端的情况下，对系统进行动态的调整。
 * @Author yuxiang
 * @Date 2021/8/15
 * @Version 1.0
 **/
public class HandlerTest {
    public static void main(String[] args) {
        MyHandler handler1 = new MyHandler("t1");
        MyHandler handler2 = new MyHandler("t2");
        MyHandler handler3 = new MyHandler("t3");
        handler1.setHandler(handler2);
        handler2.setHandler(handler3);
        handler1.operator();
    }
}
