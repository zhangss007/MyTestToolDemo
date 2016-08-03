package com.ft.myapplication2.rxjava.student;

/**
 * 课程类
 * Created by FT_ZSS on 2016/8/3.
 */
public class Course {

    /**
     * 课程名称
     */
    private String name;
    /**
     * 课程分数
     */
    private int score;

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public void setScore(int score){
        this.score = score;
    }

    public int getScore(){
        return score;
    }

}
