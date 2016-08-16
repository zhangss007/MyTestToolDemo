package com.ft.myapplication2.design_pattern.factory;

/**
 * Created by FT_ZSS on 2016/8/16.
 */
public class ImplB implements Api {
    @Override
    public void operation(String s) {
        System.out.println("ImplB ==========" + s);
    }
}
