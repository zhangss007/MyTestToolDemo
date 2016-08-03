package com.ft.myapplication2.test.generosity;

/**
 * Created by FT_ZSS on 2016/8/2.
 */
public class GenerosityTest {

    /**
     * 泛型接口
     */
    public void test1(){

        FruitGenerator generator = new FruitGenerator();
        System.out.println(generator.next());
        System.out.println(generator.next());
        System.out.println(generator.next());
    }

    /**
     * 泛型类
     */
    public void test2(){
        Container1<String, String> c1 = new Container1<String,String>("name","xiaoming");
        Container1<String, Integer> c2 = new Container1<String,Integer>("age",26);
        Container1<Double, Double>  c3 = new Container1<Double, Double>(1.1,2.2);
        System.out.println(c1.getKey() + ":" + c1.getValue());
        System.out.println(c2.getKey() + ":" + c2.getValue());
        System.out.println(c3.getKey() + ":" + c3.getValue());
    }

    /**
     * 泛型方法
     */
    public void test3(){

        out("findingsea");
        out(123);
        out(12.3);
        out(true);
    }

    /**
     * 泛型方法可变参数
     */
    public void test4(){

        out1("findingsea",123,12.3,true);
    }

    /**
     * 泛型方法
     * @param t
     * @param <T>
     */
    public <T> void out(T t){
        System.out.println(t);
    }

    /**
     * 泛型方法可变参数
     * @param args
     * @param <T>
     */
    public <T> void out1(T... args){

        for(T t:args){
            System.out.println(t);
        }
    }
}
