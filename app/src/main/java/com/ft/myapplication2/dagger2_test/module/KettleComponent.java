package com.ft.myapplication2.dagger2_test.module;

import com.ft.myapplication2.dagger2_test.bean.Kettle;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by FT_ZSS on 2016/7/15.
 */
@Singleton
@Component(modules = KettleModule.class)
public interface KettleComponent {
    Kettle providesKettle();
}
