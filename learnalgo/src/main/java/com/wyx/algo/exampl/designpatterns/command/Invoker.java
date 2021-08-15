package com.wyx.algo.exampl.designpatterns.command;

/**
 * @ClassName Invoker
 * @Description 命令发出者 持有中间人对象
 * @Author yuxiang
 * @Date 2021/8/15
 * @Version 1.0
 **/
public class Invoker {
    private Command command;

    public Invoker(Command command) {
        this.command = command;
    }

    public void action(){
        command.exec();
    }
}
