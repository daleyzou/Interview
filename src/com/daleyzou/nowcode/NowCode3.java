package com.daleyzou.nowcode;

import java.util.*;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * @Author: DaleyZou
 * @Description:
 * 一般的括号匹配问题是这样的：

    给出一个字符串，判断这个括号匹配是不是合法的括号匹配。

    如"((" 和 "())"都不是合法的括号匹配，但是"()()()"，"(()())()"等就是合法的括号匹配。

    这个问题解决起来非常简单，相信大家都知道怎么解决。

    现在给出一个加强版的括号匹配问题： 给出n个由括号 '(' 和 ‘)’ 组成的字符串，
    请计算出这些字符串中有多少对字符串满足si + sj是合法的括号匹配。
    如果si + sj和sj + si都是合法的括号匹配(i ≠ j)，
    那么这两种搭配都需要计入答案；如果对于si，si + si是合法的括号匹配，那么也需要计入答案。
 * @Date: Created in 21:25 2018/8/5
 * @Modified By:
 */
public class NowCode3 {
    static Stack stack1 = new Stack();
    static Stack stack2 = new Stack();

    public static boolean isMatch(String s1, String s2) {
        String str = s1 + s2;
        if (str.charAt(0) == ')'){
            return false;
        }
        for (int i = 0; i < str.length(); i++) {
            stack1.push(str.charAt(i));
        }
        while (!stack1.isEmpty()) {
            char c = (char) stack1.peek(); // 取出栈顶值
            stack1.pop();
            if (stack2.isEmpty()) {
                stack2.push(c);
            } else {
                char c1 = (char) stack2.peek();
                if (c1 == c) {
                    stack2.push(c);
                } else if (c1 == ')'){
                    stack2.pop();
                }else {
                    stack2.push(c);
                }
            }
        }
        boolean result = false;
        if (stack2.isEmpty()) {
            result = true;
//            System.out.println(str);
        } else {
            result = false;
        }
        stack1.clear();
        stack2.clear();
        return result;
    }

    public static void main1(String[] args) {  // 解法一，超时
        int result = 0;
        Scanner scanner = new Scanner(System.in);
        int num1 = scanner.nextInt();
        String[] strings = new String[num1];
        for (int i = 0; i < num1; i++){
            strings[i] = scanner.next();
        }
        for (int i = 0; i < num1; i++) {
            if (strings[i].charAt(0) == ')'){
                continue;
            }
            for (int j = 0; j < num1; j++) {
                if (i == j) continue;
                if (strings[j].charAt(strings[j].length() - 1) == '('){
                    continue;
                }
                if ((strings[i].length() + strings[j].length()) % 2 == 0){
                    if (isMatch(strings[i], strings[j])) {
                        result++;
                    }
                }
            }

//        for (int i = 0; i < num1; i++){
//            System.out.println(strings[i]);
//        }
//       System.out.println(result);
            if (strings[i].charAt(strings[i].length() - 1) != '('){
                if (isMatch(strings[i], strings[i])) {
                    result++;
                }
            }

        }
        System.out.println(result);
    }

    public static void main(String[] args) {  // 解法二
        Scanner scanner = new Scanner(System.in);
        int x = 0;  // 记录自身就是匹配的字符串的数量
        int y = 0;  // 记录可以和其他字符串连接从而匹配的字符串的数量
        List<Integer> list = new ArrayList<Integer>();
        int num1 = scanner.nextInt();
        String[] strings = new String[num1];
        for (int i = 0; i < num1; i++){
            String s = scanner.next();
            strings[i] = removeMatch(s);
            if (strings[i].length() == 0){
                x++;
            }else if (strings[i].charAt(0) == '('){
                list.add(strings[i].length());
            }else if (strings[i].charAt(0) == ')' && strings[i].indexOf("(") == -1){
                list.add(-strings[i].length());
            }
        }

        for (int i = 0; i < list.size(); i++){
            for (int j = i + 1; j < list.size(); j++){
                if (list.get(i) + list.get(j) == 0){
                    y++;
                }
            }
        }
        System.out.println(x * x + y);
    }

    public static String removeMatch(String str){
        StringBuffer sb = new StringBuffer(str);
        while (sb.indexOf("()") != -1){
            sb.delete(sb.indexOf("()"), sb.indexOf("()") + 2);
        }
        return sb.toString();
    }
}
