package com.daleyzou.learn.justdo;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * DeadLockTest
 * @description 模拟死锁的产生过程
 * @author daleyzou
 * @date 2022年04月12日 17:30
 * @version 1.1.1
 */
public class DeadLockTest {
    static class ObjA{
        public ObjA(){

        }
    }
    static class ObjB{
        public ObjB(){

        }
    }
    public static void main(String[] args) throws ExecutionException, InterruptedException {
       Thread threadA = new Thread(()->{
           synchronized (ObjA.class){
               System.out.println(Thread.currentThread() + "拿到ObjA锁了");
               try {
                   Thread.sleep(1000);
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }
               synchronized (ObjB.class){
                   System.out.println(Thread.currentThread() + "拿到ObjB锁了");
               }
           }
       });
       Thread threadB = new Thread(()->{
           synchronized (ObjB.class){
               System.out.println(Thread.currentThread() + "拿到ObjB锁了");
               try {
                   Thread.sleep(1000);
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }
               synchronized (ObjA.class){
                   System.out.println(Thread.currentThread() + "拿到ObjA锁了");
               }
           }
       });
        System.out.println("start two threads");
       //threadA.start();
       //threadB.start();
        System.out.println("two thread end");

        AtomicInteger count = new AtomicInteger();
        ThreadPoolExecutor executor = new ThreadPoolExecutor(4, 4, 100000, TimeUnit.MINUTES, new LinkedBlockingQueue<>(100), new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                return new Thread(r, "thread-factory-"+count.getAndIncrement());
            }
        }, new ThreadPoolExecutor.AbortPolicy());
        Future<?> submitB = executor.submit(threadB);
        Future<?> submitA = executor.submit(threadA);
        submitB.get();
        submitA.get();
    }
}
