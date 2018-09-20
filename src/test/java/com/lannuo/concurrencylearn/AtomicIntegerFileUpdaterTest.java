package com.lannuo.concurrencylearn;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

public class AtomicIntegerFileUpdaterTest {
    public static void main(String[] args) {
        AtomicIntegerFile o=new AtomicIntegerFile();
        AtomicIntegerFieldUpdater<AtomicIntegerFile> updater=AtomicIntegerFieldUpdater.newUpdater(AtomicIntegerFile.class,"count");
        if(updater.compareAndSet(o,200,300)){
            System.out.println(o.getCount());
        }
        if(updater.compareAndSet(o,200,400)){
            System.out.println(o.getCount());
        }else{
            System.out.println(o.getCount());
        }
    }
}

class AtomicIntegerFile{
    public volatile int count=200;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}