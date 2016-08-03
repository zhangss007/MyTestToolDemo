package com.ft.myapplication2;

import com.ft.myapplication2.inject.FruitColor;
import com.ft.myapplication2.inject.FruitName;

/**
 * Created by FT_ZSS on 2016/6/23.
 */
public class Apple {
    @FruitName("Apple")
    private String appleName;

    @FruitColor(fruitColor = FruitColor.Color.RED)
    private String appleColor;

    public void setAppleColor(String appleColor){
        this.appleColor = appleColor;
    }

    public String getAppleColor(){
        return appleColor;
    }

    public void setAppleName(String appleName){
        this.appleName = appleName;
    }

    public String getAppleName(){
        return appleName;
    }

    public void displayName(){
        System.out.println("水果的名字是：苹果");
    }

















}
