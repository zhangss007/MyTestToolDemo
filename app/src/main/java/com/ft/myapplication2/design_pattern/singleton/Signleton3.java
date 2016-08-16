package com.ft.myapplication2.design_pattern.singleton;

/**双重检查加锁的单例模式
 * Created by FT_ZSS on 2016/8/16.
 */
public class Signleton3 implements ISingleton {

    /**
     * 对保存实例的变量添加volitile的修饰
     */
    private  volatile static Signleton3 instance = null;

    protected Signleton3(){

    }

    public static Signleton3 getInstance(){
        //先检查实例是否存在，如果不存在才进入下面的同步块
        if (instance == null){
            //同步块，线程安全的创建实例
            synchronized(Signleton3.class){
                //再次检查实例是否存在，如果不存在才真正的创建实例
                instance = new Signleton3();
            }
        }
        return instance;
    }
}
