package com.ft.myapplication2.dagger2_test;

import com.ft.myapplication2.dagger2_test.bean.Kettle;
import com.ft.myapplication2.dagger2_test.module.DaggerKettleComponent;
import com.ft.myapplication2.dagger2_test.module.KettleComponent;

/**
 * Created by FT_ZSS on 2016/7/15.
 */
public class DaggerTest {

    public static void test(){

        KettleComponent component = DaggerKettleComponent.builder().build();
        Kettle kettle = component.providesKettle();
        kettle.on();
        kettle.brew();
        kettle.off();
    }
}
