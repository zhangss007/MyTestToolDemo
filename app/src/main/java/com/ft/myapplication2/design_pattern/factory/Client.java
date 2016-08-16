package com.ft.myapplication2.design_pattern.factory;

/**简单工厂模式
 * Created by FT_ZSS on 2016/8/16.
 */
public class Client {

    public static void test(){

        Api api = Factory.create(Factory.Type.TYPEA);
        api.operation("正在使用简单工厂");
    }
}
