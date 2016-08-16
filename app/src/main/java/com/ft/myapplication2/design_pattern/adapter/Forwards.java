package com.ft.myapplication2.design_pattern.adapter;

/**
 * Created by FT_ZSS on 2016/8/16.
 */
public class Forwards extends Player {

    public Forwards(String name){
        super(name);
    }

    @Override
    public void attack() {

        System.out.println("前锋{0}进攻" + name);
    }

    @Override
    public void defense() {

        System.out.println("前锋{0}防守" + name);
    }
}
