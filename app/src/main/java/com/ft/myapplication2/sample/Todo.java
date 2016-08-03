package com.ft.myapplication2.sample;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by FT_ZSS on 2016/7/1.
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Todo {
    public enum Priority {LOW,MEDIUM,HIGH}
    public enum Status {STARTED,NO_STARTED}
    String author() default "Yash";
    Priority priority() default Priority.LOW;
    Status status() default Status.NO_STARTED;
}
