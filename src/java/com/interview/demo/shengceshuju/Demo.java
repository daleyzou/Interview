package com.interview.demo.shengceshuju;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * Demo
 * @description TODO
 * @author daleyzou
 * @date 2020年12月07日 19:25
 * @version 1.1.1
 */
public class Demo {

    // 笔试题：已知两个有序数组 int[] A, int[] B，找出 A 和 B 的交集。
    public Set<Integer> find(int[] A, int[] B) {
        if (A.length == 0 || B.length == 0){
            return Collections.emptySet();
        }
        int numA = 0;
        int numB = 0;
        int resultSize = A.length > B.length ? A.length : B.length;
        Set<Integer> result = new HashSet<>(resultSize);
        while (numA < A.length && numB < B.length) {
            if (A[numA] == B[numB]) {
                result.add(A[numA]);
                numA++;
                numB++;
            } else if (A[numA] < B[numB]) {
                numA++;
            } else {
                numB++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] a = new int[] { 1, 2, 3 };
        int[] b = new int[] { 3, 5, 6 };
        Demo demo = new Demo();
        Set<Integer> integers = demo.find(a, b);
        System.out.println(integers.toString());
    }
}
