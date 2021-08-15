package com.wyx.algo.exampl.designpatterns.adaptermode.objectadapter;

/**
 * @ClassName MethodAdapterTest
 * @Description 对象适配器模式测试类
 * @Author yuxiang
 * @Date 2021/8/9
 * @Version 1.0
 **/
public class ObjectAdapterTest {
    public static void main(String[] args) {
        Wrapper wrapper = new Wrapper(new Source());
        wrapper.method1();
        wrapper.method2();
    }
}
