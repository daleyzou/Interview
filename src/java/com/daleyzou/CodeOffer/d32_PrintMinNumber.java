package com.daleyzou.CodeOffer;

import java.util.Comparator;

/**
 * d32_PrintMinNumber
 * @description 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，
 * 打印能拼接出的所有数字中最小的一个。例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
 *
 *
 * @author daleyzou
 * @date 2020年02月10日 23:01
 * @version 3.2.0
 */
public class d32_PrintMinNumber {
    public String PrintMinNumber(int [] numbers) {
        if (numbers == null || numbers.length < 1){
            return "";
        }
        quickSort(numbers, 0, numbers.length - 1, new StringComparator());
        StringBuilder sb = new StringBuilder();
        for (int number : numbers){
            sb.append(number);
        }
        return sb.toString();
    }

    private void quickSort(int[] numbers, int begin, int end, StringComparator stringComparator) {
        if (begin > end){
            return;
        }
        int i = begin;
        int j = end;
        int num = numbers[begin];
        while (i < j){
            while (i < j && stringComparator.compare(String.valueOf(num), String.valueOf(numbers[j])) < 0){
                j--;
            }
            if (i < j){
                numbers[i] = numbers[j];
                i++;
            }
            while (i < j && stringComparator.compare(String.valueOf(numbers[i]), String.valueOf(num)) < 0){
                i++;
            }
            if (i < j){
                numbers[j] = numbers[i];
                j--;
            }
        }
        numbers[i] = num;
        quickSort(numbers, begin, i - 1, stringComparator);
        quickSort(numbers, i + 1, end, stringComparator);
    }

    class StringComparator implements Comparator<String>{

        @Override
        public int compare(String o1, String o2) {
            return (o1+o2).compareTo(o2+o1);
        }
    }

    public static void main(String[] args){
        d32_PrintMinNumber object = new d32_PrintMinNumber();
        int[] numbers = new int[]{3,5,1,4,2};
        String s = object.PrintMinNumber(numbers);
        System.out.println(s);
    }
}
