package com.daleyzou.learn.Generic;

/**
 * @Author: DaleyZou
 * @Description: 测试我用 泛型构建的 工厂模式 是否成功
 * @Date: Created in 16:02 2018-9-19
 * @Modified By:
 */
public class TestPart {
    public static void main(String[] args){
        for (int i = 0; i < 10; i++){
            System.out.println(Part.createRandom());
        }
    }
}
