package com.daleyzou.leetcode;

/**
 * @Author: DaleyZou
 * @Description:
 * @Date: Created in 7:04 2018/7/27
 * @Modified By:
 */
public class LeetCode11 {

    /**
     * @Description: 给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。
     * 在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，
     * 使得它们与 x 轴共同构成的容器可以容纳最多的水。
     * @auther: DaleyZou
     * @date: 7:08 2018/7/27
     * @param: height
     * @return: int
     */
    public int maxArea(int[] height) {
        int proportion = 0;
        for (int i = 0; i < height.length; i++){
            int width;
            int height1;
            for (int j = i + 1; j < height.length; j++){
                width = j - i;
                height1 = Math.min(height[i], height[j]);
                proportion = Math.max(proportion, width * height1);
            }
        }
        return proportion;
    }
    public static void main(String[] args){
        int[] sum = {1,8,6,2,5,4,8,3,7};
        LeetCode11 leetCode11 = new LeetCode11();

        System.out.println(leetCode11.maxArea(sum));
    }
}
