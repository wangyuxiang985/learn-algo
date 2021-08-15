package com.wyx.algo.exampl.designpatterns.chain;

/**
 * @ClassName AbstractHandler
 * @Description Abstracthandler类提供了get和set方法，方便MyHandle类设置和修改引用对象，
 * MyHandle类是核心，实例化后生成一系列相互持有的对象，构成一条链。
 * @Author yuxiang
 * @Date 2021/8/15
 * @Version 1.0
 **/
public abstract class AbstractHandler {
    private Handler handler;

    public Handler getHandler() {
        return handler;
    }

    public void setHandler(Handler handler) {
        this.handler = handler;
    }
}
