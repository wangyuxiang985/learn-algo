package com.wyx.algo.exampl.designpatterns.memento;

/**
 * @ClassName Memento
 * @Description 备忘录类 备份原始类属性
 * @Author yuxiang
 * @Date 2021/8/15
 * @Version 1.0
 **/
public class Memento {
    private String value;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Memento(String value) {
        this.value = value;
    }
}
