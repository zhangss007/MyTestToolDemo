package com.ft.myapplication2.dagger2_test.module;

import com.ft.myapplication2.dagger2_test.bean.Heater;
import com.ft.myapplication2.dagger2_test.bean.Kettle;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by FT_ZSS on 2016/7/15.
 */
@Module
public class KettleModule {

    @Singleton
    @Provides
    Heater providesHeater(){
        return new Heater();
    }

    @Singleton
    @Provides
    Kettle providesKettle(Heater heater){
        return new Kettle(heater);
    }
}
