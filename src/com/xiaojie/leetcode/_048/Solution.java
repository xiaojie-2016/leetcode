package com.xiaojie.leetcode._048;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * 旋转图像
 * 给定一个 n × n 的二维矩阵表示一个图像。
 * 将图像顺时针旋转 90 度。
 * 说明：
 * 你必须在原地旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要使用另一个矩阵来旋转图像。
 * <p>
 * 示例 1:
 * 给定 matrix =
 * [
 * [1,2,3],
 * [4,5,6],
 * [7,8,9]
 * ],
 * 原地旋转输入矩阵，使其变为:
 * [
 * [7,4,1],
 * [8,5,2],
 * [9,6,3]
 * ]
 * 示例 2:
 * 给定 matrix =
 * [
 * [ 5, 1, 9,11],
 * [ 2, 4, 8,10],
 * [13, 3, 6, 7],
 * [15,14,12,16]
 * ],
 * 原地旋转输入矩阵，使其变为:
 * [
 * [15,13, 2, 5],
 * [14, 3, 4, 1],
 * [12, 6, 8, 9],
 * [16, 7,10,11]
 * ]
 *
 * @author xiaojie
 * @date 2018/10/11
 */
public class Solution {

    @Test
    void test() {
//        int[][] matrix = new int[][]{
//                new int[]{5, 1, 9, 11},
//                new int[]{2, 4, 8, 10},
//                new int[]{13, 3, 6, 7},
//                new int[]{15, 14, 12, 16}
//        };
        int[][] matrix = new int[][]{
                new int[]{5, 1, 9, 11, 7},
                new int[]{2, 4, 8, 10, 9},
                new int[]{13, 3, 6, 7, 12},
                new int[]{15, 14, 12, 16, 15},
                new int[]{6, 5, 8, 77, 52}
        };
        for (int i = 0; i < matrix.length; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }
        rotate(matrix);
        for (int i = 0; i < matrix.length; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }
    }

    /**
     * [1,2,3],
     * [4,5,6],
     * [7,8,9]
     * <p>
     * [7,4,1],
     * [8,5,2],
     * [9,6,3]
     * <p>
     * [ 5, 1, 9,11],
     * [ 2, 4, 8,10],
     * [13, 3, 6, 7],
     * [15,14,12,16]
     * ],
     * 原地旋转输入矩阵，使其变为:
     * [
     * [15,13, 2, 5],
     * [14, 3, 4, 1],
     * [12, 6, 8, 9],
     * [16, 7,10,11]
     */
    public void rotate(int[][] matrix) {
        if (matrix.length>=2){
            for (int i = 0; i < matrix.length / 2; i++) {
                int jLength = matrix.length - i - 1;
                for (int j = i; j < jLength; j++) {
                    int num = matrix[i][j];
                    matrix[i][j] = matrix[jLength - j + i][i];//15->5
                    matrix[jLength - j + i][i] = matrix[jLength][jLength - j + i];//16->15
                    matrix[jLength][jLength - j + i] = matrix[j][jLength];//11->16
                    matrix[j][jLength] = num;
                }
            }
        }
    }
}
