package com.lannuo.concurrencylearn;

/**
 * 枚举模式（最安全）
 * 对象线程安全发布
 */
public class ThreadEnum {
    private ThreadEnum(){

    }
    public static ThreadEnum getInstance(){
        return Singleton.Instance.getThreadEnum();
    }
    private enum Singleton{
        Instance;
        private ThreadEnum threadEnum;
        //JVM保证只调用一次
        Singleton(){
            threadEnum=new ThreadEnum();
        }
        public ThreadEnum getThreadEnum(){
            return threadEnum;
        }
    }
}
