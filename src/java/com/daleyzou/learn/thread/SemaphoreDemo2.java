package com.daleyzou.learn.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * SemaphoreDemo2
 *
 * @author daleyzou
 * @version 1.1.1
 * @description TODO
 * @date 2023年09月04日 11:27
 */
public class SemaphoreDemo2 {
    
    static Semaphore semaphore = new Semaphore(3);
    
    public static void main(String[] args) {
        
        ExecutorService service = Executors.newFixedThreadPool(50);
        
        for (int i = 0; i < 1000; i++) {
            
            service.submit(new Task());
            
        }
        
        service.shutdown();
        
    }
    
    static class Task implements Runnable {
        
        @Override
        
        public void run() {
            
            try {
                
                semaphore.acquire();
                
            } catch (InterruptedException e) {
                
                e.printStackTrace();
                
            }
            
            System.out.println(Thread.currentThread().getName() + "拿到了许可证，花费2秒执行慢服务");
            
            try {
                
                Thread.sleep(2000);
                
            } catch (InterruptedException e) {
                
                e.printStackTrace();
                
            }
            
            System.out.println("慢服务执行完毕，" + Thread.currentThread().getName() + "释放了许可证");
            
            semaphore.release();
            
        }
        
    }
    
}
