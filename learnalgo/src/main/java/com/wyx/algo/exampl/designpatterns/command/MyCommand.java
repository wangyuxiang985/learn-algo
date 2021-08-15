package com.wyx.algo.exampl.designpatterns.command;

/**
 * @ClassName MyCommand
 * @Description 命令执行中间人
 * @Author yuxiang
 * @Date 2021/8/15
 * @Version 1.0
 **/
public class MyCommand implements Command {

    //持有具体执行命令人对象
    public Receiver receiver;

    public MyCommand(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void exec() {
        receiver.action();
    }
}
