package leetcode.editor.cn;//给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。
//
// 异位词 指由相同字母重排列形成的字符串（包括相同的字符串）。 
//
// 
//
// 示例 1: 
//
// 
//输入: s = "cbaebabacd", p = "abc"
//输出: [0,6]
//解释:
//起始索引等于 0 的子串是 "cba", 它是 "abc" 的异位词。
//起始索引等于 6 的子串是 "bac", 它是 "abc" 的异位词。
// 
//
// 示例 2: 
//
// 
//输入: s = "abab", p = "ab"
//输出: [0,1,2]
//解释:
//起始索引等于 0 的子串是 "ab", 它是 "ab" 的异位词。
//起始索引等于 1 的子串是 "ba", 它是 "ab" 的异位词。
//起始索引等于 2 的子串是 "ab", 它是 "ab" 的异位词。
// 
//
// 
//
// 提示: 
//
// 
// 1 <= s.length, p.length <= 3 * 104 
// s 和 p 仅包含小写字母 
// 
// Related Topics 哈希表 字符串 滑动窗口 
// 👍 641 👎 0


import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution438 {
    public List<Integer> findAnagrams(String s, String p) {
        int[] need = new int[128];
        int[] window = new int[128];
        int needKind = 0;
        int validate = 0;
        List<Integer> result = new ArrayList<>();
        for(int i = 0; i < s.length(); i++){
            char needC = s.charAt(i);
            if(need[needC] == 0){
                needKind++;
            }
            need[needC]++;
        }
        int left = 0;
        int right = 0;

        while(right < p.length()){
            char rightC = p.charAt(right);
            if(need[rightC] > 0){
                window[rightC]++;
                if(need[rightC] == window[rightC]){
                    validate++;
                }
            }

            while(right - left + 1 >= s.length()){
                if(right-left+1 == s.length() && needKind == validate){
                    result.add(left);
                }
                char leftC = p.charAt(left);
                if(need[leftC] > 0){
                    if(need[leftC] == window[leftC]){
                        validate--;
                    }
                    window[leftC]--;
                }
                left++;
            }
            right++;
        }
        return result;
    }

    public static void main(String[] args) {
        Solution438 solution438 = new Solution438();
        List<Integer> anagrams = solution438.findAnagrams("cbaebabacd",
            "abc");
        for (Integer anagram : anagrams) {
            System.out.println(anagram);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
