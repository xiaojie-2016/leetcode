package com.xiaojie.leetcode._036;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * 有效的数独
 * 判断一个 9x9 的数独是否有效。只需要根据以下规则，验证已经填入的数字是否有效即可。
 * 数字 1-9 在每一行只能出现一次。
 * 数字 1-9 在每一列只能出现一次。
 * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
 * 上图是一个部分填充的有效的数独。
 * 数独部分空格内已填入了数字，空白格用 ''.'' 表示。
 * 示例 1:
 * 输入:
 * [
 * [5,3,'.','.',7,'.','.','.','.'],
 * [6,'.','.',1,9,5,'.','.','.'],
 * ['.',9,8,'.','.','.','.',6,'.'],
 * [8,'.','.','.',6,'.','.','.',3],
 * [4,'.','.',8,'.',3,'.','.',1],
 * [7,'.','.','.',2,'.','.','.',6],
 * ['.',6,'.','.','.','.',2,8,'.'],
 * ['.','.','.',4,1,9,'.','.',5],
 * ['.','.','.','.',8,'.','.',7,9]
 * ]
 * 输出: true
 * 示例 2:
 * 输入:
 * [
 * [8,3,'.','.',7,'.','.','.','.'],
 * [6,'.','.',1,9,5,'.','.','.'],
 * ['.',9,8,'.','.','.','.',6,'.'],
 * [8,'.','.','.',6,'.','.','.',3],
 * [4,'.','.',8,'.',3,'.','.',1],
 * [7,'.','.','.',2,'.','.','.',6],
 * ['.',6,'.','.','.','.',2,8,'.'],
 * ['.','.','.',4,1,9,'.','.',5],
 * ['.','.','.','.',8,'.','.',7,9]
 * ]
 * 输出: false
 * 解释: 除了第一行的第一个数字从 5 改为 8 以外，空格内其他数字均与 示例1 相同。
 * 但由于位于左上角的 3x3 宫内有两个 8 存在, 因此这个数独是无效的。
 * 说明:
 * 一个有效的数独（部分已被填充）不一定是可解的。
 * 只需要根据以上规则，验证已经填入的数字是否有效即可。
 * 给定数独序列只包含数字 1-9 和字符 ''.'' 。
 * 给定数独永远是 9x9 形式的。
 *
 * @author xiaojie
 * @date 2018/10/11
 */
public class Solution {

    @Test
    void test() {
        char[][] board1 = new char[][]{
                new char[]{5, 3, '.', '.', 7, '.', '.', '.', '.'},
                new char[]{6, '.', '.', 1, 9, 5, '.', '.', '.'},
                new char[]{'.', 9, 8, '.', '.', '.', '.', 6, '.'},
                new char[]{8, '.', '.', '.', 6, '.', '.', '.', 3},
                new char[]{4, '.', '.', 8, '.', 3, '.', '.', 1},
                new char[]{7, '.', '.', '.', 2, '.', '.', '.', 6},
                new char[]{'.', 6, '.', '.', '.', '.', 2, 8, '.'},
                new char[]{'.', '.', '.', 4, 1, 9, '.', '.', 5},
                new char[]{'.', '.', '.', '.', 8, '.', '.', 7, 9}
        };
        Assertions.assertTrue(isValidSudoku(board1));
        char[][] board2 = new char[][]{
                new char[]{5, 3, '.', '.', 7, '.', '.', '.', '.'},
                new char[]{6, '.', '.', 1, 9, 5, '.', '.', '.'},
                new char[]{'.', 9, 8, '.', '.', '.', '.', 6, '.'},
                new char[]{8, '.', '.', '.', 6, '.', '.', '.', 3},
                new char[]{4, '.', '.', 8, '.', 3, '.', '.', 1},
                new char[]{7, '.', '.', '.', 2, '.', '.', '.', 6},
                new char[]{'.', 6, '.', '.', '.', '.', 2, 8, '.'},
                new char[]{'.', 6, '.', 4, 1, 9, '.', '.', 5},
                new char[]{'.', '.', '.', '.', 8, '.', '.', 7, 9}
        };
        Assertions.assertFalse(isValidSudoku(board2));
        char[][] board3 = new char[][]{
                new char[]{5, 3, '.', '.', 7, '.', '.', '.', 6},
                new char[]{6, '.', '.', 1, 9, 5, '.', '.', '.'},
                new char[]{'.', 9, 8, '.', '.', '.', '.', 6, '.'},
                new char[]{8, '.', '.', '.', 6, '.', '.', '.', 3},
                new char[]{4, '.', '.', 8, '.', 3, '.', '.', 1},
                new char[]{7, '.', '.', '.', 2, '.', '.', '.', 6},
                new char[]{'.', 6, '.', '.', '.', '.', 2, 8, '.'},
                new char[]{'.', '.', '.', 4, 1, 9, '.', '.', 5},
                new char[]{'.', '.', '.', '.', 8, '.', '.', 7, 9}
        };
        Assertions.assertFalse(isValidSudoku(board3));
    }

    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            Map<Integer, Character> map1 = new HashMap<>();
            Map<Integer, Character> map2 = new HashMap<>();
            Map<Integer, Character> map3 = new HashMap<>();
            for (int j = 0; j < 9; j++) {
                char value = board[i][j];
                char value2 = board[j][i];

                // 验证规则1：每行都没有重复数字
                if (value != '.' && map1.containsValue(value)) {
                    return false;
                }
                map1.put(j, value);

                // 验证规则2：每列不能有重复数字
                if (value2 != '.' && map2.containsValue(value2)) {
                    return false;
                }
                map2.put(j, value2);

                // i = 0        i = 1        i = 2
                // 00 01 02     03 04 05     06 07 08
                // 10 11 12
                // 20 21 22
                // i = 3        i = 4
                // 30 31 32     33 34 35
                // 40 41 42     43
                // 50 51 52
                // i = 0 j{0,1,2}
                // i = 1 j{0,1,2}
                // i = 2 j{0,1,2}
                // i%3  j%3 012,012,123
                int i1 = j / 3 + i / 3 * 3;
                int j1 = 3 * (i % 3) + j % 3;
                char value3 = board[i1][j1];

                // 验证规则3：九宫格内不能有重复数字
                if (value3 != '.' && map3.containsValue(value3)) {
                    return false;
                }
                map3.put(j, value3);
            }
        }
        return true;
    }
}
