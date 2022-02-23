package com.daleyzou.learn.justdo;

import java.util.ArrayList;
import java.util.List;

/**
 * NumsBackPrint
 * 二位数组的回形状遍历
 * 1 2 3
 * 4 5 6
 * 7 8 9
 *
 * 1 2 3 4
 * 5 6 7 8
 * 9 10 11 12
 * 13 14 15 16
 * @author daleyzou
 * @description NumsBackPrint
 * @date 2022年02月23日 3:18 下午
 */
public class NumsBackPrint {

    public static void main(String[] args) {
        int[][] nums = new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12}, {13,14,15,16}};

        int m = nums.length;
        int n = nums[0].length;

        int iBegin = 0;
        int iEnd = m-1;
        int jBegin = 0;
        int jEnd = n-1;
        List<Integer> list = new ArrayList<>();
        while(iBegin <= iEnd && jBegin <= jEnd){
            int temp = jBegin;
            while(temp <= jEnd){
                list.add(nums[iBegin][temp]);
                temp++;
            }
            temp = iBegin+1;
            while(temp < iEnd){
                list.add(nums[temp][jEnd]);
                temp++;
            }
            temp = jEnd;
            while(temp >= jBegin && iBegin != iEnd){
                list.add(nums[iEnd][temp]);
                temp--;
            }
            temp = iEnd-1;
            while(temp > iBegin && jBegin != jEnd){
                list.add(nums[temp][jBegin]);
                temp--;
            }

            iBegin++;
            iEnd--;
            jBegin++;
            jEnd--;
        }

        System.out.println(list.toString());
    }
}
