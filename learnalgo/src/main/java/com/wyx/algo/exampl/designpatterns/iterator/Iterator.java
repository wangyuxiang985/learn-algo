package com.wyx.algo.exampl.designpatterns.iterator;

/**
 * @Author yuxiang
 * @Description //定义迭代器的一些操作 前移/后移/是否有下一个元素/返回第一个元素
 * @Date 2021/8/15
 * @Param
 * @return
**/
public interface Iterator {

    //前移
    public Object previous();

    //后移
    public Object next();

    //是否有下一个元素
    public boolean hasNext();

    //返回第一个元素
    public Object first();

}
