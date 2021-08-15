package com.wyx.algo.exampl.designpatterns.state;

/**
 * @ClassName Context
 * @Description 状态模式的切换类
 * @Author yuxiang
 * @Date 2021/8/15
 * @Version 1.0
 **/
public class Context {


    private State state;

    public Context(State state) {
        this.state = state;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public void method(){
        if ("state1".equals(state.getValue())) {
            state.method1();
        } else if ("state2".equals(state.getValue())) {
            state.method2();
        } else {
            System.out.println("error.......");
        }
    }
}
