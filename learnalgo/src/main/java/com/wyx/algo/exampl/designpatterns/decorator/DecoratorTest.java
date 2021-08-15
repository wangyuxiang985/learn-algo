package com.wyx.algo.exampl.designpatterns.decorator;

/**
 * @ClassName DecoratorTest
 * @Description 测试类
 * @Author yuxiang
 * @Date 2021/8/10
 * @Version 1.0
 **/
public class DecoratorTest {
    public static void main(String[] args) {
        Sourceable sourceable = new Decorator(new Source());
        sourceable.method();
    }
}
