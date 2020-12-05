package com.interview.demo;

import java.util.concurrent.CountDownLatch;

/**
 * com.interview.demo.Test
 * @description TODO
 * @author daleyzou
 * @date 2020年12月03日 15:38
 * @version 1.1.1
 */
public class MultiThread {
    volatile boolean isCOntinueB = false;

    volatile boolean isContinueC = false;

    CountDownLatch countDownLatch;

    public void demo() {
        Thread threadA = new Thread(new Runnable() {

            @Override
            public void run() {
                isCOntinueB = true;
                System.out.println("a 执行结束");
                countDownLatch.countDown();
            }
        });

        Thread threadB = new Thread(new Runnable() {
            @Override
            public void run() {
                while (!isCOntinueB) {
                    System.out.println("wait....");
                }
                // 执行逻辑
                System.out.println("B执行结束");
                // 执行结束
                isContinueC = true;

            }
        });

        Thread threadC = new Thread(new Runnable() {
            @Override
            public void run() {
                while (!isContinueC) {
                    System.out.println("waitB ....");
                }
                System.out.println("c 执行结束");
            }
        });
        countDownLatch = new CountDownLatch(1);
        threadA.start();
        threadB.start();

        threadC.start();
    }

    public static void main(String[] args) {
        MultiThread multiThread = new MultiThread();
        multiThread.demo();
    }
}
