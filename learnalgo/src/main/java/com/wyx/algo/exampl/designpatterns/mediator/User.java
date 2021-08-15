package com.wyx.algo.exampl.designpatterns.mediator;

/**
 * @ClassName User
 * @Description TODO
 * @Author yuxiang
 * @Date 2021/8/15
 * @Version 1.0
 **/
public abstract class User {
    private Mediator mediator;

    public Mediator getMediator() {
        return mediator;
    }

    protected User(Mediator mediator) {
        this.mediator = mediator;
    }

    public abstract void work();
}
