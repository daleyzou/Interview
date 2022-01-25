package leetcode.editor.cn;//给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
//
// 请你设计并实现时间复杂度为 O(n) 的算法解决此问题。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [100,4,200,1,3,2]
//输出：4
//解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。 
//
// 示例 2： 
//
// 
//输入：nums = [0,3,7,2,5,8,4,6,0,1]
//输出：9
// 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 105 
// -109 <= nums[i] <= 109 
// 
// Related Topics 并查集 数组 哈希表 
// 👍 1062 👎 0


import java.util.HashMap;
import java.util.Map;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int longestConsecutive(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        int max = nums[0];
        for(int i = 0; i < nums.length; i++){
            map.put(nums[i], 1);
            max = Math.max(nums[i], max);
        }
        int result = 1;
        for(int i = 1; i <= max; i++){
            int small = i -1;
            if(map.containsKey(small)){
                int more = map.get(small) +1;
                map.put(i,more);
                result = Math.max(result, more);
            }else{
                map.put(i,1);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution =new Solution();
        int i = solution.longestConsecutive(new int[]{100, 4, 200, 1, 3, 2});
        System.out.println(i);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
