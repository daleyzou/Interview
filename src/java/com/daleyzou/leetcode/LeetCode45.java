package com.daleyzou.leetcode;

import com.sun.org.apache.xerces.internal.impl.dv.dtd.NMTOKENDatatypeValidator;

/**
 * Created by Administrator on 2018/8/27 0027.
 */
public class LeetCode45 {
    public int jump(int[] nums) {   // 方法一
        int times = 0;      // 跳的次数
        int max = 0;        // 在当前节点再跳一次所能达到的最远距离
        int reached = 0;    // 当前所能够到达的最远节点

        for (int i = 0; i < nums.length; i++){
            if (reached < i){
                times++;
                reached = max;
            }
            max = Math.max(max, i + nums[i]);
        }

        return times;
    }

    public int jump_method2(int[] nums) {   // 方法二
        int max = 0; // 记录当前节点能跳到的最远处再跳一次所能达到的最远距离
        int i = 0; // 当前的节点
        int times = 0; // 记录次数
        int index = 0;

        if (nums.length <= 1){
            return 0;
        }
        while (i < nums.length){
            if (i + nums[i] >= nums.length - 1){
                times++;
                break;
            }
            max = 0;
            index = i + 1;
            for (int j = i + 1; j - i <= nums[i];j++){
                if (nums[j] + j - i > max){
                    max = nums[j] + j - i;
                    index = j;
                }
            }
            i = index;
            times++;
        }

        return times;
    }
}
