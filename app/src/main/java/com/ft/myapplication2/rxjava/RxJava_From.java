package com.ft.myapplication2.rxjava;

import com.ft.myapplication2.utils.L;

import rx.Observable;
import rx.functions.Action1;

/**
 * Created by FT_ZSS on 2016/8/3.
 */
public class RxJava_From implements IRxJava {

    private static final String TAG = "RxJava_From";
    @Override
    public void test() {

        String[] names = {"xiaoming","xiaohu","xiaozhang","xiaoliu"};
        Observable.from(names)
                .subscribe(new Action1<String>() {
                    @Override
                    public void call(String name) {

                        L.d(TAG,name);
                    }
                });
    }
}
