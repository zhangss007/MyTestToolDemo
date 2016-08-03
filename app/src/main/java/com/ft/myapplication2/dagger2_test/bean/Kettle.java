package com.ft.myapplication2.dagger2_test.bean;

import com.ft.myapplication2.dagger2_test.bean.Heater;

import javax.inject.Inject;

/**
 * Created by FT_ZSS on 2016/7/15.
 * 电水壶
 */
public class Kettle {

    private Heater heater;//电水壶依赖于加热器

    @Inject
    public Kettle(Heater heater){
        super();
        this.heater = heater;
    }

    public void on(){
        heater.on();
    }

    public void off(){
        heater.off();
    }

    public void brew(){
        if (heater.isHot()){
            System.out.println("倒出一杯热水");
        }
    }
}
