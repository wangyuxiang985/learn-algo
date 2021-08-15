package com.wyx.algo.exampl.designpatterns.iterator;

import sun.jvmstat.perfdata.monitor.PerfStringConstantMonitor;

/**
 * @ClassName IteratorTest
 * @Description 迭代器模式测试类
 * @Author yuxiang
 * @Date 2021/8/15
 * @Version 1.0
 **/
public class IteratorTest {
    public static void main(String[] args) {
        Collection collection = new MyCollection();
        Iterator iterator = collection.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
