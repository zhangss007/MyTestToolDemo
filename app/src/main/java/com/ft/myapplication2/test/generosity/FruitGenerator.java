package com.ft.myapplication2.test.generosity;

import java.util.Random;

/**
 * Created by FT_ZSS on 2016/8/2.
 */
public class FruitGenerator implements Generator<String> {

    private String[] fruits = new String[]{"Apple", "Banana", "Pear"};

    @Override
    public String next() {
        Random random = new Random();
        return fruits[random.nextInt(3)];
    }
}
