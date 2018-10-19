package com.xiaojie.leetcode._038;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * 报数
 * 报数序列是一个整数序列，按照其中的整数的顺序进行报数，得到下一个数。其前五项如下：
 * 1.     1
 * 2.     11
 * 3.     21
 * 4.     1211
 * 5.     111221
 * 1 被读作  "one 1"  ("一个一") , 即 11。
 * 11 被读作 "two 1s" ("两个一"）, 即 21。
 * 21 被读作 "one 2",  "one 1" （"一个二" ,  "一个一") , 即 1211。
 * 给定一个正整数 n（1 ≤ n ≤ 30），输出报数序列的第 n 项。
 * 注意：整数顺序将表示为一个字符串。
 *
 * @author xiaojie
 * @date 2018/10/12
 */
public class Solution {

    @Test
    void test() {
        Assertions.assertEquals("1", countAndSay(1));
        Assertions.assertEquals("11", countAndSay(2));
        Assertions.assertEquals("21", countAndSay(3));
        Assertions.assertEquals("1211", countAndSay(4));
        Assertions.assertEquals("111221", countAndSay(5));
    }

    /**
     * 好不容易理解了题意。。
     * 我的理解能力很差么
     */
    public String countAndSay(int n) {
        String result = "1";
        for (int i = 1; i < n; i++) {
            StringBuilder builder = new StringBuilder();
            char[] chars = result.toCharArray();
            int num = 1;
            for (int j = 0; j < chars.length; j++) {
                if (j + 1 < chars.length && chars[j] == chars[j + 1]) {
                    num += 1;
                    continue;
                }
                builder.append(num).append(chars[j]);
                num = 1;
            }
            result = builder.toString();
        }
        return result;
    }
}
