package com.ft.myapplication2.design_pattern.singleton;

/**单例模式 加上synchronized实现线程安全
 * Created by FT_ZSS on 2016/8/16.
 */
public class Signleton2 implements ISingleton {

    private static Signleton2 instance = null;

    protected Signleton2(){

    }

    public static synchronized Signleton2 getInstance(){

        if (instance == null){

            instance = new Signleton2();
        }
        return instance;
    }
}
