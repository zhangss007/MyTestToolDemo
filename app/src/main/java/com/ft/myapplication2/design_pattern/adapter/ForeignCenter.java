package com.ft.myapplication2.design_pattern.adapter;

/**外籍中锋
 * Created by FT_ZSS on 2016/8/16.
 */
public class ForeignCenter {

    private String name;

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public void jinGong(){

        System.out.println("外籍中锋{0}进攻" + name);
    }

    public void fangShou(){
        System.out.println("外籍中锋{0}进攻" + name);
    }
}
