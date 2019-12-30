/**
 * @projectName Interview
 * @package com.daleyzou.CodeOffer
 * @className com.daleyzou.CodeOffer.Power_12
 * @copyright Copyright 2019 daleyzou, Inc. All rights reserved.
 */
package com.daleyzou.CodeOffer;

/**
 * Power_12
 * @description TODO
 *
 * https://blog.csdn.net/jsqfengbao/article/details/47164537
 *
 * https://blog.csdn.net/wcxiaoych/article/details/42806313
 *
 * @author daleyzou
 * @date 2019年12月30日 21:39
 * @version 1.0.0
 */
public class Power_12 {
    public double Power(double base, int exponent) {
        double result = 1;
        int temp = exponent;
        exponent = Math.abs(exponent);
        Double zero = 0.0;
        if (zero.equals(base)) {
            return 0;
        }
        if (exponent == 0) {
            return 1;
        }
        while (exponent > 0) {
            result *= base;
            exponent--;
        }

        if (temp > 0) {
            return result;
        } else {
            return 1 / result;
        }
    }

    public double Power_2(double base, int exponent) {
        if (exponent == 0){
            return 1;
        }
        if (exponent == 1){
            return base;
        }
        if (exponent == -1){
            return 1 / base;
        }
        double result = Power_2(base, exponent >>1);
        result *= result;
        if ((exponent & 1) != 0){
            result *= base;
        }
        return result;
    }

    public static void main(String[] args) {
        Power_12 object = new Power_12();
        double power = object.Power_2(2, -3);
        System.out.println(power);

        System.out.println("++++++++++++++++++++++++++=");
        Double d = 0.0;
        System.out.println(d.equals(-0.0));
        System.out.println(d == -0.0);
        System.out.println(0.1d == 0.1f);
    }

}
