package com.ft.myapplication2.design_pattern.strategy;

/**
 * Created by FT_ZSS on 2016/8/16.
 */
public class Context {

    private Strategy strategy;

    /**
     * 初始化时，传入具体的策略对象
     * @param strategy
     */
    public  Context(Strategy strategy){

        this.strategy = strategy;
    }


    /**
     * 根据具体的策略的对象，调用其算法的方法
     */
    public void contextInterface(){

        strategy.algorithmInterface();
    }
}
