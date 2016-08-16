package com.ft.myapplication2.design_pattern.strategy;

/**
 * Created by FT_ZSS on 2016/8/16.
 */
public class StrategyTest {

    /**
     * 由于实例化不同的策略，所以最终调用context.contextInterface()，获得结果不尽相同
     */
    public void test(){

        Context context;

        context = new Context(new ConcreteStrategyA());
        context.contextInterface();

        context = new Context(new ConcreteStrategyB());
        context.contextInterface();

        context = new Context(new ConcreteStrategyC());
        context.contextInterface();
    }
}
