package com.ft.myapplication2.design_pattern.adapter;

/**抽象球员类
 * Created by FT_ZSS on 2016/8/16.
 */
public abstract class Player {
    protected  String name;
    public Player(String name){
        this.name = name;
    }

    //进攻与防守方法
    public abstract void attack();
    public abstract void defense();
}
