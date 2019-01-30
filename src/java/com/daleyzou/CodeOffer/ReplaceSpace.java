package com.daleyzou.CodeOffer;

/**
 * @Author: DaleyZou
 * @Description:
 * 请实现一个函数，将一个字符串中的每个空格替换成“%20”。
 * 例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 * @Date: Created in 23:30 2019/1/28
 * @Modified By:
 */
public class ReplaceSpace {
    public String replaceSpace(StringBuffer str) {
        String string = str.toString();
        char[] chars = string.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (char c : chars){
            if (c == ' '){
                sb.append("%20");
            }else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
