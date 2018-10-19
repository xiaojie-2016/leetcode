package com.xiaojie.leetcode._680;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * 验证回文字符串
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 * 示例 1:
 * 输入: "A man, a plan, a canal: Panama"
 * 输出: true
 * 示例 2:
 * 输入: "race a car"
 * 输出: false
 *
 * @author xiaojie
 * @date 2018/10/12
 */
public class Solution {

    @Test
    void test() {
        assertTrue(isPalindrome(""));
        assertTrue(isPalindrome("A man, a plan, a canal: Panama"));
        assertFalse(isPalindrome("race a car"));
    }

    public boolean isPalindrome(String s) {
        if (s == null) {
            return false;
        }
        // 先全部转小写，然后正则去掉所有非字母数字的字符
        s = s.toLowerCase().replaceAll("[^a-z0-9]", "");
        if (s.length() <= 1) {
            return true;
        }
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - i - 1)) {
                return false;
            }
        }
        return true;
    }
}
