package com.daleyzou.CodeOffer;

/**
 * @Author: DaleyZou
 * @Description: 二维数组中的查找
 * 在一个二维数组中（每个一维数组的长度相同），
 * 每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 * @Date: Created in 23:38 2019/1/17
 * @Modified By:
 */
public class FindNumber {

    /**
     * @Description: 二维数组中的查找
     * @date: 23:46 2019/1/17
     * @param: target
     * @param: array
     * @return: boolean
     */
    public boolean Find(int target, int [][] array) {
        if (array.length < 1){
            return false;
        }
        if (array[0].length < 1){
            return false;
        }
        int begin = array[0][0];
        int end = array[array.length - 1][array[0].length - 1];
        if (target > end){
            return false;
        }

        for (int i = 0; i < array.length; i++){
            if (target > array[i][array[0].length - 1]){
                continue;
            }
            for (int j = 0; j < array[0].length; j++){
                if (target == array[i][j]){
                    return true;
                }
            }
        }
        return false;
    }


    public static void main(String[] args){
        System.out.println("hello ");
    }
}
