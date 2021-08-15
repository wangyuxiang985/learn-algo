package com.wyx.algo.exampl.designpatterns.memento;

/**
 * @ClassName Storage
 * @Description Storage类是存储备忘录的类，持有Memento类的实例
 * @Author yuxiang
 * @Date 2021/8/15
 * @Version 1.0
 **/
public class Storage {
    private Memento memento;

    public Memento getMemento() {
        return memento;
    }

    public void setMemento(Memento memento) {
        this.memento = memento;
    }

    public Storage(Memento memento) {
        this.memento = memento;
    }
}
