package com.ft.myapplication2.rxjava;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;

import rx.Observable;
import rx.Observer;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by FT_ZSS on 2016/8/3.
 */
public class RxJava_Scheduler_DrableRes implements IRxJava {

    private static final String TAG = "RxJava_Scheduler_DrableRes";
    private ImageView imageView;
    private Drawable drawable;

    public void setImageView(ImageView imageView){
        this.imageView = imageView;
    }

    public void setDrawable(Drawable drawable){
        this.drawable = drawable;
    }

    @Override
    public void test() {

        Observable.create(new Observable.OnSubscribe<Drawable>() {

            @Override
            public void call(Subscriber<? super Drawable> subscriber) {
                subscriber.onNext(drawable);
                subscriber.onCompleted();
            }
        }).observeOn(Schedulers.io())
        .subscribeOn(AndroidSchedulers.mainThread())
        .subscribe(new Subscriber<Drawable>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(Drawable drawable) {

                imageView.setImageDrawable(drawable);
            }
        })
        ;

    }
}
