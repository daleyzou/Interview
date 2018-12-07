package com.daleyzou.learn.concurrent;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author: DaleyZou
 * @Description: 让一个线程等待多个线程执行完成后再执行
 * @Date: Created in 9:42 2018-10-18
 * @Modified By:
 */
public class CountdownLatchExample {

    public static void main(String[] args) throws InterruptedException {
        final int totalThread = 10;
        CountDownLatch countDownLatch = new CountDownLatch(totalThread);
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < totalThread; i++){
            executorService.execute(()->{
                System.out.print("run...");
                countDownLatch.countDown();
            });
        }
        countDownLatch.await();
        System.out.println("end...");
        executorService.shutdown();
    }
}
