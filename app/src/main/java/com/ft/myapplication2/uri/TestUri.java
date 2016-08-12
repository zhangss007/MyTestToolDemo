package com.ft.myapplication2.uri;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;

/**
 * Created by FT_ZSS on 2016/8/12.
 */
public class TestUri {

    public static void testUri_webPage(Context context){

        Uri uri = Uri.parse("http://www.baidu.com/");
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        context.startActivity(intent);
    }

    public static void testUri_map(Context context){

        Uri uri = Uri.parse("geo:38.899533,-77.036476");
        Intent it = new Intent(Intent.ACTION_VIEW,uri);
        context.startActivity(it);
    }

    public static  void testUri_mapPath(Context context){

        Uri uri = Uri.parse("http://maps.google.com/maps?f=d&saddr=startLat%20startLng&daddr=endLat%20endLng&hl=en");
        Intent it = new Intent(Intent.ACTION_VIEW,uri);
        context.startActivity(it);
    }

    public static void testUri_callPhoneDial(Context context){

        Uri uri = Uri.parse("tel:180926436952");
        Intent it = new Intent(Intent.ACTION_DIAL, uri);
        context.startActivity(it);
    }

    public static void testUri_callPhoneCall(Context context){
        Uri uri = Uri.parse("tel.180926436952");
        Intent intent = new Intent(Intent.ACTION_CALL,uri);
        context.startActivity(intent);
    }

    public static void testUri_message(Context context){

        Uri uri = Uri.parse("smsto:0800000123");
        Intent it = new Intent(Intent.ACTION_SENDTO, uri);
        it.putExtra("sms_body", "The SMS text");
        context.startActivity(it);
    }
}
