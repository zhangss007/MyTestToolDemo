package com.ft.myapplication2.design_pattern.mediator;

/**中介者模式
 * 用一个中介对象来封装一系列的对象交互。中介者使各对象不需要显示地相互引用，从而使其耦合松散，而且可以独立的改变他们之间的交互
 * Created by FT_ZSS on 2016/8/16.
 */
public abstract class Mediator {
    public abstract void send(String message, Colleague colleague);
}
