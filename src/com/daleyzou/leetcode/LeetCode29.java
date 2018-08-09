package com.daleyzou.leetcode;

/**
 * @Author: DaleyZou
 * @Description:
 * @Date: Created in 15:38 2018-8-8
 * @Modified By:
 */
public class LeetCode29 {
    public int divide1(int dividend, int divisor) {    // 方法超时

        if (dividend == divisor){
            return 1;
        }
        boolean single = false;
        if ((dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0)){
            single = true;
        }
        if (divisor == 1){
            return dividend;
        }
        if (divisor == -1){
            if (dividend == Integer.MIN_VALUE){
                return Integer.MAX_VALUE;
            }else {
                return 0 - dividend;
            }
        }
        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);
        if (dividend == Integer.MIN_VALUE){
            dividend = Integer.MAX_VALUE;
        }
        int result = 0;
        int temp = divisor;
        while (divisor < dividend){
            if (temp > 0){
                if (Integer.MAX_VALUE - divisor < temp){
                    result++;
                    break;
                }
            }
            if (temp < 0){
                if (Integer.MIN_VALUE - divisor > temp){
                    result--;
                    break;
                }
            }
            divisor += temp;
            if (single){
                result--;
            }else {
                result++;
            }
        }
        return result;
    }

    /**
     * @Description:
     * 算法思想：
     * 例如：9 = 2^3 + 2^0
     *例如29除以8，8扩大二倍，16小于29，再扩大二倍，
     * 超过29，于是29减去之前的16，返回值加上2。
     * 第二次循环时因为此时的13小于8的二倍，故加上1，整个循环结束，最终结果为2+1=3，很明显符合
     * @auther: DaleyZou
     * @date: 10:05 2018-8-9
     * @param: dividend
     * @param: divisor
     * @return: int
     */
    public int divide(int dividend, int divisor) {
        if (divisor == 0 || (dividend == Integer.MIN_VALUE && divisor == -1)){
            return Integer.MAX_VALUE;
        }
        int single = (dividend < 0) ^ (divisor < 0) ? -1 : 1;  // 通过异或得到符号
        long did = Math.abs((long)dividend);  // 得到正值
        long dis = Math.abs((long)divisor);   // 得到正值

        long temp = dis;   // 记录除数的值
        int result = 0;
        while(did >= dis){
            int count = 1;
            while (did > (dis <<1)){
                dis <<= 1;
                count <<= 1;
            }
            did -= dis;
            result += count;
            dis = temp;       // 将dis（除数）置初值
        }
        return  result * single;
    }

    // 参考链接：https://www.nowcoder.com/discuss/87221?type=0&order=0&pos=6&page=0

    public static void main(String[] args){
        LeetCode29 leetCode29 = new LeetCode29();
       int result = leetCode29.divide(-2147483648,2);
       System.out.println(result);

        System.out.println(Integer.MAX_VALUE);
    }
}
