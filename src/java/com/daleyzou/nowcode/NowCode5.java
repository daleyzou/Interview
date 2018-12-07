package com.daleyzou.nowcode;

import java.util.Scanner;

/**
 * @Author: DaleyZou
 * @Description:
牛牛很喜欢玩接龙游戏，一天他突发奇想，发明了一种叫做“字符串链”的游戏。 这个游戏的规则是这样的，给出3个字符串A，B，C，
如果它们满足以下两个条件，那么就可以构成一个“字符串链”：
1.A的最后一个字母和B的第一个字母相同；
2.B的最后一个字母和C的第一个字母相同。
现在牛牛给出了3个字符串A，B，C，希望你能判断这3个字符串能否构成一个“字符串链”，若能则输出“YES”，否则输出“NO”。

输入描述:
一行，3个字符串，每两个字符串之间用一个空格分隔。

1.A，B，C均由小写的英文字母组成；

2.1≤|A|,|B|,|C|≤10，|A|,|B|,|C|分别表示A，B和C的长度。


输出描述:
"YES"或者"NO"（不带引号）。
 * @Date: Created in 11:56 2018-8-6
 * @Modified By:
 */
public class NowCode5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String str = scanner.nextLine();
        String[] split = str.split(" ");
        if (split[0].charAt(split[0].length() - 1) == split[1].charAt(0) &&
                split[1].charAt(split[1].length() - 1) == split[2].charAt(0)) {
            // 输出最后的次数
            System.out.println("YES");
        }else {
            System.out.println("NO");
        }
    }
}
