package com.daleyzou.CodeOffer;

/**
 * d52_Math
 * @description
 *
 * 请实现一个函数用来匹配包括'.'和'*'的正则表达式。
 * 模式中的字符'.'表示任意一个字符，而'*'表示它前面的字符可以出现任意次（包含0次）。
 *
 * 在本题中，匹配是指字符串的所有字符匹配整个模式。例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但是与"aa.a"和"ab*a"均不匹配
 *
 * kan https://blog.csdn.net/u010947534/article/details/88381919
 * https://cyc2018.github.io/CS-Notes/#/notes/19.%20%E6%AD%A3%E5%88%99%E8%A1%A8%E8%BE%BE%E5%BC%8F%E5%8C%B9%E9%85%8D
 * https://www.cnblogs.com/mfrank/p/10472663.html
 * @author daleyzou
 * @date 2020年05月07日 9:13
 * @version 3.3.0
 */
public class d52_Match {

    public boolean match_1(char[] str, char[] pattern) {
        boolean result = false;
        if (str.length == 0 && pattern.length == 0) {
            return true;
        }
        int strLength = str.length;
        int patternLength = pattern.length;
        return matchMore(str, 0, pattern, 0);

    }

    private boolean matchMore(char[] str, int strIndex, char[] pattern, int patternIndex) {
        // 都到了末尾
        if (strIndex == str.length && pattern.length == patternIndex) {
            return true;
        }
        // 字符串没有到末尾， 模式已经到了末尾
        if (pattern.length == patternIndex && strIndex != str.length) {
            return false;
        }

        // 第二个字符是 *
        if (patternIndex + 1 < pattern.length && pattern[patternIndex + 1] == '*') {
            // 当前是相等 或者 .   开始考虑三种情况
            if (strIndex != str.length && pattern[patternIndex] == '.'
                    || strIndex != str.length && pattern[patternIndex] == str[strIndex]) {
                return matchMore(str, strIndex, pattern, patternIndex + 2) || matchMore(str, strIndex + 1, pattern, patternIndex + 2)
                        || matchMore(str, strIndex + 1, pattern, patternIndex);
            } else {
                return matchMore(str, strIndex, pattern, patternIndex + 2);
            }
        }

        //  判断当前匹配是 .或者相等
        if (str.length != strIndex && (pattern[patternIndex] == str[strIndex] || pattern[patternIndex] == '.')) {
            return matchMore(str, strIndex + 1, pattern, patternIndex + 1);
        } else {
            return false;
        }

    }

    public boolean match_2(char[] str, char[] pattern) {
        if (pattern.length <= 0) {
            return str.length <= 0;
        }
        String s = str.length == 0 ? "" : String.valueOf(str);
        String p = pattern.length == 0 ? "" : String.valueOf(pattern);
        return checkIsMatch(s, p);
    }

    private boolean checkIsMatch(String s, String p) {
        if (p.length() <= 0) {
            return s.length() <= 0;
        }
        boolean isMatch = s.length() > 0 && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.');
        if (p.length() > 1 && p.charAt(1) == '*') {
            return checkIsMatch(s, p.substring(2)) || (isMatch && s.length() > 0 && checkIsMatch(s.substring(1), p.substring(2))) || (
                    isMatch && s.length() > 0 && checkIsMatch(s.substring(1), p));
        } else {
            return isMatch && checkIsMatch(s.substring(1), p.substring(1));
        }
    }

    /**
     *  https://www.cnblogs.com/mfrank/p/10472663.html
     * 自顶向下
     * @param str
     * @param pattern
     * @return
     * @author daleyzou
     */
    public boolean match_3(char[] str, char[] pattern) {
        if (pattern.length <= 0) {
            return str.length <= 0;
        }
        if (str.length == 0) {
            return pattern.length == 2 && pattern[0] == '.' && pattern[1] == '*';
        }
        Boolean[][] result = new Boolean[str.length + 1][pattern.length + 1];
        String s = String.valueOf(str);
        String p = String.valueOf(pattern);
        return dynamicMatch(0, 0, s, p, result);
    }

    private boolean dynamicMatch(int sBegin, int pBegin, String s, String p, Boolean[][] result) {
        if (result[sBegin][pBegin] != null) {
            return result[sBegin][pBegin].equals(Boolean.TRUE);
        }
        boolean ans = false;
        if (p.length() == pBegin) {
            ans = s.length() == sBegin;
        }
        if (pBegin < p.length()) {
            boolean currentMatch = sBegin != s.length() && (s.charAt(sBegin) == p.charAt(pBegin) || p.charAt(pBegin) == '.');
            if (pBegin + 1 < p.length() && p.charAt(pBegin + 1) == '*') {
                ans = dynamicMatch(sBegin, pBegin + 2, s, p, result) || (currentMatch && dynamicMatch(sBegin + 1, pBegin, s, p, result));
            } else {
                ans = currentMatch && dynamicMatch(sBegin + 1, pBegin + 1, s, p, result);
            }
        }
        result[sBegin][pBegin] = ans;
        return ans;
    }

    /**
     *  动态规划
     *  自底向上
     *
     * @param str
     * @param pattern
     * @return
     * @author dalelyzou
     */
    public boolean match(char[] str, char[] pattern)
    {
        String s = String.valueOf(str);
        String p = String.valueOf(pattern);
        if (pattern.length == 0){
            return str.length == 0;
        }
        if (str.length == 0) {
            return pattern.length == 2 && pattern[1] == '*';
        }
        boolean[][] result = new boolean[str.length +1][pattern.length + 1];
        result[str.length][pattern.length] = true;
        return endMatch(s, p, result);
    }

    private boolean endMatch(String s, String p, boolean[][] result) {
        for (int i = s.length(); i >= 0 ; i--){
            for (int j = p.length() - 1; j >= 0; j--){
                boolean currentMatch = (i < s.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.'));
                if ( j + 1 < p.length() && p.charAt(j + 1) == '*'){
                    result[i][j] = result[i][j + 2] || (currentMatch && result[i+1][j]);
                }else {
                    result[i][j] = currentMatch && result[i + 1][j + 1];
                }
            }
        }

        return result[0][0];
    }

    public static void main(String[] args) {
        d52_Match match = new d52_Match();

        System.out.println("true " + match.match("aaa".toCharArray(), "a*a".toCharArray()));

        System.out.println("true " + match.match("".toCharArray(), ".*".toCharArray()));
        // "a","ab*a"
        System.out.println("false " + match.match("a".toCharArray(), "ab*a".toCharArray()));

        System.out.println("false " + match.match("aa".toCharArray(), "b*a".toCharArray()));
    }
}
