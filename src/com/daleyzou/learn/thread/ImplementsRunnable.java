package com.daleyzou.learn.thread;

/**
 * @Author: DaleyZou
 * @Description: 通过实现 Runnable 接口的方式来使用线程
 * @Date: Created in 10:24 2018-10-17
 * @Modified By:
 */
public class ImplementsRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("my name is daleyzou! Welcome to my world!");
    }

    public static void main(String[] args){
        ImplementsRunnable runnable = new ImplementsRunnable();
        Thread thread = new Thread(runnable);
        thread.start();
    }
}
