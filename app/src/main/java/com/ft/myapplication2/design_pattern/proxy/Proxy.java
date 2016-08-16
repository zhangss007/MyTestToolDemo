package com.ft.myapplication2.design_pattern.proxy;

/**
 * Created by FT_ZSS on 2016/8/16.
 */
public class Proxy implements GiveGift{

    private  Pursuit pursuit;

    public Proxy(SchoolGirl girl){

        pursuit = new Pursuit(girl);
    }

    @Override
    public void giveDolls() {

        pursuit.giveDolls();
    }

    @Override
    public void giveFlows() {

        pursuit.giveFlows();
    }

    @Override
    public void giveChocolate() {

        pursuit.giveChocolate();
    }
}
