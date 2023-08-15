package com.daleyzou.learn.threadpool;

/**
 * CustomThreadFactory
 *
 * @author daleyzou
 * @version 1.1.1
 * @description TODO
 * @date 2023年08月15日 16:49
 */
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public class CustomThreadFactory implements ThreadFactory {
    private final AtomicInteger threadCount = new AtomicInteger(1);
    private final String threadNamePrefix;
    
    public CustomThreadFactory(String threadNamePrefix) {
        this.threadNamePrefix = threadNamePrefix;
    }
    
    @Override
    public Thread newThread(Runnable runnable) {
        String threadName = threadNamePrefix + "-" + threadCount.getAndIncrement();
        return new Thread(runnable, threadName);
    }
}

