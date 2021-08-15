package com.wyx.algo.exampl.designpatterns.strategy;

/**
 * @ClassName AbstractCalculator
 * @Description 抽象类 用于提供辅助功能的函数，通用型的工具类相当于
 * @Author yuxiang
 * @Date 2021/8/15
 * @Version 1.0
 **/
public abstract class AbstractCalculator {

    public int[] split(String exp,String opt){
        String array[] = exp.split(opt);
        int arrayInt[] = new int[2];
        arrayInt[0] = Integer.parseInt(array[0]);
        arrayInt[1] = Integer.parseInt(array[1]);
        return arrayInt;
    }
}
