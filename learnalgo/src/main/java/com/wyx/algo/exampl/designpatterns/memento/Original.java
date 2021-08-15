package com.wyx.algo.exampl.designpatterns.memento;

/**
 * @ClassName Original
 * @Description Original类是原始类，里面有需要保存的属性value及创建一个备忘录类，用来保存value值
 * @Author yuxiang
 * @Date 2021/8/15
 * @Version 1.0
 **/
public class Original {
    private String value;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Original(String value) {
        this.value = value;
    }

    public Memento createMemento(){
        return new Memento(value);
    }

    //恢复原有值
    public void restoreMemento(Memento memento){
        this.value = memento.getValue();
    }
}
