package leetcode.editor.cn;//给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,1,2]
//输出：
//[[1,1,2],
// [1,2,1],
// [2,1,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3]
//输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 8 
// -10 <= nums[i] <= 10 
// 
// Related Topics 数组 回溯 
// 👍 1357 👎 0

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    List<List<Integer>> result = new ArrayList<>();
    boolean[] memo;
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<Integer> list = new ArrayList<>();
        memo = new boolean[nums.length];
        Arrays.sort(nums);

        dp(nums, 0, list);
        return result;
    }

    public void dp(int[] nums, int start, List<Integer> list){
        if(start > nums.length){
            return ;
        }
        if(list.size() == nums.length){
            result.add(new ArrayList<>(list));
            return;
        }

        for(int i = start; i < nums.length; i++){
            if(i > 0 && nums[i] == nums[i-1] && !memo[i-1]){
                continue;
            }
            list.add(nums[i]);
            memo[i] = true;
            dp(nums, i+1, list);
            memo[i] = false;
            list.remove(list.size()-1);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] nums = new int[]{1,2,3};
        List<List<Integer>> lists = solution.permuteUnique(nums);
        System.out.println(lists);

    }
}
//leetcode submit region end(Prohibit modification and deletion)
