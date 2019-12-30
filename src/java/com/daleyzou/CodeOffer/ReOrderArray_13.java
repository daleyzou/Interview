/**
 * @projectName Interview
 * @package com.daleyzou.CodeOffer
 * @className com.daleyzou.CodeOffer.ReOrderArray_13
 * @copyright Copyright 2019 daleyzou, Inc. All rights reserved.
 */
package com.daleyzou.CodeOffer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * ReOrderArray_13
 * @description TODO
 * @author daleyzou
 * @date 2019年12月30日 22:58
 * @version 1.0.0
 */
public class ReOrderArray_13 {
    public void reOrderArray(int [] array) {
        // 奇数
        StringBuilder odd = new StringBuilder();
        List<Integer> oddList = new ArrayList<>();
        // 偶数
        StringBuilder even = new StringBuilder();
        List<Integer> evenList = new ArrayList<>();
        for (int num : array){
            if ((num & 1) == 1){
                odd.append(num);
                oddList.add(num);
            }else {
                even.append(num);
                evenList.add(num);
            }
        }
        List<Integer> result = new ArrayList<>();
        result.addAll(oddList);
        result.addAll(evenList);
        for (int i = 0; i < result.size(); i++){
            array[i] = result.get(i);
        }
    }
}
