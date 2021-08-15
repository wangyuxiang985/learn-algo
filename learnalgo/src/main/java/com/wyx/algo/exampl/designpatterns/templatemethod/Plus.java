package com.wyx.algo.exampl.designpatterns.templatemethod;

/**
 * @ClassName Plus
 * @Description TODO
 * @Author yuxiang
 * @Date 2021/8/15
 * @Version 1.0
 **/
public class Plus extends AbstractCalculator{
    @Override
    public int calculate(int num1, int num2) {
        return num1 + num2;
    }
}
