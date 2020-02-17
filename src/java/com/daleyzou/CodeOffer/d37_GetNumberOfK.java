package com.daleyzou.CodeOffer;

/**
 * d37_GetNumberOfK
 * @description 统计一个数字在排序数组中出现的次数。
 * @author zoudaifa
 * @date 2020年02月17日 22:52
 * @version 1.1.11
 */
public class d37_GetNumberOfK {
    int result = 0;
    public int GetNumberOfK(int [] array , int k) {
        if (array == null || array.length == 0 ||k < array[0] || k > array[array.length - 1]){
            return 0;
        }
        getNum(array, 0, array.length - 1, k);
        return result;
    }

    private void getNum(int[] array, int begin, int end, int k) {
        if (begin > end){
            return;
        }
        int i = begin;
        int j = end;
        int middle = (begin + end) / 2;
        if (k > array[middle]){
            getNum(array, middle + 1, end, k);
        }else if (k < array[middle]){
            getNum(array, begin, middle - 1, k);
        }else {
            result++;
            int temp = middle;
            while (temp > begin && array[temp - 1]==array[temp]){
                result++;
                temp--;
            }
            temp = middle;
            while (temp < end && array[temp + 1]==array[temp]){
                result++;
                temp++;
            }
        }
    }

    public static void main(String[] args){
        d37_GetNumberOfK object = new d37_GetNumberOfK();
        int[] numbers = new int[]{1,2,2,3};
        int k = 2;
        int i = object.GetNumberOfK(numbers, k);
        System.out.println(i);
    }
}
