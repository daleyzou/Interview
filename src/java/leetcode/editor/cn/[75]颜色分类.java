package leetcode.editor.cn;
//给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
//
// 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。 
//
// 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [2,0,2,1,1,0]
//输出：[0,0,1,1,2,2]
// 
//
// 示例 2： 
//
// 
//输入：nums = [2,0,1]
//输出：[0,1,2]
// 
//
// 示例 3： 
//
// 
//输入：nums = [0]
//输出：[0]
// 
//
// 示例 4： 
//
// 
//输入：nums = [1]
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// n == nums.length 
// 1 <= n <= 300 
// nums[i] 为 0、1 或 2 
// 
//
// 
//
// 进阶： 
//
// 
// 你可以不使用代码库中的排序函数来解决这道题吗？ 
// 你能想出一个仅使用常数空间的一趟扫描算法吗？ 
// 
// Related Topics 排序 数组 双指针 
// 👍 906 👎 0


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution75 {
    public void sortColors(int[] nums) {
        // bubbleSort(nums);
//        mapSolution(nums);
        int length = nums.length;
        int begin = 0;
        for (int i = 0; i < length; i++) {
            if (nums[i] == 0) {
                int temp = nums[i];
                nums[i] = nums[begin];
                nums[begin] = temp;
                begin++;
            }
        }
        for (int i = begin; i < length; i++) {
            if (nums[i] == 1) {
                int temp = nums[i];
                nums[i] = nums[begin];
                nums[begin] = temp;
                begin++;
            }
        }

    }

    public void sortColors2(int[] nums) {
        int n = nums.length;
        int p0 = 0, p1 = 0;
        for (int i = 0; i < n; ++i) {
            if (nums[i] == 1) {
                int temp = nums[i];
                nums[i] = nums[p1];
                nums[p1] = temp;
                ++p1;
            } else if (nums[i] == 0) {
                int temp = nums[i];
                nums[i] = nums[p0];
                nums[p0] = temp;
                if (p0 < p1) {
                    temp = nums[i];
                    nums[i] = nums[p1];
                    nums[p1] = temp;
                }
                ++p0;
                ++p1;
            }
        }
    }

    private void mapSolution(int[] nums) {
        Map<Integer, Integer> countMap = new HashMap<>(3);
        for (int i = 0; i < nums.length; i++) {
            Integer count = countMap.getOrDefault(nums[i], 0);
            countMap.put(nums[i], count + 1);
        }
        List<Integer> colorList = new ArrayList<>();
        colorList.add(0);
        colorList.add(1);
        colorList.add(2);

        int begin = 0;
        for (Integer eachColor : colorList) {
            Integer count1 = countMap.get(eachColor);
            if (count1 != null) {
                for (int i = 0; i < count1; i++) {
                    nums[begin++] = eachColor;
                }
            }
        }
    }

    private void bubbleSort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            boolean isSwap = false;
            for (int j = 1; j < nums.length - i; j++) {
                if (nums[j - 1] > nums[j]) {
                    int temp = nums[j - 1];
                    nums[j - 1] = nums[j];
                    nums[j] = temp;
                    isSwap = true;
                }
            }
            if (!isSwap) {
                break;
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
