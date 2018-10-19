package com.xiaojie.leetcode._136;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * 只出现一次的数字
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 * 说明：
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 * 示例 1:
 * 输入: [2,2,1]
 * 输出: 1
 * 示例 2:
 * 输入: [4,1,2,1,2]
 * 输出: 4
 *
 * @author xiaojie
 * @date 2018/10/11
 */
public class Solution {

    @Test
    void test() throws Exception {
        Assertions.assertEquals(1, singleNumber(new int[]{2, 2, 1}));
        Assertions.assertEquals(4, singleNumber(new int[]{4, 1, 2, 1, 2}));
        Assertions.assertEquals(1, singleNumber2(new int[]{2, 2, 1}));
        Assertions.assertEquals(4, singleNumber2(new int[]{4, 1, 2, 1, 2}));
    }

    /**
     * 方法一，排序比较
     * 使用sort排好序，然后比较靠近的两个是不是相同的
     */
    public int singleNumber(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; ) {
            if (i + 1 == nums.length || nums[i] != nums[i + 1]) {
                return nums[i];
            }
            i += 2;
        }
        return -10086;
    }

    /**
     * 方法二，异或判断
     * 这是参考来的方法，每道题试用不同的方法和思路解才能锻炼良好的思维能力
     * 假设如果 A = 60，且 B = 13，现在以二进制格式表示，它们如下所示：
     * A = 0011 1100        B = 0000 1101
     * A&B = 0000 1100
     * A|B = 0011 1101
     * A^B = 0011 0001
     * ~A  = 1100 0011
     * & 两者同时为真才为真；| 两者一者为真就为真；^相同为假，不同为真
     * 所以可以从异或的特点得知，如果存在一个只出现一次的数字，那么该数组所有的元素异或结果大于0！！！
     * 经过两次异或会得到原来的值，和0异或会得到原值
     */
    public int singleNumber2(int[] nums) {
        int single = 0;
        for (int num : nums) {
            single ^= num;
        }
        return single;
    }
}
