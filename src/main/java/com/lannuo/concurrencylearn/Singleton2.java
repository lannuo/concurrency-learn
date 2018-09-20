package com.lannuo.concurrencylearn;

/**
 * 饿汉模式
 * 缺点耗性能
 */
public class Singleton2 {
    private static Singleton2 instance=null;
    static {
        instance=new Singleton2();
    }
    public static Singleton2 getInstance(){
        return instance;
    }
}
