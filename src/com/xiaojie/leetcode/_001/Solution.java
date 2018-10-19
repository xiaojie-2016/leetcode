package com.xiaojie.leetcode._001;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 求两数之和
 * 给定一个整数数组和一个目标值，找出数组中和为目标值的两个数。
 * <p>
 * 你可以假设每个输入只对应一种答案，且同样的元素不能被重复利用。
 * <p>
 * 示例:
 * <p>
 * 给定 nums = [2, 7, 11, 15], target = 9
 * <p>
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 *
 * @author xiaojie
 * @date 2018/10/09
 */
public class Solution {

    @Test
    void test() {
        int[] nums = new int[]{2, 7, 11, 15};
        int target = 9;
        System.out.println(Arrays.toString(twoSum(nums, target)));
        System.out.println(Arrays.toString(twoSum2(nums, target)));
        System.out.println(Arrays.toString(twoSum3(nums, target)));
    }

    /**
     * 方法一：暴力法
     * 这也是我最先想到的,执行两次循环
     * 时间复杂度 O(n^2) 数组中每个元素都需和数组内其他元素运算
     * 空间复杂度 O(1)
     */
    public int[] twoSum(int[] nums, int target) {
        if (nums != null && nums.length > 1) {
            for (int i = 0; i < nums.length - 1; i++) {
                for (int j = nums.length - 1; j > i; j--) {
                    if (nums[i] + nums[j] == target) {
                        return new int[]{i, j};
                    }
                }
            }
        }
        return null;
    }

    /**
     * 方法二，两次哈希表：
     * 为了对时间复杂度进行优化，我们使用哈希表。
     * <p>
     * 通过以空间换取速度的方式，我们可以将查找时间从 O(n)O(n) 降低到 O(1)O(1)。
     * 哈希表正是为此目的而构建的，它支持以 近似 恒定的时间进行快速查找。
     * 我用“近似”来描述，是因为一旦出现冲突，查找用时可能会退化到 O(n)O(n)。
     * 但只要你仔细地挑选哈希函数，在哈希表中进行查找的用时应当被摊销为 O(1)O(1)。
     * ——引用自 leetcode 解答
     * <p>
     * 时间复杂度 O(n)
     * 我们遍历了两次数组，使用时间是 2n
     * 空间复杂度 O(n)
     */
    public int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int key = target - nums[i];
            if (map.containsKey(key) && map.get(key) != i) {
                return new int[]{map.get(key), i};
            }
        }
        return null;
    }

    /**
     * 方法三，一次哈希表：
     * 时间复杂度 O(n)
     * 空间复杂度 O(n)
     */
    public int[] twoSum3(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int key = target - nums[i];
            if (map.containsKey(key)) {
                return new int[]{map.get(key), i};
            }
            map.put(nums[i], i);
        }
        return null;
    }
}
