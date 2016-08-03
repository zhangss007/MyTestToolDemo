package com.ft.myapplication2.interface1;

import android.support.annotation.NonNull;

/**
 * Created by FT_ZSS on 2016/8/3.
 */
public class SplashPresenter implements SplashContract.Presenter {

    SplashContract.View mSplashView;
    @Override
    public void initUmeng() {

    }

    @Override
    public void initHupuSign() {

    }

    @Override
    public void attachView(@NonNull SplashContract.View view) {

        mSplashView = view;
    }

    @Override
    public void detachView() {

        mSplashView = null;
    }
}
