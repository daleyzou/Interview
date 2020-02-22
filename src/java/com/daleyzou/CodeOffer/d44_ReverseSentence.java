package com.daleyzou.CodeOffer;


/**
 * d44_ReverseSentence
 * @description 牛客最近来了一个新员工Fish，每天早晨总是会拿着一本英文杂志，写些句子在本子上。同事Cat对Fish写的内容颇感兴趣，
 * 有一天他向Fish借来翻看，但却读不懂它的意思。
 * 例如，“student. a am I”。
 * 后来才意识到，这家伙原来把句子单词的顺序翻转了，
 * 正确的句子应该是“I am a student.”。Cat对一一的翻转这些单词顺序可不在行，你能帮助他么？
 * @author daleyzou
 * @date 2020年02月22日 15:58
 * @version 1.1.11
 */
public class d44_ReverseSentence {
    public String ReverseSentence(String str) {
        if (str == null){
            return "";
        }
        if (str.trim().length() <= 0){
            return str;
        }
        StringBuilder sb = new StringBuilder();
        String[] s = str.split(" ");
        for (int i = s.length - 1; i >= 0; i--){
            sb.append(s[i]);
            if (i != 0){
                sb.append(" ");
            }
        }

        return sb.toString();
    }

    public static void main(String[] args){
        d44_ReverseSentence object = new d44_ReverseSentence();
        String s = object.ReverseSentence(" ");
        System.out.println("result"+s+"end");

    }
}
