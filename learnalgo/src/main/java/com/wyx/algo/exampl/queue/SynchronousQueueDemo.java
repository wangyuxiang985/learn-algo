package com.wyx.algo.exampl.queue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

/**
 *@ClassName SynchronousQueueDemo
 *@Description TODO
 *@Author yuxiang
 *@Date 2021/8/7
 *@Version 1.0
 **/
public class SynchronousQueueDemo {
    public static void main(String[] args) {
        BlockingQueue<String> blockingQueue = new SynchronousQueue<>();

        new Thread(() -> {
            try {
                System.out.println(Thread.currentThread().getName() + "\t come in 1");
                blockingQueue.put("1");
                System.out.println(Thread.currentThread().getName() + "\t come in 2");
                blockingQueue.put("2");
                System.out.println(Thread.currentThread().getName() + "\t come in 3");
                blockingQueue.put("3");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        },"t1").start();

        new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(2);

                System.out.println(Thread.currentThread().getName() + "\t 取值：" + blockingQueue.take());

                TimeUnit.SECONDS.sleep(2);

                System.out.println(Thread.currentThread().getName() + "\t 取值：" + blockingQueue.take());

                TimeUnit.SECONDS.sleep(2);

                System.out.println(Thread.currentThread().getName() + "\t 取值：" + blockingQueue.take());


            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        },"t2").start();
    }
}
