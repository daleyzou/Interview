package com.daleyzou.CodeOffer;

import java.util.ArrayList;
import java.util.List;

/**
 * d33_GetUglyNumber
 * @description 把只包含质因子2、3和5的数称作丑数（Ugly Number）。
 * 例如6、8都是丑数，但14不是，因为它包含质因子7。 习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
 * @author daleyzou
 * @date 2020年02月10日 23:52
 * @version 3.2.0
 */
public class d33_GetUglyNumber {
    public int GetUglyNumber_Solution_1(int index) {
        if (index <= 0) {
            return 0;
        }
        return solution1(index);
    }

    public int GetUglyNumber_Solution(int index) {
        List<Integer> resultList = new ArrayList<>();
        resultList.add(1);
        int i2 = 0, i3 = 0, i5 = 0;
        while (resultList.size() < index) {
            int num2 = resultList.get(i2) * 2;
            int num3 = resultList.get(i3) * 3;
            int num5 = resultList.get(i5) * 5;
            int min = Math.min(num2, Math.min(num3, num5));
            if (min == num2) {
                i2++;
            }
            if (min == num3) {
                i3++;
            }
            if (min == num5) {
                i5++;
            }
            resultList.add(min);
        }
        return resultList.get(resultList.size() - 1);
    }

    private int solution1(int index) {
        int num = 0;
        int count = 0;
        while (count < index) {
            num++;
            if (isAuly(num)) {
                count++;
            }
        }
        return num;
    }

    private boolean isAuly(int num) {
        int temp = num;
        while (temp % 2 == 0) {
            temp /= 2;
            if (temp == 1) {
                return true;
            }
        }
        while (temp % 3 == 0) {
            temp /= 3;
            if (temp == 1) {
                return true;
            }
        }
        while (temp % 5 == 0) {
            temp /= 5;
            if (temp == 1) {
                return true;
            }
        }
        return temp == 1;
    }

    public static void main(String[] args) {
        d33_GetUglyNumber object = new d33_GetUglyNumber();
        int i = object.GetUglyNumber_Solution(3);
        System.out.println(i);
    }

}
