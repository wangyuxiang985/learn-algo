package com.wyx.algo.exampl.queue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 *@ClassName ProdConsumer_BlockingQueueDemo
 *@Description 基于队列的生产者消费之模式
 *@Author yuxiang
 *@Date 2021/8/7
 *@Version 1.0
 **/
public class ProdConsumer_BlockingQueueDemo {
    public static void main(String[] args) {
        MyData myData = new MyData(new ArrayBlockingQueue<>(10));

        new Thread(() -> {
            System.out.println("生产者线程启动");
            System.out.println();
            try {
                myData.myProd();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }, "t1").start();

        new Thread(() -> {
            System.out.println("消费线程启动");
            System.out.println();
            try {
                myData.myCust();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }, "t2").start();

        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println();
        System.out.println("5秒钟过去了，main线程终止了程序，flag = false");
        System.out.println();
        try {
            myData.stop();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

//线程操作资源类
class MyData{
    //标志位，标记是否工作
    private volatile boolean flag = true;
    //资源，产生动态数据
    private AtomicInteger atomicInteger = new AtomicInteger();
    //队列承装数据
    private BlockingQueue<String> blockingQueue = null;

    public MyData(BlockingQueue<String> blockingQueue){
        this.blockingQueue = blockingQueue;
    }

    public void myProd() throws Exception{
        String data;
        boolean offer;
        while (flag){
            //线程工作，产生数据往队列里塞
            data = atomicInteger.incrementAndGet() + "";
            offer = blockingQueue.offer(data, 2L, TimeUnit.SECONDS);
            if (offer) {
                System.out.println(Thread.currentThread().getName() + "\t插入队列：" + data + "成功");
            } else {
                System.out.println(Thread.currentThread().getName() + "\t插入队列：" + data + "失败");
            }
            TimeUnit.SECONDS.sleep(1);
        }
        System.out.println(Thread.currentThread().getName() + "\t 终止工作，" + flag);
    }

    public void myCust() throws Exception{
        String data;
        while (flag) {
            //消费线程工作
            data = blockingQueue.poll(2, TimeUnit.SECONDS);

            if (data == null || data.equalsIgnoreCase("")) {
                System.out.println(Thread.currentThread().getName() + "\t 获取数据失败");
                flag = false;
                return;
            }

            System.out.println(Thread.currentThread().getName() + "\t 获取数据成功:" + data);
        }
    }

    public void stop(){
        this.flag = false;
    }


}
