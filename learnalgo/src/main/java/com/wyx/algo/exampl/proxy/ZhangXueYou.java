package com.wyx.algo.exampl.proxy;

/**
 *@ClassName ZhangXueYou
 *@Description TODO
 *@Author yuxiang
 *@Date 2021/8/1
 *@Version 1.0
 **/
public class ZhangXueYou implements Singer{
    @Override
    public void sing() {
        System.out.println("张学友开始演唱：《祝福》");
    }
}
