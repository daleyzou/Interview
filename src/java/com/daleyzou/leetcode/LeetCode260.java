package com.daleyzou.leetcode;

import java.util.Arrays;

/**
 * LeetCode260
 * @description 只出现一次的数字
 * @author daleyzou
 * @date 2020年11月30日 23:29
 * @version 1.1.1
 */
public class LeetCode260 {
    public int[] singleNumber(int[] nums) {
        int bitMask = 0;
        for (int num : nums) {
            bitMask = (bitMask ^ num);
        }
        int diff = bitMask & (-bitMask);
        int x = 0;
        for (int num : nums) {
            if ((num & diff) != 0){
                x = x ^ num;
            }
        }
        return new int[]{x, x ^ bitMask};
    }

    public int[] singleNumber1(int[] nums) {
        // difference between two numbers (x and y) which were seen only once
        int bitmask = 0;
        for (int num : nums) bitmask ^= num;

        // rightmost 1-bit diff between x and y
        int diff = bitmask & (-bitmask);

        int x = 0;
        // bitmask which will contain only x
        for (int num : nums) if ((num & diff) != 0) x ^= num;

        return new int[]{x, bitmask^x};
    }

    public static void main(String[] args){
        LeetCode260 leetCode260 = new LeetCode260();
        int[] ints = leetCode260.singleNumber(new int[] { 3, 3, 4, 4, 5, 6 });
        System.out.println(Arrays.toString(ints));
    }
}
