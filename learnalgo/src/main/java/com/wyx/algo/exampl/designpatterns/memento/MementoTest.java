package com.wyx.algo.exampl.designpatterns.memento;

/**
 * @ClassName MementoTest
 * @Description 备忘录模式
 * @Author yuxiang
 * @Date 2021/8/15
 * @Version 1.0
 **/
public class MementoTest {
    public static void main(String[] args) {
        //创建原始类
        Original original = new Original("aaa");
        // 创建备忘录并存储
        Storage storage = new Storage(original.createMemento());
        // 修改原始类的状态
        System.out.println("初始化状态为：" + original.getValue());
        original.setValue("niu");
        System.out.println("修改后的状态为：" + original.getValue());

        // 回复原始类的状态
        original.restoreMemento(storage.getMemento());
        System.out.println("恢复后的状态为：" + original.getValue());
    }
}
