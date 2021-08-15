package com.wyx.algo.exampl.designpatterns.mediator;

/**
 * @ClassName User1
 * @Description TODO
 * @Author yuxiang
 * @Date 2021/8/15
 * @Version 1.0
 **/
public class User1 extends User{


    protected User1(Mediator mediator) {
        super(mediator);
    }

    @Override
    public void work() {
        System.out.println("User1 work()...");
    }
}
