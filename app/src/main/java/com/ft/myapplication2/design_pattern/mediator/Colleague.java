package com.ft.myapplication2.design_pattern.mediator;

/**
 * Created by FT_ZSS on 2016/8/16.
 */
public abstract class Colleague {
    protected  Mediator mediator;

    public Colleague(Mediator mediator){
        this.mediator = mediator;
    }
}
