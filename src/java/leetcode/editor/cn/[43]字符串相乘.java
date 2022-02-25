package leetcode.editor.cn;//给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
//
// 注意：不能使用任何内置的 BigInteger 库或直接将输入转换为整数。 
//
// 
//
// 示例 1: 
//
// 
//输入: num1 = "2", num2 = "3"
//输出: "6" 
//
// 示例 2: 
//
// 
//输入: num1 = "123", num2 = "456"
//输出: "56088" 
//
// 
//
// 提示： 
//
// 
// 1 <= num1.length, num2.length <= 200 
// num1 和 num2 只能由数字组成。 
// num1 和 num2 都不包含任何前导零，除了数字0本身。 
// 
// Related Topics 数学 字符串 模拟 
// 👍 839 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution43 {
    public String multiply(String num1, String num2) {
        int maxLength = num1.length() + num2.length() + 1;
        char[] ch1 = new StringBuilder(num1).reverse().toString().toCharArray();
        char[] ch2 = new StringBuilder(num2).reverse().toString().toCharArray();
        int[] result = new int[maxLength];
        for(int i = 0; i < ch1.length; i++){
            for(int j = 0; j < ch2.length; j++){
                result[i+j] += Integer.valueOf(ch1[i]) * Integer.valueOf(ch2[j]);
            }
        }

        int[] adder = new int[maxLength];

        for(int i = 0; i < result.length-1; i++){
            int plus = (result[i] + adder[i]) / 10;
            result[i] = (result[i] + adder[i]) %10;
            adder[i+1] = plus;
        }
        result[result.length-1] += adder[result.length-1];

        int index = result.length-1;
        while(index >= 0 && result[index] == 0){
            index--;
        }
        StringBuilder sb = new StringBuilder();
        while(index >= 0){
            sb.append(result[index]);
            index--;
        }
        if(sb.length()==0){
            sb.append("0");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution43 solution43 = new Solution43();
        String multiply = solution43.multiply("2", "3");
        System.out.println(multiply);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
