package com.wyx.algo.exampl.queue;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 *@ClassName ReentrantLockDemo
 *@Description *题目：
 *  * 多线程之间按顺序调用，A->B->C三个线程启动，要求如下：
 *  * AA打印5次，BB打印10次，CC打印15次，循环10次
 *@Author yuxiang
 *@Date 2021/8/7
 *@Version 1.0
 **/
public class ReentrantLockDemo {
    public static void main(String[] args) {
        MyResoure myResoure = new MyResoure();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                myResoure.print5();
            }

        },"AA").start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                myResoure.print10();
            }

        },"BB").start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                myResoure.print15();
            }

        },"CC").start();
    }
}

//线程操作资源类
class MyResoure{
    //标志位 1：A线程，2：B线程，3：C线程
    private int num = 1;
    private ReentrantLock lock = new ReentrantLock();
    private Condition c1 = lock.newCondition();
    private Condition c2 = lock.newCondition();
    private Condition c3 = lock.newCondition();

    public void print5(){
        lock.lock();
        try {
            //判断 干活 通知
            while (num != 1){
                c1.await();
            }
            for (int i = 1; i <=5; i++) {
                System.out.println(Thread.currentThread().getName() + "\t" + i);
            }
            num = 2;
            c2.signal();

        }catch (Exception e){

        }finally{
            lock.unlock();
        }
    }

    public void print10(){
        lock.lock();
        try {
            //判断 干活 通知
            while (num != 2){
                c2.await();
            }
            for (int i = 1; i <=10; i++) {
                System.out.println(Thread.currentThread().getName() + "\t" + i);
            }
            num = 3;
            c3.signal();

        }catch (Exception e){

        }finally{
            lock.unlock();
        }
    }

    public void print15(){
        lock.lock();
        try {
            //判断 干活 通知
            while (num != 3){
                c3.await();
            }
            for (int i = 1; i <=15; i++) {
                System.out.println(Thread.currentThread().getName() + "\t" + i);
            }
            num = 1;
            c1.signal();

        }catch (Exception e){

        }finally{
            lock.unlock();
        }
    }



}
