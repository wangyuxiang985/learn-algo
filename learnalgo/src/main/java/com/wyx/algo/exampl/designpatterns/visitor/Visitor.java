package com.wyx.algo.exampl.designpatterns.visitor;

/**
 * @ClassName Visitor
 * @Description 访问者模式就是一种分离对象数据结构与行为的方法，通过这种分离，可达到为一个被访问者动态添加新的操作而无需做其它的修改的效果。
 * 一个Visitor类，存放要访问的对象
 * @Author yuxiang
 * @Date 2021/8/15
 * @Version 1.0
 **/
public interface Visitor {
    public void visit(Subject subject);
}
