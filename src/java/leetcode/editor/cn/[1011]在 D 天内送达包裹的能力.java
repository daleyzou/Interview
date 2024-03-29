package leetcode.editor.cn;//传送带上的包裹必须在 D 天内从一个港口运送到另一个港口。
//
// 传送带上的第 i 个包裹的重量为 weights[i]。每一天，我们都会按给出重量的顺序往传送带上装载包裹。我们装载的重量不会超过船的最大运载重量。 
//
// 返回能在 D 天内将传送带上的所有包裹送达的船的最低运载能力。 
//
// 
//
// 示例 1： 
//
// 
//输入：weights = [1,2,3,4,5,6,7,8,9,10], D = 5
//输出：15
//解释：
//船舶最低载重 15 就能够在 5 天内送达所有包裹，如下所示：
//第 1 天：1, 2, 3, 4, 5
//第 2 天：6, 7
//第 3 天：8
//第 4 天：9
//第 5 天：10
//
//请注意，货物必须按照给定的顺序装运，因此使用载重能力为 14 的船舶并将包装分成 (2, 3, 4, 5), (1, 6, 7), (8), (9), (1
//0) 是不允许的。 
// 
//
// 示例 2： 
//
// 
//输入：weights = [3,2,2,4,1,4], D = 3
//输出：6
//解释：
//船舶最低载重 6 就能够在 3 天内送达所有包裹，如下所示：
//第 1 天：3, 2
//第 2 天：2, 4
//第 3 天：1, 4
// 
//
// 示例 3： 
//
// 
//输入：weights = [1,2,3,1,1], D = 4
//输出：3
//解释：
//第 1 天：1
//第 2 天：2
//第 3 天：3
//第 4 天：1, 1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= D <= weights.length <= 5 * 104 
// 1 <= weights[i] <= 500 
// 
// Related Topics 贪心 数组 二分查找 
// 👍 394 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution1011 {
    public int shipWithinDays(int[] weights, int days) {

        int min = getWeight(weights);
        int max = getSum(weights);
        while(min <= max){
            int mid = (min + max) / 2;
            if(isCanSpeed(weights, mid, days)){
                max = mid -1;
            }else{
                min = mid+1;
            }
        }
        return min;
    }

    public boolean isCanSpeed(int[] weights, int min, int days){
        int i = 0;
        int sum = 0;
        int count = 0;
        while(i < weights.length){
            if(sum + weights[i] < min){
                sum += weights[i];
                i++;
            }else if(sum + weights[i] == min){
                count ++;
                sum = 0;
                System.out.println("切割刀：i=" +i + " sum:" + sum + " mid:" + min);
                i++;
            }else{
                sum = weights[i];
                count++;
                System.out.println("切割刀：i=" +i + " sum:" + sum + " mid:" + min);
                i++;
            }

        }
        if(sum > 0){
            count++;
        }
        return count  <= days;
    }

    public int getSum(int[] weights){
        int sum = 0;
        for(int i = 0; i < weights.length; i++){
            sum += weights[i];
        }
        return sum;
    }

    public int getWeight(int[] weights){
        int max = weights[0];
        for(int i = 0; i < weights.length; i++){
            if(weights[i] > max){
                max = weights[i];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Solution1011 solution1011 = new Solution1011();
        int i = solution1011.shipWithinDays(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 5);
        System.out.println(i);

        System.out.println(solution1011.isCanSpeed(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 12,5));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
