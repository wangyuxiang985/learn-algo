package com.wyx.algo.exampl.designpatterns.facade;

/**
 * @ClassName Computer
 * @Description TODO
 * @Author yuxiang
 * @Date 2021/8/11
 * @Version 1.0
 **/
public class Computer {
    private CPU cpu;
    private Memory memory;
    private Disk disk;
    public Computer(){
        this.cpu = new CPU();
        this.memory = new Memory();
        this.disk = new Disk();
    }

    public void startup(){
        System.out.println("computer startup...");
        cpu.startup();
        memory.startup();
        disk.startup();
        System.out.println("computer startup success...");
    }

    public void shutdown(){
        System.out.println("computer shutdown...");
        cpu.shutdown();
        memory.shutdown();
        disk.shutdown();
        System.out.println("computer shutdown sucess....");
    }
}
