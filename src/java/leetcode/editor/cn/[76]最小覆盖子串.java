package leetcode.editor.cn;
//给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
//
// 注意：如果 s 中存在这样的子串，我们保证它是唯一的答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "ADOBECODEBANC", t = "ABC"
//输出："BANC"
// 
//
// 示例 2： 
//
// 
//输入：s = "a", t = "a"
//输出："a"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length, t.length <= 105 
// s 和 t 由英文字母组成 
// 
//
// 
//进阶：你能设计一个在 o(n) 时间内解决此问题的算法吗？ Related Topics 哈希表 双指针 字符串 Sliding Window 
// 👍 1178 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String minWindow(String s, String t) {
        if(t == null || t.length() < 1){
            return "";
        }
        int[] need = new int[128];
        int[] window = new int[128];
        for(int i = 0; i < t.length(); i ++){
            need[t.charAt(i)]++;
        }

        int left = 0;
        int right = 0;
        int vailde = 0;
        int endIndex = Integer.MAX_VALUE;
        int beginIndex = 0;

        while (right < s.length()){
            char rightC = s.charAt(right);
            window[rightC]++;
            right++;
            if(need[rightC] > 0){

                if(window[rightC] == need[rightC]){
                    vailde++;
                }
            }

            if (vailde == t.length()){
                while(left < right && right - left >= t.length()){
                    char leftC = s.charAt(left);
                    if(vailde == t.length()){
                        if(right - left < endIndex - beginIndex){
                            endIndex = right;
                            beginIndex = left;
                        }
                    }

                    if(need[leftC] > 0){
                        if(window[leftC] == need[leftC]){
                            vailde--;

                        }
                    }
                    window[leftC]--;
                    left++;
                }
            }

        }

        return endIndex == Integer.MAX_VALUE?"":s.substring(beginIndex, endIndex);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        String s = solution.minWindow("ADOBECODEBANC",
            "ABC");
        System.out.println("result: "+ s);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
