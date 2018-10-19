package com.xiaojie.leetcode._344;

import org.junit.jupiter.api.Test;

/**
 * 反转字符串
 * 编写一个函数，其作用是将输入的字符串反转过来。
 * 示例 1:
 * 输入: "hello"
 * 输出: "olleh"
 * 示例 2:
 * 输入: "A man, a plan, a canal: Panama"
 * 输出: "amanaP :lanac a ,nalp a ,nam A"
 *
 * @author xiaojie
 * @date 2018/10/12
 */
public class Solution {

    @Test
    void test() {
        System.out.println(reverseString("hello"));
        System.out.println(reverseString("A man, a plan, a canal: Panama"));
    }

    /**
     * 这个太简单，我懒得写解释了，
     */
    public String reverseString(String s) {
        if (s == null || s.length() < 1) {
            return s;
        }
        char[] chars = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = chars.length - 1; i >= 0; i--) {
            sb.append(chars[i]);
        }
        return sb.toString();
    }
}
