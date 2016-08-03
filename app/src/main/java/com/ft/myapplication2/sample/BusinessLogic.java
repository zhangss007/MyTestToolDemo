package com.ft.myapplication2.sample;

/**
 * Created by FT_ZSS on 2016/7/1.
 */
public class BusinessLogic {
    public BusinessLogic(){
        super();
    }
    public void compltedMethod(){
        System.out.println("this method is complete");
    }

    @Todo(priority = Todo.Priority.HIGH)
    public void notYetStartedMethod(){
        //No Code Written yet
    }

    @Todo(priority = Todo.Priority.MEDIUM,author = "Uday",status = Todo.Status.STARTED)
    public void incompleteMethod1(){
       // Some business logic is written
        // But its not complete yet
    }

    @Todo(priority = Todo.Priority.LOW,status = Todo.Status.STARTED)
    public void incompleteMethod2(){
        //Some business logic is written
        //But its not complete yet
    }
}
