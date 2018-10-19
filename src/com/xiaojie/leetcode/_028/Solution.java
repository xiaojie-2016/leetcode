package com.xiaojie.leetcode._028;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * 实现strStr()
 * 实现 strStr() 函数。
 * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
 * 示例 1:
 * 输入: haystack = "hello", needle = "ll"
 * 输出: 2
 * 示例 2:
 * 输入: haystack = "aaaaa", needle = "bba"
 * 输出: -1
 * 说明:
 * 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
 * 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与C语言的 strstr() 以及 Java的 indexOf() 定义相符。
 *
 * @author xiaojie
 * @date 2018/10/12
 */
public class Solution {

    @Test
    void test() {
        Assertions.assertEquals(0, strStr("hello", ""));
        Assertions.assertEquals(0, strStr("a", "a"));
        Assertions.assertEquals(2, strStr("hello", "ll"));
        Assertions.assertEquals(-1, strStr("aaaaa", "bba"));
    }

    /**
     * 这个解体好像没啥意义啊
     */
    public int strStr(String haystack, String needle) {
        if (haystack == null || needle == null) {
            return -1;
        }
        int nLength = needle.length();
        int hLength = haystack.length();
        if (nLength == 0) {
            return 0;
        }
        if (hLength < nLength) {
            return -1;
        }
        int i = 0;
        while (i + nLength <= hLength) {
            if (haystack.substring(i, i + nLength).equals(needle)) {
                return i;
            }
            i += 1;
        }
        return -1;
    }
}
