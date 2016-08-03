package com.ft.myapplication2.rxjava;

import com.ft.myapplication2.utils.L;

import rx.Observable;
import rx.Subscriber;

/**
 * Created by FT_ZSS on 2016/8/3.
 */
public class RxJava_Create implements IRxJava {

    private static final String TAG = "RxJava_Create";
    @Override
    public void test() {
        //创建观察者
        Subscriber subscriber = new Subscriber<String>() {
            @Override
            public void onCompleted() {
                L.d(TAG,"Complete");
            }

            @Override
            public void onError(Throwable e) {

                L.d(TAG,"Error");
            }

            @Override
            public void onNext(String s) {

                L.d(TAG,"Item:" +s);
            }
        };

        //创建被观察者
        Observable observable = Observable.create(new Observable.OnSubscribe<String>() {


            @Override
            public void call(Subscriber<? super String> subscriber) {
                subscriber.onNext("Hi");
                subscriber.onNext("xiao ming");
                subscriber.onNext("!");
                subscriber.onCompleted();
            }
        });
        //订阅
        observable.subscribe(subscriber);
    }
}
