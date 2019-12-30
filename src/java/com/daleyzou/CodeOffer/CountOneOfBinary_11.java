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
        char[] chars = binaryString.toCharArray();
        int result = 0;
        for (char ch : chars){
            if (ch == '1'){
                result++;
            }
        }
        return result;
    }

    public int getByMyself(int n){
        int result = 0;

        return result;
    }

    final static char[] digits = {
            '0' , '1' , '2' , '3' , '4' , '5' ,
            '6' , '7' , '8' , '9' , 'a' , 'b' ,
            'c' , 'd' , 'e' , 'f' , 'g' , 'h' ,
            'i' , 'j' , 'k' , 'l' , 'm' , 'n' ,
            'o' , 'p' , 'q' , 'r' , 's' , 't' ,
            'u' , 'v' , 'w' , 'x' , 'y' , 'z'
    };

    public static void main(String[] args){

        int val = 98;
        CountOneOfBinary_11 object = new CountOneOfBinary_11();
        object.NumberOf1(val);

        for (int i  = 0; i < 100; i++){
            System.out.println(i + " : " + (i & 1));
        }



        System.out.println("==============================================================");
        int shift = 1;
        int radix = 1 << shift;
        int mask = radix - 1;
        int offset = 0;
        int mag = Integer.SIZE - Integer.numberOfLeadingZeros(val);
        int chars = Math.max(((mag + (shift - 1)) / shift), 1);
        int charPos = chars;
        char[] buf = new char[chars];
        do {
            System.out.println("val & mask : " + (val & mask));
            buf[offset + --charPos] = digits[val & mask];
            System.out.println(buf);
            val >>>= shift;
            System.out.println("val: " + val);
        } while (val != 0 && charPos > 0);
        System.out.println(buf);
    }
}
