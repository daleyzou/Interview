package com.daleyzou.learn.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author: DaleyZou
 * @Description: 用于学习 java8的新特性 lambda表达式
 * @Date: Created in 9:30 2018-9-20
 * @Modified By:
 */
public class SimpleLambda {

    public static void main(String[] args){
        List<String> list = new ArrayList<String>();
        list.add("my");
        list.add("name");
        list.add("is");
        list.add("daleyzou");
        List<Integer> listInteger = new ArrayList<Integer>();
        listInteger.add(5);
        listInteger.add(4);
        listInteger.add(3);
        listInteger.add(2);
        listInteger.add(1);

        Arrays.asList(list).stream().forEach(System.out::println);
        System.out.println("-----------------------------");
        Arrays.asList(list).stream().forEach(e-> System.out.println(e));


        // 实现一个线程
        Thread thread = new Thread(()-> System.out.println("this is my thread!"));
        thread.start();

        // 通过过滤创建一个String列表
        List<String> strList = new ArrayList<String>();
        strList.add("aa");
        strList.add("bbb");
        strList.add("cccc");
        strList.add("ddddd");
        strList.add("eeeeee");
        List<String> filterList = strList.stream().filter(e -> e.length() > 2).collect(Collectors.toList());
        System.out.printf("original list: %s , filtered list: %s", strList, filterList);

        // 对列表的每个元素应用函数
        List<String> G7 = Arrays.asList("USA", "Japan", "France", "Germany", "Italy", "U.K.","Canada");
        String G7Countries = G7.stream().map(x -> x.toUpperCase()).collect(Collectors.joining(", "));
        System.out.println(G7Countries);
    }

}
