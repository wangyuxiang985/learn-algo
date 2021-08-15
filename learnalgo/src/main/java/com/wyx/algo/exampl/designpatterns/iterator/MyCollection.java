package com.wyx.algo.exampl.designpatterns.iterator;

/**
 * @ClassName MyCollection
 * @Description 集合实现类
 * @Author yuxiang
 * @Date 2021/8/15
 * @Version 1.0
 **/
public class MyCollection implements Collection{

    public String[] str = {"A", "B", "C", "D", "E"};


    @Override
    public Iterator iterator() {
        return new MyIterator(this);
    }

    @Override
    public Object get(int index) {
        return str[index];
    }

    @Override
    public int size() {
        return str.length;
    }
}
