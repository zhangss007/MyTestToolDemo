package com.ft.myapplication2.utils;

import android.util.Log;

/**
 * Created by FT_ZSS on 2016/8/2.
 */
public class L {

    private static boolean isOpenLog = true ;
    public static void d(String tag, String value){
        if (isOpenLog){

            Log.d(tag, value);
        }
    }
}
