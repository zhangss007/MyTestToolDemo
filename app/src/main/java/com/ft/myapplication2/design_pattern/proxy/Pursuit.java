package com.ft.myapplication2.design_pattern.proxy;

/**创建追求者类
 * Created by FT_ZSS on 2016/8/16.
 */
public class Pursuit implements GiveGift{

    private SchoolGirl mm;

    public Pursuit(SchoolGirl girl){
        this.mm = girl;
    }

    @Override
    public void giveDolls() {
        System.out.println(mm.getName() + "送给你洋娃娃!");
    }

    @Override
    public void giveFlows() {

        System.out.println(mm.getName() + "送给你鲜花!");
    }

    @Override
    public void giveChocolate() {

        System.out.println(mm.getName() + "送给你巧克力!");
    }
}
