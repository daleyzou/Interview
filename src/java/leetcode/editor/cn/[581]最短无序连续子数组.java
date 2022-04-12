package leetcode.editor.cn;//给你一个整数数组 nums ，你需要找出一个 连续子数组 ，如果对这个子数组进行升序排序，那么整个数组都会变为升序排序。
//
// 请你找出符合题意的 最短 子数组，并输出它的长度。 
//
// 
//
// 
// 
// 示例 1： 
//
// 
//输入：nums = [2,6,4,8,10,9,15]
//输出：5
//解释：你只需要对 [6, 4, 8, 10, 9] 进行升序排序，那么整个表都会变为升序排序。
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3,4]
//输出：0
// 
//
// 示例 3： 
//
// 
//输入：nums = [1]
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 104 
// -105 <= nums[i] <= 105 
// 
//
// 
//
// 进阶：你可以设计一个时间复杂度为 O(n) 的解决方案吗？ 
// 
// 
// Related Topics 栈 贪心 数组 双指针 排序 单调栈 
// 👍 818 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int n = nums.length;

        int begin = 0;
        int end = -1;
        int max = nums[n-1];
        int min = nums[0];
        for(int i = 0; i < n; i++){
            if(nums[i] >= max){
                max = nums[i];
            }else{
                end = i;
            }

            if(nums[n-i-1] <= min){
                min = nums[n-i-1];
            }else{
                begin = n-i-1;
            }
        }
        return end - begin + 1;
    }

    public int findLeft(int[] nums){
        int n = nums.length;
        int right = -1;
        int min = nums[n-1];

        for(int i = 0; i < n; i++){
            if(nums[i] > min){
                right = i;
            }else{
                min = nums[i];
            }
        }
        System.out.println(right);
        return right;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int unsortedSubarray = solution.findUnsortedSubarray(new int[] { 1, 2, 3, 4 });
        System.out.println(unsortedSubarray);

        System.out.println(solution.findLeft(new int[]{1,2,3,4}));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
