/**
 * @projectName Interview
 * @package com.daleyzou.CodeOffer
 * @className com.daleyzou.CodeOffer.CountOneOfBinary_11
 * @copyright Copyright 2019 daleyzou, Inc. All rights reserved.
 */
package com.daleyzou.CodeOffer;

/**
 * CountOneOfBinary_11
 * @description 二进制中1的个数
 * @author daleyzou
 * @date 2019年12月25日 23:36
 * @version 1.0.0
 */
public class CountOneOfBinary_11 {
    public int NumberOf1(int n) {
        String binaryString = Integer.toBinaryString(n);
        System.out.println(binaryString);
        return 0;
    }

    public static void main(String[] args){
        CountOneOfBinary_11 object = new CountOneOfBinary_11();
        object.NumberOf1(-2);
    }
}
