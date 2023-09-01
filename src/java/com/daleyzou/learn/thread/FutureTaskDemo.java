package com.daleyzou.learn.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * FutureTaskDemo
 *
 * @author daleyzou
 * @version 1.1.1
 * @description TODO
 * @date 2023年09月01日 18:11
 */
public class FutureTaskDemo {
    
    public static void main(String[] args) {
        
        Task task = new Task();
        
        FutureTask<Integer> integerFutureTask = new FutureTask<>(task);
        
        new Thread(integerFutureTask).start();
        
        try {
            
            System.out.println("task运行结果："+integerFutureTask.get());
            
        } catch (InterruptedException e) {
            
            e.printStackTrace();
            
        } catch (ExecutionException e) {
            
            e.printStackTrace();
            
        }
        
    }
    
}

class Task implements Callable<Integer> {
    
    @Override
    public Integer call() throws Exception {
        
        System.out.println("子线程正在计算");
        
        int sum = 0;
        
        for (int i = 0; i < 100; i++) {
            
            sum += i;
            
        }
        
        return sum;
        
    }
    
}
