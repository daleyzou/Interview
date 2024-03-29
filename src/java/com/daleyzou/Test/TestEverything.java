package com.daleyzou.Test;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import java.util.concurrent.*;
import java.util.concurrent.atomic.LongAdder;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * TestEverything
 *
 * @author zoudaifa
 * @description test
 * @date 2022年01月28日 12:04 下午
 */
public class TestEverything {

    public static void main(String[] args) throws InterruptedException {
        LinkedList<String> linkedList = new LinkedList<>();

        Stack<String> stack = new Stack<>();
        java.lang.String str = "123";
        for(int i = 0; i< 3; i++){
            stack.push(str.charAt(i)+"");
        }
        StringBuilder sb = new StringBuilder();


        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
        System.out.println(sb.toString());

        List<Integer> list = new ArrayList<>();
        list.stream();
        list.parallelStream();
        ArrayBlockingQueue<Integer> queue = new ArrayBlockingQueue<>(100);
        queue.drainTo(list, 100);

        LinkedHashMap<String, String> hashMap =new LinkedHashMap<>(10, 0.75f, true);

        HashMap<String, String> map = new HashMap<>(12);
        map.put("1", "1");
        ConcurrentHashMap<String, String> concurrentHashMap = new ConcurrentHashMap<>();

        LinkedBlockingDeque<String> deque = new LinkedBlockingDeque<>();
        deque.add("");


        ReentrantLock lock = new ReentrantLock();
        Condition condition = lock.newCondition();
        lock.lock();
        try {

        }finally {
            lock.unlock();
        }
        condition.await();
        condition.signal();

        LongAdder adder = new LongAdder();

        ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 5, 10, TimeUnit.MINUTES, new LinkedBlockingQueue<>(10));
        Thread thread = new Thread();
        thread.setUncaughtExceptionHandler((t, e)->{

        });
        Integer.parseInt("123");


    }
}
