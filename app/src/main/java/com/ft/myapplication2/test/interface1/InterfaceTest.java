package com.ft.myapplication2.test.interface1;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by FT_ZSS on 2016/8/2.
 */
public class InterfaceTest {

    public void test(){

        List<String> list = new ArrayList<String>();
        list.add("xiaoming");
        System.out.println(list.get(0));
        System.out.println("Size:" + list.size());
        list.remove("xiaoming");
        System.out.println("Size:" + list.size());
    }
}
