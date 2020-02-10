package com.daleyzou.CodeOffer;

/**
 * d31_NumberOf1Between1AndN
 * @description
 * 求出1~13的整数中1出现的次数,并算出100~1300的整数中1出现的次数？
 * 为此他特别数了一下1~13中包含1的数字有1、10、11、12、13因此共出现6次,但是对于后面问题他就没辙了。
 * ACMer希望你们帮帮他,并把问题更加普遍化,可以很快的求出任意非负整数区间中1出现的次数（从1 到 n 中1出现的次数）
 *
 * https://blog.csdn.net/yi_Afly/article/details/52012593
 *
 *round  weight   former  base
 * 5     3        4
 * 如果 weight = 0，count=round*base
 * 如果 weight=1,count=round*base+1+former
 * 如果weight>1,count=round*base+base
 *
 *
 * @author daleyzou
 * @date 2020年02月06日 20:56
 * @version 3.2.0
 */
public class d31_NumberOf1Between1AndN {
    public int NumberOf1Between1AndN_Solution(int n) {
        int count = 0;
        int base = 1;
        int round = n;
        while (round > 0) {
            int weight = round % 10;
            round = round / 10;
            count += round * base;
            if (weight > 0) {
                if (weight == 1) {
                    count += n % base + 1;
                } else {
                    count += base;
                }
            }
            base *= 10;
        }

        return count;
    }
}
