package com.daleyzou.learn.threadpool;

import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * MyPolicy
 *
 * @author daleyzou
 * @version 1.1.1
 * @description TODO
 * @date 2023年08月15日 16:51
 */

public class MyPolicy implements RejectedExecutionHandler {
    private final String threadName;
    
    public MyPolicy(String threadName) {
        this.threadName = threadName;
    }
    @Override
    public void rejectedExecution(final Runnable r, final ThreadPoolExecutor executor) {
        System.out.println("rejectedExecution, threadName:+" + threadName);
        if (!executor.isShutdown()) {
            System.out.println("rejectedExecution");
            r.run();
        }
    }
}
