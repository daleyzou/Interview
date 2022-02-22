package com.daleyzou.learn.thread;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

/**
 * ThreeThread
 *
 * @author zoudaifa
 * @description 三个线程打印 a,b,c
 * @date 2022年02月22日 5:14 下午
 */
public class ThreeThread {


    public void test1() {

       ReentrantLock lock = new ReentrantLock();
       AtomicInteger count = new AtomicInteger(1);
       TimeUnit unit;
       BlockingQueue workQueue;
        Thread threadA = new Thread(()->{
             while(true){
                 lock.lock();
                 try {
                     if (count.get() % 3==0){
                         System.out.println("a");
                         count.getAndIncrement();
                     }
                 }finally {
                     lock.unlock();
                 }
             }
        });

        Thread threadB = new Thread(()->{
            while(true){
                lock.lock();
                try {
                    if (count.get() % 3==1){
                        System.out.println("b");
                        count.getAndIncrement();
                    }
                }finally {
                    lock.unlock();
                }
            }
        });

        Thread threadC = new Thread(()->{
            while(true){
                lock.lock();
                try {
                    if (count.get() % 3==2){
                        System.out.println("c");
                        count.getAndIncrement();
                    }
                }finally {
                    lock.unlock();
                }
            }
        });

//        threadA.start();
//        threadB.start();
//        threadC.start();

        TestThread testThread1 = new TestThread(count);
        TestThread testThread2 = new TestThread(count);
        TestThread testThread3 = new TestThread(count);

        new Thread(testThread1).start();
        new Thread(testThread2).start();
        new Thread(testThread3).start();
    }

    public static void main(String[] args) {
        ThreeThread threeThread = new ThreeThread();
        threeThread.test1();
    }

    class TestThread implements Runnable {
        AtomicInteger atomicInteger;

        public TestThread(AtomicInteger atomicInteger) {
            this.atomicInteger = atomicInteger;
        }

        @Override
        public void run() {
            while(atomicInteger.get() <= 100){
                if (atomicInteger.get() % 3==1){
                    System.out.println("a");
                    atomicInteger.getAndIncrement();
                }
                if (atomicInteger.get() % 3==2){
                    System.out.println("b");
                    atomicInteger.getAndIncrement();
                }
                if (atomicInteger.get() % 3==0){
                    System.out.println("c");
                    atomicInteger.getAndIncrement();
                }
            }

        }
    }
}
