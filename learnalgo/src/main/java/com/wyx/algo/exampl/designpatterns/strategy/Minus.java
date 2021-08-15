package com.wyx.algo.exampl.designpatterns.strategy;

/**
 * @ClassName Minus
 * @Description TODO
 * @Author yuxiang
 * @Date 2021/8/15
 * @Version 1.0
 **/
public class Minus extends AbstractCalculator implements ICalculator{
    @Override
    public int calculate(String exp) {
        int arrayInt[] = split(exp,"-");
        return arrayInt[0]-arrayInt[1];
    }
}
