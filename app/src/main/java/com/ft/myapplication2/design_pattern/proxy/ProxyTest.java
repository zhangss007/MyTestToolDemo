package com.ft.myapplication2.design_pattern.proxy;

/**代理类的实现
 * Created by FT_ZSS on 2016/8/16.
 */
public class ProxyTest {

    public static void test(){

        SchoolGirl schoolGirl = new SchoolGirl();
        schoolGirl.setName("李娇娇");

        Proxy proxy = new Proxy(schoolGirl);
        proxy.giveDolls();
        proxy.giveFlows();
        proxy.giveChocolate();
    }
}
