import unittest
from typing import List


class MyTestCase(unittest.TestCase):
    """
    搜索插入位置

    给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。

    你可以假设数组中无重复元素
    """

    def test_something(self):
        self.assertEqual(2, self.searchInsert([1, 3, 5, 6], 5))
        self.assertEqual(1, self.searchInsert([1, 3, 5, 6], 2))
        self.assertEqual(4, self.searchInsert([1, 3, 5, 6], 7))
        self.assertEqual(0, self.searchInsert([1, 3, 5, 6], 0))

    @staticmethod
    def searchInsert2(nums: List[int], target: int) -> int:
        """
        执行用时 :64 ms, 在所有 Python3 提交中击败了25.88%的用户
        内存消耗 :13.4 MB, 在所有 Python3 提交中击败了98.71%的用户
        有些费时啊，排序数组用二分查找应该更快的
        """
        for x in nums:
            if x >= target:
                return nums.index(x)
        return len(nums)

    @staticmethod
    def searchInsert(nums: List[int], target: int) -> int:
        """
        二分法查找
        """
        length = len(nums)
        if length == 0:
            return 0
        left = 0
        right = length
        while left < right:
            mid = int((right + left) / 2)
            if nums[mid] == target:
                return mid
            if nums[mid] > target:
                right = mid
            else:
                left = mid + 1
        return left


if __name__ == '__main__':
    unittest.main()
