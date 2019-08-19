import unittest


class MyTestCase(unittest.TestCase):
    """
    有效的括号

    给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。

    有效字符串需满足：

    左括号必须用相同类型的右括号闭合。
    左括号必须以正确的顺序闭合。
    注意空字符串可被认为是有效字符串。

    来源：力扣（LeetCode）
    链接：https://leetcode-cn.com/problems/valid-parentheses
    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
    """

    def test_something(self):
        self.assertTrue(self.isValid('()'))
        self.assertTrue(self.isValid('()[]{}'))
        self.assertFalse(self.isValid('(]'))
        self.assertTrue(self.isValid('{[]}'))
        self.assertTrue(self.isValid(''))

    @staticmethod
    def isValid(s: str) -> bool:
        if s is None:
            return False
        length = len(s)
        left = {'(': 0, '[': 1, '{': 2}
        left_value = []
        right = {')': 0, ']': 1, '}': 2}
        if length % 2 != 0:
            return False
        for x in s:
            if x in left.keys():
                left_value.append(left[x])
            elif x in right.keys():
                try:
                    if left_value.pop() != right[x]:
                        return False
                except IndexError:
                    return False
        return len(left_value) == 0


if __name__ == '__main__':
    unittest.main()
