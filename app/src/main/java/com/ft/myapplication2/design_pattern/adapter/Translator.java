package com.ft.myapplication2.design_pattern.adapter;

/**
 * Created by FT_ZSS on 2016/8/16.
 */
public class Translator extends Player {

    private ForeignCenter foreignCenter = new ForeignCenter();
    public Translator(String name){
        super(name);

        foreignCenter.setName(name);
    }

    @Override
    public void attack() {

        foreignCenter.jinGong();
    }

    @Override
    public void defense() {

        foreignCenter.fangShou();
    }
}
