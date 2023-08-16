package com.daleyzou.learn.concurrent;

import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * ReentrantTest
 *
 * @author daleyzou
 * @version 1.1.1
 * @description TODO
 * @date 2023年08月16日 20:33
 */
public class ReentrantTest {
    
    public static void main(String[] args) {
        testLockDemo();
    }
    
    private static void testLockDemo() {
        ReentrantLock lock = new ReentrantLock(true);
        if(!lock.tryLock()){
            return;
        }
        try {
            System.out.println("get lock");
        }finally {
            lock.unlock();
        }
    }
    
    public static void testReentrantReadWirteLock(){
        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock(false);
        reentrantReadWriteLock.readLock().lock();
        reentrantReadWriteLock.readLock().unlock();
        reentrantReadWriteLock.writeLock().lock();
        reentrantReadWriteLock.writeLock().unlock();
        
        if (reentrantReadWriteLock.readLock().tryLock()){
            reentrantReadWriteLock.readLock().unlock();
        }
        if (reentrantReadWriteLock.writeLock().tryLock()){
            reentrantReadWriteLock.writeLock().unlock();
        }
    }
}
