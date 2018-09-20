package com.lannuo.concurrencylearn;

/**
 * 懒汉模式
 */
public class Singleton1 {

    private static volatile Singleton1 instance=null;

    private Singleton1(){
    }
    //
    public static Singleton1 getInstance(){
        if(instance==null){//双重检测机制
            synchronized(Singleton1.class){
                if(instance==null) {
                    return new Singleton1();
                }
            }
        }
        return instance;
    }
}
