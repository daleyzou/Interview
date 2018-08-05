package com.daleyzou.nowcode;

import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;
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
                } else {
                    stack2.pop();
                }
            }
        }
        boolean result = false;
        if (stack2.isEmpty()) {
            result = true;
        } else {
            result = false;
        }
        stack1.clear();
        stack2.clear();
        return result;
    }

    public static void main(String[] args) {
        int result = 0;
        Scanner scanner = new Scanner(System.in);
        int num1 = scanner.nextInt();
        String[] strings = new String[num1];
        for (int i = 0; i < num1; i++){
            strings[i] = scanner.next();
        }
        for (int i = 0; i < num1; i++) {
            for (int j = 0; j < num1; j++) {
                {
                    if (i == j) continue;
                    if (strings[j].charAt(strings[j].length() - 1) == '('){
                        continue;
                    }
                    if (isMatch(strings[i], strings[j])) {
                        result++;
                    }
                    if (isMatch(strings[i], strings[i] + strings[j])) {
                        result++;
                    }

                }
            }

//        for (int i = 0; i < num1; i++){
//            System.out.println(strings[i]);
//        }
       System.out.println(result);

        }
        System.out.println("end:"+result);
    }
}
