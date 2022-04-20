package com.daleyzou.learn.justdo;

import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

/**
 * ThreadPrint
 * @description 三个线程循环打印 A B C
 * @author daleyzou
 * @date 2022年04月13日 23:04
 * @version 1.1.1
 */
public class ThreadPrint {
    static class MyThread extends Thread{

    }
    static Thread threadA;
    static Thread threadB;
    static Thread threadC;
    static void printMethod2(){
        threadA = new Thread(()->{
            for(int i = 0; i < 10; i++){
                System.out.println("A");
                LockSupport.unpark(threadB);
                LockSupport.park();
            }
        });
        threadB = new Thread(()->{
            for(int i = 0; i < 10; i++){
                LockSupport.park();
                System.out.println("B");
                LockSupport.unpark(threadC);
            }
        });
        threadC = new Thread(()->{
            for(int i = 0; i < 10; i++){
                LockSupport.park();
                System.out.println("C");
                LockSupport.unpark(threadA);
            }
        });

        threadA.start();
        threadB.start();
        threadC.start();
    }

    public static void main(String[] args) {
        // printMethod1();
        // printMethod2();
        printMethod3();
    }

    private static void printMethod3(){
        ReentrantLock lock = new ReentrantLock();
        Condition conditionA = lock.newCondition();
        Condition conditionB = lock.newCondition();
        Condition conditionC = lock.newCondition();

        Thread threadA = new Thread(()->{
            lock.lock();
            try {
                for(int i = 0; i < 10; i++){
                    System.out.println("A");
                    conditionB.signal();
                    conditionA.await();
                }
                conditionB.signal();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
              lock.unlock();
            }
        });

        Thread threadB = new Thread(()->{
            lock.lock();
            try {
                for(int i = 0; i < 10; i++){
                    System.out.println("B");
                    try {
                        conditionC.signal();
                        conditionB.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                conditionC.signal();
            }finally {
                lock.unlock();
            }
        });

        Thread threadC = new Thread(()->{
            lock.lock();
            try {
                for(int i = 0; i < 10; i++){
                    System.out.println("C");
                    conditionA.signal();
                    conditionC.await();
                }
                conditionA.signal();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        });

        threadA.start();
        threadB.start();
        threadC.start();
    }

    private static void printMethod1() {
        ReentrantLock lock = new ReentrantLock();
        AtomicInteger count = new AtomicInteger(0);
        int i = 0;
        Thread threadA = new Thread(()->{
            while (count.get() < 15){
                lock.lock();
                try {
                    if (count.get() % 3 == 0){
                        System.out.println("A");
                        count.getAndIncrement();
                    }
                }finally {
                    lock.unlock();
                }
            }
        });
        Thread threadB = new Thread(()->{
            while (count.get() < 15){
                lock.lock();
                try {
                    if (count.get() % 3 == 1){
                        System.out.println("B");
                        count.getAndIncrement();
                    }
                }finally {
                    lock.unlock();
                }
            }
        });
        Thread threadC = new Thread(()->{
            while (count.get() < 15){
                lock.lock();
                try {
                    if (count.get() % 3 == 2){
                        System.out.println("C");
                        count.getAndIncrement();
                    }
                }finally {
                    lock.unlock();
                }
            }
        });

        threadA.start();
        threadB.start();
        threadC.start();
    }
}
