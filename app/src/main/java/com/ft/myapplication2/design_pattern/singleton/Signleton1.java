package com.ft.myapplication2.design_pattern.singleton;

import javax.inject.Singleton;

/**单例模式 普通实现
 * Created by FT_ZSS on 2016/8/16.
 */
public class Signleton1 implements ISingleton {


    /**
     * 饿汉模式
     */
//    private  static Signleton1 singleton = new Signleton1();

    /**
     * 懒汉模式
     */
    private static Signleton1 instance = null;


    protected  Signleton1(){

    }

    public  static  Signleton1 getInstance(){

        if (instance == null){

            instance = new Signleton1();
        }
        return instance;
    }
}
