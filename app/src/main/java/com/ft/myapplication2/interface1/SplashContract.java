package com.ft.myapplication2.interface1;

/**
 * Created by FT_ZSS on 2016/8/3.
 */
public interface SplashContract {

    interface View extends BaseView{
        void showMainUi();
    }

    interface Presenter extends BasePresenter<View>{
        void initUmeng();
        void initHupuSign();
    }
}
