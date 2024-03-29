package com.wyx.algo.exampl.designpatterns.iterator;

/**
 * @ClassName MyIterator
 * @Description 迭代器的实现,创建迭代器时传入一个集合类
 * @Author yuxiang
 * @Date 2021/8/15
 * @Version 1.0
 **/
public class MyIterator implements Iterator{

    private Collection collection;
    //操作指针
    private int pos = -1;

    public MyIterator(Collection collection){
        this.collection = collection;
    }

    @Override
    public Object previous() {
        if (pos > 0) {
            pos--;
        }
        return collection.get(pos);
    }

    @Override
    public Object next() {
        if (pos < collection.size() - 1) {
            pos++;
        }
        return collection.get(pos);
    }

    @Override
    public boolean hasNext() {
        return pos < collection.size() - 1;
    }

    @Override
    public Object first() {
        pos = 0;
        return collection.get(pos);
    }
}
