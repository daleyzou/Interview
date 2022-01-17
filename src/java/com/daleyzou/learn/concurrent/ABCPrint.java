package com.daleyzou.learn.concurrent;

import java.util.concurrent.locks.ReentrantLock;

/**
 * ABCPrint
 *
 * @author daleyzou
 * @description 循环打印ABC
 * @date 2022年01月17日 3:07 下午
 */
public class ABCPrint {
    static volatile int state = 0;
    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();

        Thread threadA = new Thread(()->{
            while (state <= 30){
                lock.lock();
                try{
                    if (state % 3 == 0){
                        System.out.println("A");
                        state++;
                    }
                }finally {
                    lock.unlock();
                }
            }
        });
        Thread threadB = new Thread(()->{
            while(state <= 30){
                lock.lock();
                try{
                    if (state % 3 == 1){
                        System.out.println("B");
                        state++;
                    }
                }finally {
                    lock.unlock();
                }
            }
        });
        Thread threadC = new Thread(()->{
            while(state <= 30){
                lock.lock();
                try{
                    if (state % 3 == 2){
                        System.out.println("C");
                        state++;
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
