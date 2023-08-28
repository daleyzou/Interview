package com.daleyzou.learn;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.TreeMap;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: DaleyZou
 * @Description:
 * @Date: Created in 19:55 2018/8/5
 * @Modified By:
 */
public class Test {
    public static void main(String[] args) {
        String a=new String("A");
        String b= "B";
        oper(a,b);
        System.out.println(a+","+b);

        String a1 = new String("A");
        String b1 = new String("B");
        a1.concat("aa");
        System.out.println(a1 + "," + b1);

        int[] as = new int[]{3,2,1};
        Arrays.sort(as);

        // 查看哈希值源码
        System.out.println("哈希值：" + a1.hashCode());

        TreeMap<String, String> treeMap = new TreeMap<>();
        int i = 'a';
        System.out.println(i);
        HashMap<String, String> map = new HashMap<>(16);
        Hashtable<String, String> hashtable = new Hashtable<>();
        System.out.println(hashtable.size());
    }
    static void oper(String c,String d){
        c.concat("B");
        d=c;
    }

    public synchronized void test() throws InterruptedException {
        ReentrantLock lock = new ReentrantLock();
        Condition notEmpty = lock.newCondition();
        lock.lock();
        lock.lockInterruptibly();
        try {
            notEmpty.await();

            notEmpty.signal();
        }finally {
            lock.unlock();
        }

    }

}
