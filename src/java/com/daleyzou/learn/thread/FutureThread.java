package com.daleyzou.learn.thread;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * FutureThread
 *
 * @author daleyzou
 * @version 1.1.1
 * @description TODO
 * @date 2023年09月01日 17:51
 */
public class FutureThread {
    public static void main(String[] args) {
        
        ExecutorService service = Executors.newFixedThreadPool(10);
        
        Future<Integer> future = service.submit(new CallableTask());
        
        try {
            
            System.out.println(future.get());
            
        } catch (InterruptedException e) {
            
            e.printStackTrace();
            
        } catch (ExecutionException e) {
            
            e.printStackTrace();
            
        }
        
        service.shutdown();
        
    }
    
    static class CallableTask implements Callable<Integer> {
        
        @Override
        
        public Integer call() throws Exception {
            
            Thread.sleep(3000);
            
            return new Random().nextInt();
            
        }
        
    }
}
