package com.ft.myapplication2.dagger2_test.bean;

/**
 * Created by FT_ZSS on 2016/7/15.
 * 加热器
 */
public class Heater {

    private boolean isHot;

    public void on(){
        System.out.println("开始烧热水了");
        isHot = true;
    }

    public void off(){
        System.out.println("关闭加热器");
        isHot = false;
    }

    public boolean isHot(){
        return isHot;
    }
}
