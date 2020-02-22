package com.daleyzou.CodeOffer;

import sun.awt.image.ImageWatched;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * d46_LastRemaining
 * @description 圆圈中最后剩下的数字
 * @author daleyzou
 * @date 2020年02月22日 22:06
 * @version 1.1.11
 */
public class d46_LastRemaining {
    public int LastRemaining_Solution(int n, int m) {
        if (n<=0 || m<=0){
            return -1;
        }
        LinkedList<Integer> linkedList = new LinkedList<>();
        for (int i = 0; i < n; i++){
            linkedList.add(i);
        }
        int count = 0;
        while (linkedList.size() > 1){
            for (int i = 1; i<m;i++){
                count++;
                count = count % linkedList.size();
            }
            linkedList.remove(count);
        }
        return linkedList.get(0);
    }

    public static void main(String[] args){
        d46_LastRemaining object = new d46_LastRemaining();
        int i = object.LastRemaining_Solution(5, 3);
        System.out.println(i);
    }
}
