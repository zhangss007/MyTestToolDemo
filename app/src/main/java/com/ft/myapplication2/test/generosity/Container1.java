package com.ft.myapplication2.test.generosity;

/**
 * Created by FT_ZSS on 2016/8/2.
 */
public class Container1<K,V> {
    public K key ;
    public V value ;

    public Container1(K k, V v){
        this.key = k;
        this.value = v;
    }

    public void setKey(K key){
        this.key = key;
    }

    public K getKey(){
        return key;
    }

    public void setValue(V value){
        this.value = value;
    }

    public V getValue(){
        return value;
    }

}
