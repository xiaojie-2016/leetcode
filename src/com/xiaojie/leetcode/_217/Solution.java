package com.xiaojie.leetcode._217;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * 存在重复
 * 给定一个整数数组，判断是否存在重复元素。
 * 如果任何值在数组中出现至少两次，函数返回 true。如果数组中每个元素都不相同，则返回 false。
 * 示例 1:
 * 输入: [1,2,3,1]
 * 输出: true
 * 示例 2:
 * 输入: [1,2,3,4]
 * 输出: false
 * 示例 3:
 * 输入: [1,1,1,3,3,4,3,2,4,2]
 * 输出: true
 *
 * @author xiaojie
 * @date 2018/10/11
 */
public class Solution {

    @Test
    void test() {
        Assertions.assertTrue(containsDuplicate(new int[]{1, 2, 3, 1}));
        Assertions.assertFalse(containsDuplicate(new int[]{1, 2, 3, 4}));
        Assertions.assertTrue(containsDuplicate(new int[]{1, 1, 1, 3, 3, 4, 3, 2, 4, 2}));
        Assertions.assertTrue(containsDuplicate2(new int[]{1, 2, 3, 1}));
        Assertions.assertFalse(containsDuplicate2(new int[]{1, 2, 3, 4}));
        Assertions.assertTrue(containsDuplicate2(new int[]{1, 1, 1, 3, 3, 4, 3, 2, 4, 2}));
    }

    /**
     * 简单粗暴的方法，两层循环
     * 这个答案提交上去没过，执行时间太长了
     * 时间复杂度 O(n^2)
     * 空间复杂度 O(1)
     */
    public boolean containsDuplicate(int[] nums) {
        if (nums != null && nums.length > 1) {
            for (int i = 0; i < nums.length - 1; i++) {
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[i] == nums[j]) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /**
     * 方法二，利用哈希表
     *
     * 时间复杂度 O(n)
     * 空间复杂度 O(n)
     */
    public boolean containsDuplicate2(int[] nums) {
        if (nums != null && nums.length > 1) {
            Map<Integer,Integer> map = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                if (map.containsKey(nums[i])) {
                    return true;
                }else {
                    map.put(nums[i],i);
                }
            }
        }
        return false;
    }
}
