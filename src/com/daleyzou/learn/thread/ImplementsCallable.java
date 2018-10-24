package com.daleyzou.learn.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @Author: DaleyZou
 * @Description: 通过实现 Callable 接口的方式来使用线程
 * @Date: Created in 10:38 2018-10-17
 * @Modified By:
 */
public class ImplementsCallable implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        return 520;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ImplementsCallable callable = new ImplementsCallable();
        FutureTask<Integer> futureTask = new FutureTask<>(callable);
        Thread thread = new Thread(futureTask);
        thread.start();
        System.out.println(futureTask.get());
    }
}
