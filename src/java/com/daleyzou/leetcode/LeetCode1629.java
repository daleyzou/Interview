package com.daleyzou.leetcode;

import java.util.*;

/**
 * LeetCode1629
 * @description 按键持续最长时间的键
 *  LeetCode 设计了一款新式键盘，正在测试其可用性。测试人员将会点击一系列键（总计 n 个），每次一个。
 *
 * 给你一个长度为 n 的字符串 keysPressed ，其中 keysPressed[i] 表示测试序列中第 i 个被按下的键。releaseTimes 是一个升序排列的列表，其中 releaseTimes[i] 表示松开第 i 个键的时间。字符串和数组的 下标都从 0 开始 。第 0 个键在时间为 0 时被按下，接下来每个键都 恰好 在前一个键松开时被按下。
 *
 * 测试人员想要找出按键 持续时间最长 的键。第 i 次按键的持续时间为 releaseTimes[i] - releaseTimes[i - 1] ，第 0 次按键的持续时间为 releaseTimes[0] 。
 *
 * 注意，测试期间，同一个键可以在不同时刻被多次按下，而每次的持续时间都可能不同。
 *
 * 请返回按键 持续时间最长 的键，如果有多个这样的键，则返回 按字母顺序排列最大 的那个键。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/slowest-key
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author zoudaifa
 * @date 2020年10月31日 15:24
 * @version 1.3.1
 */
public class LeetCode1629 {
    /**
     * 提示：
     *
     * releaseTimes.length == n
     * keysPressed.length == n
     * 2 <= n <= 1000
     * 0 <= releaseTimes[i] <= 109
     * releaseTimes[i] < releaseTimes[i+1]
     * keysPressed 仅由小写英文字母组成
     *
     * @param releaseTimes
     * @param keysPressed
     * @return
     */
    public char slowestKey1(int[] releaseTimes, String keysPressed) {
        Map<String, String> resultMap = new HashMap<>();
        String key = "key";
        int maxTime = 0;
        char[] pressedChars = keysPressed.toCharArray();
        for (int i = 0; i < pressedChars.length; i++) {
            int releaseTime;
            if (i == 0){
                releaseTime = releaseTimes[i];
            }else {
                releaseTime = releaseTimes[i] - releaseTimes[i - 1];
            }
            if (releaseTime > maxTime){
                resultMap.put(key, "" + pressedChars[i]);
                maxTime = releaseTime;
            }else if (releaseTime == maxTime){
                String orDefault = resultMap.getOrDefault(key, "");
                resultMap.put(key, orDefault + pressedChars[i]);
            }
        }

        String s = resultMap.get(key);
        if (s.length() == 1){
            return s.charAt(0);
        }else {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            return chars[chars.length - 1];
        }

    }


    public char slowestKey2(int[] releaseTimes, String keysPressed) {
        int max = 0;
        char result = 'a';
        for (int i = 0; i < keysPressed.length(); i++) {
            if (i == 0){
                max = releaseTimes[i];
                result = keysPressed.charAt(i);
            }else {
                int time = releaseTimes[i] - releaseTimes[i - 1];
                if (time > max){
                    max = time;
                    result = keysPressed.charAt(i);
                }else if (time == max){
                    if (keysPressed.charAt(i) > result){
                        result = keysPressed.charAt(i);
                    }
                }
            }
        }
        return result;
    }


    public char slowestKey(int[] releaseTimes, String keysPressed) {
        int max = releaseTimes[0];
        char result = keysPressed.charAt(0);
        int time;
        for (int i = 1; i < keysPressed.length(); i++) {
            time = releaseTimes[i] - releaseTimes[i - 1];
            if (time > max){
                max = time;
                result = keysPressed.charAt(i);
            }else if (time == max){
                if (keysPressed.charAt(i) > result){
                    result = keysPressed.charAt(i);
                }
            }
        }
        return result;
    }


    public static void main(String[] args){
        LeetCode1629 leetCode1629 = new LeetCode1629();
        char cbcd = leetCode1629.slowestKey(new int[] {9,29,49,50},
        "cbcd");
        System.out.println(cbcd);
    }
}
