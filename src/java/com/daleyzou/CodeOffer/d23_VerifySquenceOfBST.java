package com.daleyzou.CodeOffer;

/**
 * d23_VerifySquenceOfBST
 * @description 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
 * 如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。

 * @author daleyzou
 * @date 2020年01月09日 22:08
 * @version 3.1.2
 */
public class d23_VerifySquenceOfBST {
    public boolean VerifySquenceOfBST(int[] sequence) {
        if (sequence == null || sequence.length < 1){
            return false;
        }
        boolean status = verify(sequence, 0, sequence.length - 1);
        return status;
    }

    private boolean verify(int[] sequence, int start, int end) {

        if (start >= end){
            return true;
        }
        int i = start;
        for (; i <= end; i++){
            if (sequence[i] >= sequence[end]){
                break;
            }
        }
        for (int j = i + 1; j < end; j++){
            if (sequence[j] < sequence[end]){
                return false;
            }
        }
        if (i >= end){
            return true;
        }
        return verify(sequence, start, i) && verify(sequence, i + 1, end);
    }

    public static void main(String[] args){
        d23_VerifySquenceOfBST object = new d23_VerifySquenceOfBST();
        int[] array = new int[]{1,2,3};
        boolean b = object.VerifySquenceOfBST(array);
        System.out.println(b);
    }
}
