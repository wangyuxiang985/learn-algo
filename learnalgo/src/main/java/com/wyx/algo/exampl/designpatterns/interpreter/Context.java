package com.wyx.algo.exampl.designpatterns.interpreter;

/**
 * @ClassName Context
 * @Description 上下文 持有基本的东西
 * @Author yuxiang
 * @Date 2021/8/15
 * @Version 1.0
 **/
public class Context {
    private int num1;
    private int num2;

    public int getNum1() {
        return num1;
    }

    public void setNum1(int num1) {
        this.num1 = num1;
    }

    public int getNum2() {
        return num2;
    }

    public void setNum2(int num2) {
        this.num2 = num2;
    }

    public Context(int num1, int num2) {
        this.num1 = num1;
        this.num2 = num2;
    }
}
