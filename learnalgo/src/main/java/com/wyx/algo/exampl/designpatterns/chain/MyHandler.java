package com.wyx.algo.exampl.designpatterns.chain;

/**
 * @ClassName MyHandler
 * @Description MyHandle类是核心，实例化后生成一系列相互持有的对象，构成一条链。
 * @Author yuxiang
 * @Date 2021/8/15
 * @Version 1.0
 **/
public class MyHandler extends AbstractHandler implements Handler {

    private String name;

    public MyHandler(String name) {
        this.name = name;
    }

    @Override
    public void operator() {
        System.out.println("MyHander operator()... \t" + name);
        if (getHandler() != null) {
            getHandler().operator();
        }
    }
}
