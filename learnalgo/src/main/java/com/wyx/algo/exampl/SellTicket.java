package com.wyx.algo.exampl;/**
 * SellTicket
 *
 * @author wyx
 * @date 2021/6/24 10:49 下午
 **/

/**
 *@ClassName SellTicket
 *@Description TODO
 *@Author yuxiang
 *@Date 2021/6/24
 *@Version 1.0
 **/
public class SellTicket implements Runnable{
    private volatile int num = 10000000;
    private Object o = new Object();

    public void run() {
        while (num > 0){
            sell();
        }
    }

    private void sell(){
        synchronized (o){
            if(num > 0) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "\t" + num);
                num--;
            }
        }
    }

    public static void main(String[] args) {
        SellTicket sellTicket = new SellTicket();
        new Thread(sellTicket,"窗口1").start();
        new Thread(sellTicket,"窗口2").start();
        new Thread(sellTicket,"窗口3").start();
        new Thread(sellTicket,"窗口4").start();
        new Thread(sellTicket,"窗口5").start();
    }
}
