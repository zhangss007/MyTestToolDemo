package com.ft.myapplication2.test.generosity;

/**
 * Created by FT_ZSS on 2016/8/2.
 */
public class Container {
    private String key;
    private String value;

    public Container(String key, String value){
        this.key = key;
        this.value = value;
    }

    public void setKey(String key){
        this.key = key;
    }

    public String getKey(){
        return key;
    }

    public void setValue(String value){
        this.value = value;
    }

    public String getValue(){
        return value;
    }
}
