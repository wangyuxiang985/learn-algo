package com.wyx.algo.exampl.designpatterns.mediator;

/**
 * @ClassName MyMediator
 * @Description MyMediator实现类，里面持有User1和User2的实例，用来实现对User1和User2的控制
 * @Author yuxiang
 * @Date 2021/8/15
 * @Version 1.0
 **/
public class MyMediator implements Mediator {

    private User user1;

    public User getUser1() {
        return user1;
    }

    public User getUser2() {
        return user2;
    }

    private User user2;

    @Override
    public void createMediator() {
        user1 = new User1(this);
        user2 = new User2(this);
    }

    @Override
    public void workAll() {
        user1.work();
        user2.work();
    }
}
