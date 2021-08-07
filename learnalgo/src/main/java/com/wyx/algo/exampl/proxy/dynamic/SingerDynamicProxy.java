package com.wyx.algo.exampl.proxy.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 *@ClassName SingerDynamicProxy
 *@Description 动态代理
 *@Author yuxiang
 *@Date 2021/8/1
 *@Version 1.0
 **/
public class SingerDynamicProxy implements InvocationHandler {

    private Object obj;

    public SingerDynamicProxy(Object obj){
        this.obj = obj;
    }

    // 唱歌之前
    private void beforeSing(){
        System.out.println("动态-布置会场ing");
    }

    // 唱歌之后
    private void afterSing(){
        System.out.println("动态-清理会场ing");
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        beforeSing();

        Object invoke = method.invoke(obj, args);

        afterSing();

        return null;
    }
}
