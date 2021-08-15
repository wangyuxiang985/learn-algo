package com.wyx.algo.exampl.designpatterns.mediator;

/**
 * @ClassName Mediator
 * @Description 中介者模式也是用来降低类类之间的耦合的，因为如果类类之间有依赖关系的话，不利于功能的拓展和维护，
 * 因为只要修改一个对象，其它关联的对象都得进行修改。如果使用中介者模式，只需关心和Mediator类的关系，具体类类之间的关系及调度交给Mediator就行
 * @Author yuxiang
 * @Date 2021/8/15
 * @Version 1.0
 **/
public interface Mediator {
    public void createMediator();

    public void workAll();
}
