package com.xiaojie.leetcode._189;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * 旋转数组
 * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,2,3,4,5,6,7] 和 k = 3
 * 输出: [5,6,7,1,2,3,4]
 * 解释:
 * 向右旋转 1 步: [7,1,2,3,4,5,6]
 * 向右旋转 2 步: [6,7,1,2,3,4,5]
 * 向右旋转 3 步: [5,6,7,1,2,3,4]
 * 示例 2:
 * <p>
 * 输入: [-1,-100,3,99] 和 k = 2
 * 输出: [3,99,-1,-100]
 * 解释:
 * 向右旋转 1 步: [99,-1,-100,3]
 * 向右旋转 2 步: [3,99,-1,-100]
 * 说明:
 * <p>
 * 尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。
 * 要求使用空间复杂度为 O(1) 的原地算法。
 *
 * @author xiaojie
 * @date 2018/10/09
 */
public class Solution {

    @Test
    void test() {
        int[] nums = new int[]{1, 2, 3, 4, 5, 6
//        };
                , 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30};
        int k = 20;
        System.out.println(Arrays.toString(nums));
        rotate(nums, k);
//        errorRotate(nums, k);
//        rotate3(nums, k);
        System.out.println(Arrays.toString(nums));
    }

    /**
     * 方法一：
     * 把偏移位前的（0 -- nums.length - k）翻转
     * 把偏移位后的（nums.length-k -- k）翻转
     * 最后整体翻转
     */
    public void rotate(int[] nums, int k) {
        if (nums == null || k <= 0 || k % nums.length == 0) {
            return;
        }
        k %= nums.length;
        rotateArray(0, nums.length - k, nums);
        rotateArray(nums.length - k, nums.length, nums);
        rotateArray(0, nums.length, nums);
    }

    /**
     * 旋转数组
     */
    private void rotateArray(int start, int end, int[] nums) {
        for (int i = start; i < end; i++) {
            int x = nums[i];
            int j = end - 1 - i + start;
            if (i >= j) {
                return;
            }
            nums[i] = nums[j];
            nums[j] = x;
        }
    }

    /**
     * 这是我的一个错误解法
     */
    public void errorRotate(int[] nums, int k) {
        if (nums == null || k <= 0 || k % nums.length == 0) {
            return;
        }
        k %= nums.length;
        if (nums.length % k == 0) {
            for (int i = 0; i < k; i++) {
                trans(nums, k, i);
            }
        } else {
            trans(nums, k, 0);
        }
    }

    private void trans(int[] nums, int k, int i) {
        int n = i;
        int num = nums[n];
        do {
            int m = n + k;
            if (m >= nums.length) {
                m -= nums.length;
            }
            //这是要被替换的那个，要保存起来
            int num1 = nums[m];
            nums[m] = num;
            num = num1;
            n = m;
        } while (n != i);
    }

    public void rotate3(int[] nums, int k) {
        if (nums == null || k <= 0 || k % nums.length == 0) {
            return;
        }
        k %= nums.length;
        int length = nums.length;
        int start = 0;
        int i = 0;
        int cur = nums[i];

        for (int j = 0; j < length; j++) {
            // 取模找出 start 位置的元素移动后的位置
            i = (i + k) % length;
            int t = nums[i];
            // 把start位置的值赋给 移动后的位置
            nums[i] = cur;
            // 这里是上面错误解法没有想到的地方
            if (i == start) {
                ++start;
                ++i;
                cur = nums[i];
            } else {
                cur = t;
            }
        }
    }
}
