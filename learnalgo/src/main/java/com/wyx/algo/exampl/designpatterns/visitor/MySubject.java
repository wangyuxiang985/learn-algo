package com.wyx.algo.exampl.designpatterns.visitor;

/**
 * @ClassName MySubject
 * @Description TODO
 * @Author yuxiang
 * @Date 2021/8/15
 * @Version 1.0
 **/
public class MySubject implements Subject{

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    @Override
    public String getSubject() {
        return "love";
    }
}
