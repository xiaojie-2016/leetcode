package com.xiaojie.leetcode._014;

/**
 * 最长公共前缀
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * 如果不存在公共前缀，返回空字符串 ""。
 * 示例 1:
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * 示例 2:
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 * 说明:
 * 所有输入只包含小写字母 a-z 。
 *
 * @author xiaojie
 * @date 2018/10/12
 */
public class Solution {
    /**
     * 很简单
     */
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        StringBuilder builder = new StringBuilder();
        String s = strs[0];
        for (int i = 0; i < s.length(); i++) {
            String value = builder.toString() + String.valueOf(s.charAt(i));
            for (String str : strs) {
                if (!str.startsWith(value)) {
                    return builder.toString();
                }
            }
            builder.append(String.valueOf(s.charAt(i)));
        }
        return builder.toString();
    }
}
