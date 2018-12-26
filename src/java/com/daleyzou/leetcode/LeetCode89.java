package com.daleyzou.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: DaleyZou
 * @Description: 89. 格雷编码
 * @Date: Created in 17:47 2018/12/26
 * @Modified By:
 */
public class LeetCode89 {


    /**
     生成长度为n的格雷码可以分为下面的步骤：

     1、判断n的值，如果是0直接返回，如果是1直接执行第3步立即返回（这一步是递归出口）

     2、生成长度为n-1的格雷码，将生成的数字依次插入list（这一步需要递归调用本步骤）

     3、让右数第n位数字为1，即将当前数字异或上2的n-1次方，将这个数插入list

     4、保证最左侧数字为1，再次生成长度n-1的格雷码，将生成的数字依次插入list（这一步需要递归调用本步骤）

     需要注意的是，每次生成的格雷码，都会用作下一个格雷码的输入
     * */


    //临时存储当前数字
    int numCurr = 0;

    //输出数组
    ArrayList<Integer> arrayList;

    /**
     * 生成格雷码序列
     * @param n 格雷码位数
     * @return
     */
    public List<Integer> grayCode(int n) {

        if (n < 0) {
            return null;
        }

        arrayList = new ArrayList<Integer>();

        //任何位数的格雷码第一个数字都是0
        numCurr = 0;
        arrayList.add(numCurr);

        //递归生成格雷码放入arrayList
        getGrayCode(n);

        return arrayList;
    }

    /**
     * 递归将格雷码放入到arrayList中
     * @param n 格雷码位数
     */
    private void getGrayCode(int n) {
        if (n == 0) {
            return;
        }

        if (n == 1) {
            numCurr = numCurr ^ 1;
            arrayList.add(numCurr);
        } else {
            getGrayCode(n - 1);
            numCurr = numCurr ^ (1 << n - 1);
            arrayList.add(numCurr);
            getGrayCode(n - 1);
        }

    }

    public static void main(String[] args){
        LeetCode89 leetCode89 = new LeetCode89();
        leetCode89.grayCode(2);

    }
}
