package com.daleyzou.learn.concurrent;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author: DaleyZou
 * @Description: 用来控制多个线程互相等待，只有多个线程都到达后，线程才继续执行
 * @Date: Created in 10:08 2018-10-18
 * @Modified By:
 */
public class CyclicBarrierExample {
    public static void main(String[] agrs){
        final int totalThread = 10;
        CyclicBarrier cyclicBarrier = new CyclicBarrier(totalThread);
        ExecutorService executorService = Executors.newCachedThreadPool();

            for (int i = 0; i < 10; i++){
                executorService.execute(()->{
                    System.out.print("before...");
                    try {
                        cyclicBarrier.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (BrokenBarrierException e) {
                        e.printStackTrace();
                    }
                    System.out.print("end...");
                });
            }
        executorService.shutdown();
    }
}
