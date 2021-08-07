package com.wyx.algo.exampl.proxy.static1;

import com.wyx.algo.exampl.proxy.Singer;

/**
 *@ClassName SingerStaticProxy
 *@Description TODO
 *@Author yuxiang
 *@Date 2021/8/1
 *@Version 1.0
 **/
public class SingerStaticProxy implements Singer {

    private Singer singer;

    public SingerStaticProxy(Singer singer){
        this.singer = singer;
    }

    private void beforeSing(){}{
        System.out.println("演唱前-演唱公司布置舞台");
    }

    private void afterSing(){
        System.out.println("演唱完-演唱公司收拾舞台");
    }


    @Override
    public void sing() {
        beforeSing();
        singer.sing();
        afterSing();
    }
}
