package com.wyx.algo.exampl.designpatterns.state;

/**
 * @ClassName StateTest
 * @Description 测试状态模式
 * @Author yuxiang
 * @Date 2021/8/15
 * @Version 1.0
 **/
public class StateTest {
    public static void main(String[] args) {
        State state = new State();

        Context context = new Context(state);
        //设置第一种状态
        state.setValue("state1");
        context.method();

        //设置第二种状态
        state.setValue("state2");
        context.method();

    }
}
