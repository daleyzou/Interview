package com.daleyzou.learn.thread;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * ThreadLocalDemo06
 *
 * @author daleyzou
 * @version 1.1.1
 * @description TODO
 * @date 2023年08月28日 16:30
 */
public class ThreadLocalDemo06 {
    
    public static ExecutorService threadPool = Executors.newFixedThreadPool(16);
    
    public static void main(String[] args) throws InterruptedException {
        
        for (int i = 0; i < 1000; i++) {
            
            int finalI = i;
            
            threadPool.submit(new Runnable() {
                
                @Override
                
                public void run() {
                    
                    String date = new ThreadLocalDemo06().date(finalI);
                    
                    System.out.println(date);
                    
                }
                
            });
            
        }
        
        threadPool.shutdown();
        
    }
    
    public String date(int seconds) {
        
        Date date = new Date(1000 * seconds);
        
        SimpleDateFormat dateFormat = ThreadSafeFormatter.dateFormatThreadLocal.get();
        ThreadSafeFormatter.dateFormatThreadLocal.remove();
        return dateFormat.format(date);
        
    }
    
    static class ThreadSafeFormatter {
        
        public static ThreadLocal<SimpleDateFormat> dateFormatThreadLocal = new ThreadLocal<SimpleDateFormat>() {
            
            @Override
            
            protected SimpleDateFormat initialValue() {
                
                return new SimpleDateFormat("mm:ss");
                
            }
            
        };
        
    }
    
}


