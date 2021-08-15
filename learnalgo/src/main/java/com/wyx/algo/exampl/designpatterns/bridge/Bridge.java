package com.wyx.algo.exampl.designpatterns.bridge;

/**
 * @ClassName Bridge
 * @Description 定义一个桥，持有Sourceable的一个实例
 * @Author yuxiang
 * @Date 2021/8/11
 * @Version 1.0
 **/
public abstract class Bridge {
    private Sourceable sourceable;

    public void method(){
        sourceable.method();
    }

    public Sourceable getSource() {
        return sourceable;
    }

    public void setSource(Sourceable sourceable) {
        this.sourceable = sourceable;
    }

}
