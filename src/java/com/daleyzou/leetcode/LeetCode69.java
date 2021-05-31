package com.daleyzou.leetcode;

/**
 * LeetCode69
 *
 * @author zoudaifa
 * @description TODO
 * @date 2021年05月31日 5:15 下午
 */
public class LeetCode69 {
    public int mySqrt(int x) {
        return sqrtData(1, x, x);
    }

    private int sqrtData(int begin, int end, int originData) {
        if (begin >= end){
            return end;
        }
        int tempLocation = begin + (end - begin) / 2;
        long tempSqrt = (long)tempLocation * tempLocation;
        if (tempSqrt > originData){
            return sqrtData(begin, tempLocation - 1, originData);
        }else if (tempSqrt < originData){
            long nextSqrt = (long)(tempLocation + 1) * (tempLocation + 1);
            if (nextSqrt > originData){
                return tempLocation;
            }
            return sqrtData(tempLocation + 1, end, originData);
        }else {
            return tempLocation;
        }
    }

    public static void main(String[] args) {
        LeetCode69 test = new LeetCode69();

        int testData = 2147483647;
        int i = test.mySqrt(testData);
        System.out.println(i);

    }
}
