package com.lannuo.concurrencylearn;

import java.util.concurrent.atomic.AtomicReference;

public class AtomicRefferenceTest {

    public static void main(String[] args) {
        AtomicReference update=new AtomicReference(0);
        update.compareAndSet(0,2);
        update.compareAndSet(0,1);
        update.compareAndSet(1,3);
        update.compareAndSet(2,4);
        update.compareAndSet(3,5);
        System.out.println(update.get());
    }
}
