package java.com.daleyzou.CodeOffer;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * d40_FindNumsAppearOnce
 * @description 一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。
 * @author daleyzou
 * @date 2020年02月18日 23:19
 * @version 1.1.11
 */
public class d40_FindNumsAppearOnce {
    //num1,num2分别为长度为1的数组。传出参数
    //将num1[0],num2[0]设置为返回结果
    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        Map<Integer, Integer> map = new HashMap<>(array.length);
        for (int i = 0;i < array.length; i++){
            Integer defaultValue = map.getOrDefault(array[i], 0);
            defaultValue = defaultValue + 1;
            if (defaultValue == 2){
                map.remove(array[i]);
            }else {

                map.put(array[i], defaultValue );
            }
        }
        int count = 0;
        List<Integer> collect1 = map.keySet().stream().collect(Collectors.toList());
        num1[0] = collect1.get(0);
        num2[0] = collect1.get(1);
    }
}
