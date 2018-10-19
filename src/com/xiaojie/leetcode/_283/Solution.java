package com.xiaojie.leetcode._283;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * 移动零
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * 示例:
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * 说明:
 * 必须在原数组上操作，不能拷贝额外的数组。
 * 尽量减少操作次数。
 *
 * @author xiaojie
 * @date 2018/10/11
 */
public class Solution {

    @Test
    void test() {
        int[] nums = new int[]{0, 1, 0, 3, 12};
        moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
        int[] nums2 = new int[]{0, 0, 1, 0, 3, 0, 0, 12};
        moveZeroes(nums2);
        System.out.println(Arrays.toString(nums2));
    }

    /**
     * 方法一：
     * 这个解法的思维是每次都找一个非 0 的数挨个往后排
     * 直到后面的数全部是 0 为止，我看了一下网上其他解法，这个应该是效率很高的那个了
     * 时间复杂度 O(n) for/where 两个循环加起来最多执行 length-1 次
     */
    public void moveZeroes(int[] nums) {
        if (nums != null && nums.length > 1) {
            int j = 1;
            for (int i = 0; i < nums.length - 1; i++) {
                // 1.这个循环每次都会确定一个非 0 的数
                if (nums[i] == 0) {
                    // 2.如果是 0 那就挨个往后找，找到后面第一个不是 0 的拿过来
                    while (nums[j] == 0) {
                        j += 1;
                        // 4.这步操作就是如果发现后面全是 0 了，循环就不必继续了
                        if (j == nums.length) {
                            return;
                        }
                    }
                    // 3.拿到非 0 的换到这个位置
                    nums[i] = nums[j];
                    nums[j] = 0;
                }
            }
        }
    }
}
