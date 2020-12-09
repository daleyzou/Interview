package com.interview.demo.duxiaoman;

/**
 * Demo
 * @description TODO
 * @author daleyzou
 * @date 2020年12月08日 10:27
 * @version 1.1.1
 */
public class Demo {
    private volatile Demo demo;
    public  Demo get(){
        if (demo == null){
            synchronized (Demo.class){
                if (demo == null){
                    demo = new Demo();
                }
            }
        }
        return demo;
    }
}
