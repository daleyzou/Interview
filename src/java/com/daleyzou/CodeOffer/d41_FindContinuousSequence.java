package com.daleyzou.CodeOffer;

import java.util.ArrayList;

/**
 * d41_FindContinuousSequence
 * @description 小明很喜欢数学,有一天他在做数学作业时,要求计算出9~16的和,他马上就写出了正确答案是100。
 * 但是他并不满足于此,他在想究竟有多少种连续的正数序列的和为100(至少包括两个数)。
 * 没多久,他就得到另一组连续正数和为100的序列:18,19,20,21,22。
 * 现在把问题交给你,你能不能也很快的找出所有和为S的连续正数序列? Good Luck!
 * @author daleyzou
 * @date 2020年02月19日 23:19
 * @version 1.1.11
 */
public class d41_FindContinuousSequence {
    int tempSum;
    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> resultList = new ArrayList<>();
        ArrayList<Integer> item = new ArrayList<>();
        tempSum = sum;
        findSeries(1, sum, item, resultList);
        return resultList;
    }

    private void findSeries(int i, int sum, ArrayList<Integer> item, ArrayList<ArrayList<Integer>> resultList) {
        if (i > sum){
            if (item.size() < 1){
                return;
            }
            Integer integer = item.get(0);
            item.remove(0);
            findSeries(i, sum + integer, item, resultList);
        }
        System.out.println("value:" + sum);
        System.out.println(item.toString());
        if (i < sum){
            item.add(i);
            findSeries(i + 1, sum - i, item, resultList);
        }
        if (item.size() < 1){
            return;
        }
        if (item.get(item.size() - 1) > tempSum / 2 + 1){
            return;
        }
        if (i == sum){
            item.add(i);
            ArrayList<Integer> tempList = new ArrayList<>(item);
            resultList.add(tempList);
            Integer temp = item.get(1);
            item.clear();
            item.add(temp);
            findSeries(temp +1, tempSum-temp, item, resultList);
        }
    }

    public static void main(String[] args){
        d41_FindContinuousSequence object = new d41_FindContinuousSequence();
        ArrayList<ArrayList<Integer>> arrayLists = object.FindContinuousSequence(100);
        System.out.println("结果如下：");
        arrayLists.stream().forEach(item->{
            System.out.println(item.toString());
        });
    }
}
