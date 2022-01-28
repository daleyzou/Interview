package leetcode.editor.cn;//给定一个经过编码的字符串，返回它解码后的字符串。
//
// 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。 
//
// 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。 
//
// 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "3[a]2[bc]"
//输出："aaabcbc"
// 
//
// 示例 2： 
//
// 
//输入：s = "3[a2[c]]"
//输出："accaccacc"
// 
//
// 示例 3： 
//
// 
//输入：s = "2[abc]3[cd]ef"
//输出："abcabccdcdcdef"
// 
//
// 示例 4： 
//
// 
//输入：s = "abc3[cd]xyz"
//输出："abccdcdcdxyz"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 30 
// s 由小写英文字母、数字和方括号 '[]' 组成 
// s 保证是一个 有效 的输入。 
// s 中所有整数的取值范围为 [1, 300] 
// 
// Related Topics 栈 递归 字符串 
// 👍 1015 👎 0


import java.util.Stack;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution394 {
    public String decodeString(String s) {
        Stack<Integer> numberStack = new Stack<>();
        Stack<String> strStack = new Stack<>();

        int index = 0;
        String temp = "";
        while(index < s.length()){
            char ch = s.charAt(index);
            if(Character.isDigit(ch)){
                String data = "";
                while(Character.isDigit(ch)){
                    data += ch;
                    index++;
                    ch = s.charAt(index);
                }
                numberStack.push(Integer.valueOf(data));

            }else{
                if(ch == ']'){
                    Stack<String> list = new Stack<>();
                    String str = strStack.pop();
                    while(!str.equals("[")){
                        list.push(str);
                        str = strStack.pop();
                    }
                    int count = numberStack.pop();
                    String item = getString(list);
                    StringBuilder sb = new StringBuilder(item);
                    while(count-- > 1){
                        sb.append(item);
                    }
                    strStack.push(sb.toString());
                }else {
                    strStack.push(ch + "");
                }
                index++;
            }
        }
        return getResult(strStack);
    }

    public String getString(Stack<String> stack){
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
//             sb.insert(0, stack.pop());
            sb.append(stack.pop());
        }
        return sb.toString();
    }

    public String getResult(Stack<String> stack){
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
             sb.insert(0, stack.pop());
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        Solution394 solution394 = new Solution394();

        String s = solution394.decodeString("1[1[1[jk]e1[f]]]");
        System.out.println(s);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
