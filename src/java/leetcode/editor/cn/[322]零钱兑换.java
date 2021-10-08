package leetcode.editor.cn;//给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。
//
// 计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回 -1 。 
//
// 你可以认为每种硬币的数量是无限的。 
//
// 
//
// 示例 1： 
//
// 
//输入：coins = [1, 2, 5], amount = 11
//输出：3 
//解释：11 = 5 + 5 + 1 
//
// 示例 2： 
//
// 
//输入：coins = [2], amount = 3
//输出：-1 
//
// 示例 3： 
//
// 
//输入：coins = [1], amount = 0
//输出：0
// 
//
// 示例 4： 
//
// 
//输入：coins = [1], amount = 1
//输出：1
// 
//
// 示例 5： 
//
// 
//输入：coins = [1], amount = 2
//输出：2
// 
//
// 
//
// 提示： 
//
// 
// 1 <= coins.length <= 12 
// 1 <= coins[i] <= 231 - 1 
// 0 <= amount <= 104 
// 
// Related Topics 广度优先搜索 数组 动态规划 
// 👍 1517 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution322 {
    int[] table;
    public int coinChange(int[] coins, int amount) {
        // a = table[a-coins[i]] +1;
        if(amount == 0){
            return 0;
        }
        table = new int[coins.length];

        return calCoin(coins, amount);
    }


    public int calCoin(int[] coins, int amount) {
        int res = Integer.MAX_VALUE;
        if(amount == 0){
            return 0;
        }
        if(amount < 0){
            return -1;
        }

        for(int i = 0; i < coins.length; i++){
            int nextData =  calCoin(coins, amount-coins[i]);
            System.out.println("nextData: " + nextData + "  amount-coins[i]:  "  + (amount-coins[i]));
            if(nextData == -1){
                continue;
            }
            res = Math.min(res, nextData + 1);
        }

        if(res == Integer.MAX_VALUE){
            return -1;
        }else{
            return res;
        }
    }

    public static void main(String[] args) {
        Solution322 solution322 = new Solution322();
        int i = solution322.coinChange(new int[]{1,2, 5}, 26);
        System.out.println(i);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
