package com.lannuo.concurrencylearn;

import com.lannuo.concurrencylearn.annotation.NotThreadSafe;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

@NotThreadSafe
public class ConcurrencyTest {
    private static int clentTotal=5000;
    private static int theadTotal=200;
    private static int count=0;

    private static void add(){
        count++;
    }

    public static void main(String[] args) throws Exception{
        ExecutorService executorService= Executors.newCachedThreadPool();
        final Semaphore semaphore=new Semaphore(theadTotal);
        final CountDownLatch countDownLatch=new CountDownLatch(clentTotal);
        for (int i = 0; i < clentTotal; i++) {
            executorService.execute(()->{
                try {
                    semaphore.acquire();
                    add();
                    semaphore.release();
                }catch (Exception e){
                    e.printStackTrace();
                }
                countDownLatch.countDown();
            });
        }
        countDownLatch.await();
        executorService.shutdown();
        System.out.println(count);
    }
}
