package leetcode.editor.cn;//给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重
//复的三元组。 
//
// 注意：答案中不可以包含重复的三元组。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [-1,0,1,2,-1,-4]
//输出：[[-1,-1,2],[-1,0,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：nums = [0]
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 3000 
// -105 <= nums[i] <= 105 
// 
// Related Topics 数组 双指针 排序 
// 👍 4203 👎 0


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution15 {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
            System.out.println("nums = " + Arrays.toString(nums));

        return nSum(nums, 3, 0, 0);
    }

    public List<List<Integer>> nSum(int[] nums, int n, int first, int target){
        System.out.println("nSum first:" + first);
        List<List<Integer>> data = new ArrayList<>();
        if(n < 2 || nums.length < n){
            return data;
        }
        if(n == 2){
            return twoSum(nums, first, target);
        }
        int i = first;
        while(i < nums.length){
            int cur = nums[i];
            List<List<Integer>>  temp = nSum(nums, n-1, i+1, target - cur);
            for(List<Integer> it : temp){
                it.add(cur);
                data.add(it);
            }
            while(i < nums.length && nums[i] == cur){
                i++;
            }
        }
        return data;
    }

    public List<List<Integer>> twoSum(int[] nums, int start, int target){
        System.out.println("start: " + start + " target:" + target );
        int begin = start;
        int end = nums.length -1;
        List<List<Integer>> result = new ArrayList<>();
        while(begin < end){
            int sum = nums[begin] + nums[end];
            int left = nums[begin];
            int right = nums[end];
            if(sum > target){
                while(begin < end && nums[begin] == left){
                    begin++;
                }
            }else if(sum < target){
                while(begin < end && nums[end] == right){
                    end--;
                }
            }else {
                List<Integer> list = new ArrayList<>();
                list.add(nums[begin]);
                list.add(nums[end]);
                result.add(list);
                while(begin < end && nums[begin] == left){
                    begin++;
                }
                while(begin < end && nums[end] == right){
                    end--;
                }
            }
        }
        return result;
    }
    public static void main(String[] args) {
        Solution15 solution15 = new Solution15();
        List<List<Integer>> lists = solution15.threeSum(new int[]{1,-1,-1,0});
        System.out.println(lists);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
