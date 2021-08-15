package com.wyx.algo.exampl.designpatterns.visitor;

/**
 * @ClassName MyVisitor
 * @Description TODO
 * @Author yuxiang
 * @Date 2021/8/15
 * @Version 1.0
 **/
public class MyVisitor implements Visitor {

    @Override
    public void visit(Subject subject) {
        System.out.println("MyVistor visit... \t" + subject.getSubject());
    }
}
