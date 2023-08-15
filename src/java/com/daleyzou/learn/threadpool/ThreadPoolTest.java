package com.daleyzou.learn.threadpool;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * ThreadPoolTest
 *
 * @author daleyzou
 * @version 1.1.1
 * @description 线程池测试
 * @date 2023年08月15日 16:37
 */
public class ThreadPoolTest {
    public static ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(Runtime.getRuntime().availableProcessors(),
            Runtime.getRuntime().availableProcessors() * 2, 60, TimeUnit.SECONDS,
            new LinkedBlockingDeque<>(100), new CustomThreadFactory("test"), new MyPolicy("test"));
    
    static {
        threadPoolExecutor.allowCoreThreadTimeOut(true);
    }
    
    public static void main(String[] args) {
    
    
    }
}
