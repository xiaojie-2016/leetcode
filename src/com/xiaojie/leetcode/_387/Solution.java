package com.xiaojie.leetcode._387;

import org.junit.jupiter.api.Test;

/**
 * 字符串中的第一个唯一字符
 * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
 * 案例:
 * s = "leetcode"
 * 返回 0.
 * s = "loveleetcode",
 * 返回 2.
 * 注意事项：您可以假定该字符串只包含小写字母。
 *
 * @author xiaojie
 * @date 2018/10/12
 */
public class Solution {

    @Test
    void test() {
//        System.out.println(firstUniqChar("aa"));
//        System.out.println(firstUniqChar("dddccdbba"));
//        System.out.println(firstUniqChar("acaadcad"));
//        System.out.println(firstUniqChar("loveleetcode"));
        System.out.println(firstUniqChar2(""));
        System.out.println(firstUniqChar2("a"));
        System.out.println(firstUniqChar2("aa"));
        System.out.println(firstUniqChar2("dddccdbba"));
        System.out.println(firstUniqChar2("acaadcad"));
        System.out.println(firstUniqChar2("loveleetcode"));
    }

    /**
     * 方法一：最笨办法
     * 时间复杂度 O(n^2)
     * 空间复杂度 O(1)
     */
    public int firstUniqChar(String s) {
        if (s != null && s.length() > 0) {
            if (s.length() == 1) {
                return 0;
            }
            for (int i = 0; i < s.length(); i++) {
                int num = 0;
                for (int j = 0; j < s.length(); j++) {
                    if (i == j) {
                        continue;
                    }
                    if (s.charAt(i) == s.charAt(j)) {
                        num += 1;
                        break;
                    }
                }
                if (num == 0) {
                    return i;
                }
            }
        }
        return -1;
    }

    /**
     * 方法二：
     * 判断字符的前后索引是一个就可以了
     */
    public int firstUniqChar2(String s) {
        for (int i = 0; i < s.length(); i++) {
            String s1 = String.valueOf(s.charAt(i));
            if (s.indexOf(s1) == s.lastIndexOf(s1)) {
                return i;
            }
        }
        return -1;
    }
}
