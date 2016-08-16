package com.ft.myapplication2.design_pattern.proxy;

/**
 * Created by FT_ZSS on 2016/8/16.
 */
public class SchoolGirl {

    private String name;
    public SchoolGirl(String name){

        this.name = name;
    }

    public SchoolGirl(){

    }

    public void setName(String name){

        this.name = name;
    }

    public String getName(){
        return name;
    }
}
