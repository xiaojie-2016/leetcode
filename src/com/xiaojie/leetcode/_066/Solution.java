package com.xiaojie.leetcode._066;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 加一
 * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
 * 最高位数字存放在数组的首位， 数组中每个元素只存储一个数字。
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 * 示例 1:
 * 输入: [1,2,3]
 * 输出: [1,2,4]
 * 解释: 输入数组表示数字 123。
 * 示例 2:
 * 输入: [4,3,2,1]
 * 输出: [4,3,2,2]
 * 解释: 输入数组表示数字 4321。
 *
 * @author xiaojie
 * @date 2018/10/11
 */
public class Solution {

    @Test
    void test() {
        System.out.println(Arrays.toString(plusOne(new int[]{1, 2, 3})));
        System.out.println(Arrays.toString(plusOne(new int[]{4, 3, 2, 1})));
        System.out.println(Arrays.toString(plusOne(new int[]{1, 2, 3, 9})));
        System.out.println(Arrays.toString(plusOne(new int[]{9, 9, 9, 9})));
    }

    public int[] plusOne(int[] digits) {
        LinkedList<Integer> list = new LinkedList<>();
        int n = 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] + n == 10) {
                list.addFirst(0);
                if (i == 0) {
                    list.addFirst(1);
                }
            } else {
                list.addFirst(digits[i] + n);
                n = 0;
            }
        }
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }
}
