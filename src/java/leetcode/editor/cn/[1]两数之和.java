package leetcode.editor.cn;//给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 的那 两个 整数，并返回它们的数组下标。
//
// 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。 
//
// 你可以按任意顺序返回答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [2,7,11,15], target = 9
//输出：[0,1]
//解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
// 
//
// 示例 2： 
//
// 
//输入：nums = [3,2,4], target = 6
//输出：[1,2]
// 
//
// 示例 3： 
//
// 
//输入：nums = [3,3], target = 6
//输出：[0,1]
// 
//
// 
//
// 提示： 
//
// 
// 2 <= nums.length <= 103 
// -109 <= nums[i] <= 109 
// -109 <= target <= 109 
// 只会存在一个有效答案 
// 
// Related Topics 数组 哈希表 
// 👍 10689 👎 0


import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution1 {
    public int[] twoSum1(int[] nums, int target) {
        int [] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            int num1 = nums[i];
            for (int j = i + 1; j <nums.length; j++){
                int num2 = nums[j];
                if (num1 + num2 == target){
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
             }
        }
        return result;
    }

    // ------------------------------methon 2----------------------------------
    public int[] twoSum2(int[] nums, int target) {
        // 二分查找
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            List<Integer> list = map.getOrDefault(nums[i], new ArrayList<>());
            list.add(i);
            map.put(nums[i], list);
        }
        Arrays.sort(nums);

        for(int i = 0; i < nums.length; i++){
            int needFind = target - nums[i];
            if(find(nums, i+1, nums.length-1, needFind)){
                return new int[]{getData(map, nums[i]), getData(map, needFind)};
            }
        }
        // 多一次循环， 查找下标
        return new int[]{-1, -1};
    }

    public int getData(Map<Integer, List<Integer>> map, Integer target){
        List<Integer> list = map.get(target);
        if(list == null){
            return -1;
        }
        Integer data = list.get(0);
        list.remove(0);
        map.put(target, list);
        return data;
    }

    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> countMap = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            countMap.put(nums[i], i);
        }

        for(int i=0;i<nums.length;i++){

            Integer countData = countMap.get(target - nums[i]);
            if(countData != null && countData != i){
                return new int[]{i, countData};
            }
        }

        return new int[]{-1,-1};
    }

    public boolean find(int[] nums, int i, int j, int target){
        if(i < 0 || j >= nums.length || i >= nums.length || j < 0 || i > j){
            return false;
        }
        int mid = (i+j)/2;
        int midNum = nums[mid];
        if(midNum < target){
            return find(nums, mid+1, j, target);
        }else if(mid > target){
            return find(nums, i, mid-1, target);
        }else {
            return true;
        }
    }

    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        int[] ints = solution1.twoSum(new int[] { 2, 5, 5, 11 }, 10);
        System.out.println(ints);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
