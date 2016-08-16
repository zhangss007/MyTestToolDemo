package com.ft.myapplication2.design_pattern.adapter;

/** 适配器模式测试类
 * Created by FT_ZSS on 2016/8/16.
 */
public class AdapterTest {

    public static void test(){

        Player a = new Forwards("A");
        a.attack();

        Player b = new Guards("B");
        b.attack();

        Player c = new Translator("C");
        c.defense();
    }
}
