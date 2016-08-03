package com.ft.myapplication2.interface1;

import android.support.annotation.NonNull;

/**
 * Created by FT_ZSS on 2016/8/3.
 */
public interface BasePresenter<T extends BaseView> {

    void attachView(@NonNull T view);
    void detachView();
}
