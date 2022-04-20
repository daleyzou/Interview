package com.daleyzou.Test;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Test1
 * @description
 * 启动两个线程，交替打印1-100，不允许使用AtomicInteger等
 * @author daleyzou
 * @date 2022年04月20日 20:46
 * @version 1.1.1
 */
public class Test1 {
    volatile  int count = 1;
    public  void print() throws InterruptedException {
        ReentrantLock lock = new ReentrantLock();

        Condition condition1 = lock.newCondition();
        Condition condition2 = lock.newCondition();

        Thread thread1 = new Thread(()->{
            lock.lock();
            try {
                while (count < 100){
                    System.out.println(Thread.currentThread().getName() +  count);
                    count++;
                    condition2.signal();
                    condition1.await();
                }
                condition2.signal();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        });

        Thread thread2 = new Thread(()->{
            lock.lock();
            try {
                while (count < 100){
                    condition2.await();
                    System.out.println(Thread.currentThread().getName() + count);
                    count++;
                    condition1.signal();
                }
                condition1.signal();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        });

        thread2.start();
        Thread.sleep(100);
        thread1.start();
    }

    public static void main(String[] args) throws InterruptedException {
        Test1 test1 = new Test1();
        test1.print();
        while (true){

        }
    }
}
