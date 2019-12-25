/**
 * @projectName Interview
 * @package com.daleyzou.CodeOffer
 * @className com.daleyzou.CodeOffer.RectangularCover_10
 * @copyright Copyright 2019 daleyzou, Inc. All rights reserved.
 */
package com.daleyzou.CodeOffer;

/**
 * RectangularCover_10
 * @description 矩形覆盖
 * @author daleyzou
 * @date 2019年12月25日 22:11
 * @version 1.0.0
 */
public class RectangularCover_10 {
    public int RectCover(int target) {
        if (target < 3){
            return target;
        }
        int[] result = new int[target];
        result[0] = 1;
        result[1] = 2;
        for (int i = 2; i < target; i++){
            result[i] = result[i - 1] + result[i-2];
        }
        return result[target - 1];
    }
}
