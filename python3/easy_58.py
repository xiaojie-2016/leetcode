import unittest


class MyTestCase(unittest.TestCase):
    """
    58. 最后一个单词的长度

    给定一个仅包含大小写字母和空格 ' ' 的字符串，返回其最后一个单词的长度。

    如果不存在最后一个单词，请返回 0 。

    说明：一个单词是指由字母组成，但不包含任何空格的字符串。

    示例:

    输入: "Hello World"
    输出: 5

    来源：力扣（LeetCode）
    链接：https://leetcode-cn.com/problems/length-of-last-word
    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
    """

    def test_something(self):
        self.assertEqual(self.lengthOfLastWord('Hello World a '), 1)
        self.assertEqual(self.lengthOfLastWord2('Hello World a '), 1)
        self.assertEqual(self.lengthOfLastWord3('Hello World a '), 1)

    @staticmethod
    def lengthOfLastWord(s: str) -> int:
        """
        执行用时 :52 ms, 在所有 Python3 提交中击败了65.66%的用户
        内存消耗 :13.4 MB, 在所有 Python3 提交中击败了5.52%的用户
        :param s:
        :return:
        """
        if s.isspace():
            return 0
        num = 0
        sum = 0
        for a in s:
            if a == ' ':
                num = 0
            else:
                num += 1
                sum = num
        return sum

    def lengthOfLastWord2(self, s: str) -> int:
        """
        执行用时 :48 ms, 在所有 Python3 提交中击败了80.66%的用户
        内存消耗 :13.2 MB, 在所有 Python3 提交中击败了51.91%的用户
        :param s:
        :return:
        """
        arr = s.split(' ')
        num = 0
        for str in arr:
            if len(str) > 0:
                num = len(str)
        return num

    def lengthOfLastWord3(self, s: str) -> int:
        """
        执行用时 :32 ms, 在所有 Python3 提交中击败了99.77%的用户
        内存消耗 :13.2 MB, 在所有 Python3 提交中击败了72.22%的用户
        :param s:
        :return:
        """
        arr = s.split(' ')
        for str in reversed(arr):
            if len(str) > 0:
                return len(str)
        return 0

    def lengthOfLastWord4(self, s: str) -> int:
        try:
            s = s.rstrip()
            ind = s.rindex(' ')
            return len(s) - ind - 1
        except ValueError:
            return len(s)


if __name__ == '__main__':
    unittest.main()
