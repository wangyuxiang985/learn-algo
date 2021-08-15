package com.wyx.algo.exampl.designpatterns.iterator;

/**
 * @ClassName Collection
 * @Description MyCollection中定义了集合的一些操作，MyIterator中定义了一系列迭代操作，且持有Collection实例
 * 定义集合的一些操作
 * @Author yuxiang
 * @Date 2021/8/15
 * @Version 1.0
 **/
public interface Collection {

    public Iterator iterator();

    // 获取集合元素
    public Object get(int index);

    //获取集合大小
    public int size();
}
