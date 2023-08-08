package algorithm_imp.common_algo_imp;

import java.util.Arrays;

/**
 * @author MrkWinter
 * @version 1.0
 * 4. Kmp算法实现
 */
public class KMP {
    public static void main(String[] args) {
//        System.out.println(violentMatch("abcdefghigklmn", "defg"));
//        System.out.println(Arrays.toString(getKMPNext("ABADABAB")));
        System.out.println(KMPSearch("AABACDEKLMN", "ABACDE"));
    }


    //kmp字符串匹配算法
    public static int KMPSearch(String s1, String s2) {
        int[] kmpNext = getKMPNext(s2);
        for (int i = 0, j = 0; i < s1.length(); i++) {
            while (j > 0 && s1.charAt(i) != s2.charAt(j))
                j = kmpNext[j - 1];
            if (s1.charAt(i) == s2.charAt(j)) {
                j++;
            }
            if (j == s2.length())
                return i - j + 1;
        }
        return -1;
    }

    //最长公共前后缀 部分匹配表
    public static int[] getKMPNext(String str) {
        int[] next = new int[str.length()];
        next[0] = 0;
        //i为末尾 j为可以匹配的开头
        for (int i = 1, j = 0; i < next.length; i++) {

            while (j > 0 && str.charAt(i) != str.charAt(j)) {
                j = next[j - 1];
            }
            /*
            while (j > 0 && str.charAt(i) != str.charAt(j)) {
                j = next[j - 1];
            }
            最长公共前缀： 最长公共前后缀的前面部分
            最长公共后缀： 最长公共前后缀的后面部分
            规律1：最长公共前后缀值总是指向最长公共前缀的下一位
            规律2：最长公共前后缀值-1总是指向最长公共前缀的最后一位

            该代码的意义为：
            在不移动i的前提下找到i位置对应的最长公共前后缀值 为此只能寻求与i位置前面一位字符(下面称为前字符)最长公共前后缀的关系
            j-1刚好总是定位到前字符最长公共前缀的最后一位字符，该字符与前字符相同 (以下称之为前缀相同前字符) next[j-1]是前缀相同前字符的最长公共前后缀值
            该值为下标总是指向该位置最长公共前缀的下一位 即i位置最长公共前缀的最后一位的最长公共前缀的下一位值(下面成为比较值) 如果比较值和i位置字符相同
            则满足匹配到了较短的前缀值 该前缀值+1就为i位置上的最长公共前后缀值 如果比较值不同
            则继续进行j = next[j-1] 相似递归直到在前缀中找不到较短前缀 j = 0 与字符头比较

            简单来说： 若当前字符与前缀字符不同 在较长的前缀字符中找到较短的可能符合的前缀字符 进行比较 若不符合 接着找前缀的前缀*/
            if (str.charAt(i) == str.charAt(j)) {
                j++; //
            }
            next[i] = j;
        }
        return next;
    }


    //暴力匹配算法
    public static int violentMatch(String s1, String s2) {
        char[] chars1 = s1.toCharArray();
        char[] chars2 = s2.toCharArray();
        int i = 0;
        int j = 0;
        while (i < chars1.length && j < chars2.length) {
            if (chars1[i] == chars2[j]) {
                i++;
                j++;
            } else {
                i = i - j + 1;
                j = 0;
            }
        }
        if (j == chars2.length)
            return i - j;
        return -1;
    }

}
