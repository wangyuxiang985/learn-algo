package com.wyx.algo.exampl.designpatterns.interpreter;

/**
 * @ClassName Minus
 * @Description TODO
 * @Author yuxiang
 * @Date 2021/8/15
 * @Version 1.0
 **/
public class Minus implements Expression{
    @Override
    public int interpret(Context context) {
        return context.getNum1() - context.getNum2();
    }
}
