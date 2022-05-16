package com.daleyzou.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * TestSomthing
 * @description TODO
 * @author daleyzou
 * @date 2022年04月24日 13:03
 * @version 1.1.1
 */
public class TestSomthing {
    public List<Integer> findCol(List<Integer> col1, List<Integer> col2){
        // 考虑存放 两个list 中数据量较小的
        HashSet<Integer> setData = new HashSet<>(col1.size() * 2);
        List<Integer> resultList = new ArrayList<>(col1.size());
        for (Integer integer : col1) {
            setData.add(integer);
        }
        for (Integer integer : col2) {
            if(setData.contains(integer)){
                resultList.add(integer);
            }
        }
        return resultList;
    }
    public List<Integer> findCol2(List<Integer> col1, List<Integer> col2){
        // 数据库查询时排序， 求两个有序数组的交集
        List<Integer> resultList = new ArrayList<>(col1.size());
        int begin1 = 0;
        int begin2 = 0;
        while (begin1 < col1.size() && begin2 < col2.size()){
            if(col1.get(begin1).equals(col2.get(begin2))){
                resultList.add(col1.get(begin1));
                begin1++;
                begin2++;
            }else if (col1.get(begin1) < col2.get(begin2)){
                begin1++;
            }else {
                begin2++;
            }
        }
        return resultList;
    }
}
