package com.ft.myapplication2.rxjava.student;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

/**学生类
 * Created by FT_ZSS on 2016/8/3.
 */
public class Student {
    private String name;
    private List<Course> courses = new ArrayList<Course>();

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public void setCourses(Course course){
        courses.add(course);
    }

    public List<Course> getCourses(){
        return courses;
    }

}
