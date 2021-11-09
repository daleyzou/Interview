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
class Solution76 {

    public String minWindow(String s, String t) {
        String result = "";
        int[] need = new int[128];
        int[] window = new int[128];
        int needKind = 0;
        int validate = 0;
        int left = 0;
        int right = 0;
        for(int i = 0; i < t.length(); i++){
            char needC = t.charAt(i);
            if(need[needC] == 0){
                needKind++;
            }
            need[needC]++;
        }

        while (right < s.length()){
            char rightC = s.charAt(right);
            if(need[rightC] > 0){
                window[right]++;
                if(need[rightC] == window[rightC]){
                    validate++;
                }
            }

            while(needKind == validate && left <= right){
                if(needKind == validate){
                    String temp = s.substring(left, right+1);
                    result = result.length() < temp.length()?temp:result;
                }

                char leftC = s.charAt(left);
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

    public String minWindow1(String s, String t) {
        if(t == null || t.length() < 1){
            return "";
        }
        int[] need = new int[128];
        int[] window = new int[128];
        int needKind = 0;
        for(int i = 0; i < t.length(); i ++){
            if(need[t.charAt(i)] == 0){
                needKind++;
            }
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
            while(left < right && vailde == needKind){
                char leftC = s.charAt(left);
                if(vailde == needKind){
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

        return endIndex == Integer.MAX_VALUE?"":s.substring(beginIndex, endIndex);
    }
    public static void main(String[] args) {
        Solution76 solution76 = new Solution76();

        String s = solution76.minWindow("BANC",
            "ABC");
        System.out.println("result: "+ s);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
