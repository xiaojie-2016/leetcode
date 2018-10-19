package com.xiaojie.leetcode._350;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * 两个数组的交集 II
 * 给定两个数组，编写一个函数来计算它们的交集。
 * 示例 1:
 * 输入: nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出: [2,2]
 * 示例 2:
 * 输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出: [4,9]
 * 说明：
 * 输出结果中每个元素出现的次数，应与元素在两个数组中出现的次数一致。
 * 我们可以不考虑输出结果的顺序。
 * 进阶:
 * 如果给定的数组已经排好序呢？你将如何优化你的算法？
 * 如果 nums1 的大小比 nums2 小很多，哪种方法更优？
 * 如果 nums2 的元素存储在磁盘上，磁盘内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？
 *
 * @author xiaojie
 * @date 2018/10/11
 */
public class Solution {

    @Test
    void test() {
        System.out.println(Arrays.toString(intersect2(new int[]{1, 2, 2, 1}, new int[]{2, 2})));
        System.out.println(Arrays.toString(intersect2(new int[]{4, 9, 5}, new int[]{9, 4, 9, 8, 4})));
//        Assertions.assertArrayEquals(new int[]{2, 2}, intersect(new int[]{1, 2, 2, 1}, new int[]{2, 2}));
//        Assertions.assertArrayEquals(new int[]{4, 9}, intersect(new int[]{4, 9, 5}, new int[]{9, 4, 9, 8, 4}));
    }

    /**
     * 方法看起来笨了些。。
     */
    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> list = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums1) {
            if (map.containsKey(num)) {
                int count = map.get(num);
                count += 1;
                map.put(num, count);
            } else {
                map.put(num, 1);
            }
        }
        for (int num : nums2) {
            if (map.containsKey(num)) {
                list.add(num);
                int size = map.get(num);
                size -= 1;
                if (size == 0) {
                    map.remove(num);
                } else {
                    map.put(num, size);
                }
            }
        }
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }

    /**
     * 方法二
     * 如果两个索引所代表的数字相等，则将数字存入结果中，两个索引均自增1，如果第一个索引所代表的数字大，则第二个索引自增1，反之亦然。
     */
    public int[] intersect2(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0;
        int j = 0;
        List<Integer> list = new ArrayList<>();
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) {
                list.add(nums1[i]);
                i += 1;
                j += 1;
            } else if (nums1[i] > nums2[j]) {
                j += 1;
            } else {
                i += 1;
            }
        }
        int[] result = new int[list.size()];
        for (int k = 0; k < list.size(); k++) {
            result[k] = list.get(k);
        }
        return result;
    }
}
