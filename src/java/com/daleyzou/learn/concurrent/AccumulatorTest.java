package com.daleyzou.learn.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.LongAccumulator;
import java.util.stream.IntStream;

/**
 * AccumulatorTest
 *
 * @author daleyzou
 * @version 1.1.1
 * @description TODO
 * @date 2023年08月28日 16:01
 */
public class AccumulatorTest {
    public static void main(String[] args) throws InterruptedException {
        LongAccumulator accumulator = new LongAccumulator((x, y) -> x + y, 0);
        
        ExecutorService executor = Executors.newFixedThreadPool(8);
        
        IntStream.range(1, 10).forEach(i -> executor.submit(() -> accumulator.accumulate(i)));
        
        Thread.sleep(2000);
        
        System.out.println(accumulator.getThenReset());
    }
}
