package leetcode.editor.cn;//给你两个字符串 s1 和 s2 ，写一个函数来判断 s2 是否包含 s1 的排列。如果是，返回 true ；否则，返回 false 。
//
// 换句话说，s1 的排列之一是 s2 的 子串 。 
//
// 
//
// 示例 1： 
//
// 
//输入：s1 = "ab" s2 = "eidbaooo"
//输出：true
//解释：s2 包含 s1 的排列之一 ("ba").
// 
//
// 示例 2： 
//
// 
//输入：s1= "ab" s2 = "eidboaoo"
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s1.length, s2.length <= 104 
// s1 和 s2 仅包含小写字母 
// 
// Related Topics 哈希表 双指针 字符串 滑动窗口 
// 👍 484 👎 0


import java.util.HashMap;
import java.util.Map;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution567 {
    public boolean checkInclusion(String s1, String s2) {
        Map<Character, Integer> map = new HashMap<>();

        Map<Character, Integer> countMap = new HashMap<>();
        for(int i = 0; i < s1.length(); i++){
            char ch = s1.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        int start = 0;
        int end = 0;
        while (start < s2.length()){
            char ch = s2.charAt(start);
            if(map.containsKey(ch)){
                countMap.put(ch, countMap.getOrDefault(ch, 0) + 1);
                if(start - end +1 == s1.length()){
                    if(isEqual(map, s2, end, start)){
                        return true;
                    }else{
                        // end移动
                        char endCh = s2.charAt(end);
                        int data = countMap.get(endCh);
                        data = data -1;
                        if(data <= 0){
                            countMap.remove(endCh);
                        }else{
                            countMap.put(endCh, data);
                        }
                        end++;
                    }
                }
            }else{
                while(end <= start){
                    char endCh = s2.charAt(end);
                    if(countMap.containsKey(endCh)){
                        countMap.remove(endCh);
                    }
                    end++;
                }
                end = start + 1;
            }
            start++;
        }
        return false;
    }

    public boolean isEqual(Map<Character, Integer> map, String s2, int end, int start){
        int[] countArr = new int[128];
        for(int i = end; i<= start; i++){
            countArr[s2.charAt(i)]++;
        }
        for(int i = end; i<= start; i++){
            char ch = s2.charAt(i);
            if(!map.containsKey(ch)){
                return false;
            }
            int data = map.get(ch);
            if(data != countArr[ch]){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution567 solution567 = new Solution567();
        boolean b = solution567.checkInclusion("adc",
            "dcda");
        System.out.println(b);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
