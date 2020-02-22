package com.daleyzou.CodeOffer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * d45_isCon
 *  * @description 现在,要求你使用这幅牌模拟上面的过程,然后告诉我们LL的运气如何，
 *  * 如果牌能组成顺子就输出true，否则就输出false。为了方便起见,你可以认为大小王是0。
 * @author daleyzou
 * @date 2020年02月22日 17:26
 * @version 1.1.11
 */
public class d45_isContinuous {
    public boolean isContinuous(int [] numbers) {
        if (numbers == null || numbers.length <= 0){
            return false;
        }
       boolean result = true;
        Arrays.sort(numbers);
        int countZero = 0;
        for (int i = 0; i < numbers.length; i++){
            if (numbers[i] == 0){
                countZero++;
            }else {
                if (i > 0){
                    if (numbers[i - 1] != 0){
                        if (numbers[i] - numbers[i-1] > 1){
                            if (countZero > 0){
                                int discount = numbers[i] - numbers[i-1] - 1;
                                countZero -= discount;
                                if (countZero < 0){
                                    return false;
                                }
                            }else {
                                return false;
                            }
                        }
                        if (numbers[i] - numbers[i-1] < 1){
                            return false;
                        }
                    }
                }
            }

        }
       return result;
    }
}
