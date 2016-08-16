package com.ft.myapplication2.design_pattern.singleton;

/**一种更好的方式实现单例模式
 * Created by FT_ZSS on 2016/8/16.
 */
public class Signleton4 implements ISingleton{

    /**
     * 类级的内部类，也就是静态类的成员式内部类，该内部类的实例与外部类的实例
     * 没有绑定关系，而且只有被调用时才会装载，从而实现了延迟加载
     * @author dream
     *
     */
    private static class SingletonHolder{
        /**
         * 静态初始化器，有JVM来保证线程安全
         */
        private static Signleton4 instance = new Signleton4();
    }

    /**
     * 私有构造方法
     */
    private Signleton4(){

    }

    public static Signleton4 getInstance(){
        return SingletonHolder.instance;
    }
}
