package com.ft.myapplication2.rxjava;

import android.graphics.Bitmap;

import rx.Observable;
import rx.functions.Action1;
import rx.functions.Func1;

/**
 * Created by FT_ZSS on 2016/8/3.
 */
public class RxJava_Scheduler_Map implements IRxJava {

    private static final String TAG = "RxJava_Scheduler_Map";

    @Override
    public void test() {

        Observable.just("images/logo.png")
                .map(new Func1<String, Bitmap>() {
                    @Override
                    public Bitmap call(String filePath) {
                        return getBitmapFromFilePath(filePath);
                    }
                }).subscribe(new Action1<Bitmap>() {
            @Override
            public void call(Bitmap bitmap) {

                showBitmap(bitmap);
            }
        });
    }

    private Bitmap getBitmapFromFilePath(String filePath){
        return null;
    }

    private void showBitmap(Bitmap bitmap){

    }
}
