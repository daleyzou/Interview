package com.daleyzou.interview;

/**
 * TestNums
 *
 * @author zoudaifa
 * @description TODO
 * @date 2022年02月11日 6:47 下午
 */
public class TestNums {
    // dp[m][n] = dp[m-1][n] + dp[m][n-1]
    // dp[0][n] = 1;
    // dp[m][0] = 1;

    int count = 0;
    int findK = 0;
    public int countKind(int m , int n, int k){
        findK = k;
        dp(m, n, 0, 0, 0);
        return count;
    }

    private void dp(int m, int n, int i, int j, int index) {
        if(index > findK || i > m-1 || j > n-1){
            return ;
        }
        if(index == findK){
            if(i == m-1 && j == n-1){
                count++;
            }
        }
        dp(m, n, i, j+1, index+1);
        dp(m, n, i, j-1, index+1);
        dp(m, n, i+1, j, index+1);
        dp(m, n, i, j-1, index+1);

    }

    public static void main(String[] args) {
        TestNums testNums = new TestNums();
        int i = testNums.countKind(2, 2, 3);
        System.out.println(i);
    }

}
