package com.ft.myapplication2.rxjava;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;

import com.ft.myapplication2.R;

import rx.Observable;
import rx.Observer;
import rx.Subscriber;

/**
 * Created by FT_ZSS on 2016/8/3.
 */
public class RxJava_Demo_DrawableRes implements IRxJava {


    private static final String TAG = "";
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
        }).subscribe(new Observer<Drawable>() {
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
        });
    }

}
