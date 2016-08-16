package com.ft.myapplication2.design_pattern.factory;

/**
 * Created by FT_ZSS on 2016/8/16.
 */
public class Factory {

   public  enum Type {
        TYPEA,
        TYPEB
    }

    public static Api create(Type type){
        Api api = null;

        if ( Type.TYPEA == type ){
            api = new ImplA();
        }else if (Type.TYPEB ==  type){
            api = new ImplB();
        }
        return  api;
    }
}
