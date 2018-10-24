package com.daleyzou.learn.thread;

/**
 * @Author: DaleyZou
 * @Description: 通过继承Thread类的方式来使用线程
 * @Date: Created in 10:47 2018-10-17
 * @Modified By:
 */
public class ExtendsThread extends Thread {
    @Override
    public void run() {
        System.out.println("my name is daleyzou!");
    }

    public static void main(String[] args){
        ExtendsThread thread = new ExtendsThread();
        thread.start();


    }
}
