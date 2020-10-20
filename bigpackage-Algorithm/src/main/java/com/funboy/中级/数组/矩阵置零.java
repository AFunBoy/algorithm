package com.funboy.中级.数组;

import java.util.Arrays;

/**
 * @ClassName 矩阵置零
 * @Description 给定一个 m x n 的矩阵，如果一个元素为 0，则将其所在行和列的所有元素都设为 0。请使用原地算法。
 * <p>
 * 输入:
 * [
 *    [1,1,1],
 *    [1,0,1],
 *    [1,1,1]
 * ]
 * 输出:
 * [
 *    [1,0,1],
 *    [0,0,0],
 *    [1,0,1]
 * ]
 * <p>
 * <p>
 * 输入:
 * [
 *    [0,1,2,0],
 *    [3,4,5,2],
 *    [1,3,1,5]
 * ]
 * 输出:
 * [
 *    [0,0,0,0],
 *    [0,4,5,0],
 *    [0,3,1,0]
 * ]
 * @Author 王帆
 * @Date 2020/9/17 9:21
 * @Version 1.0
 */
public class 矩阵置零 {

    public void setZeroes(int[][] matrix) {
        printArr(matrix);
        System.out.println("原始数组");
        boolean row1 = false;
        boolean col1 = false;
        //判断第一行和第一列有没有0
        int[] arr1 = matrix[0];
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] == 0) {
                row1 = true;
                System.out.println("第一行有0");
                break;
            }
        }

        //判断第一列有没有0
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][0] == 0) {
                col1 = true;
                System.out.println("第一列有0");
                break;
            }
        }

        //循环并设置值 把值设置到第一行第一列
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        printArr(matrix);
        System.out.println("设置到第一行和第一列结束");

        //根据第一行和第一列的值，设置对应的值
        for (int i = 1; i < matrix[0].length; i++) {
            if (matrix[0][i] == 0) {
                for (int j = 1; j < matrix.length; j++) {
                    matrix[j][i] = 0;
                }
            }
        }
        printArr(matrix);
        System.out.println("根据第一行的结果，设置第二列到最后一列");

        for (int i = 1; i < matrix.length; i++) {
            if (matrix[i][0] == 0) {
                for (int j = 1; j < matrix[i].length; j++) {
                    matrix[i][j] = 0;
                }
            }
        }
        printArr(matrix);
        System.out.println("根据第一列的结果，设置从第二行到最后一行第二个数字到最后的数字");

        if (row1) {
            for (int i = 0; i < matrix[0].length; i++) {
                matrix[0][i] = 0;
            }
            printArr(matrix);
            System.out.println("设置第一行为0结束");
        }
        if (col1) {
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][0] = 0;
            }
            printArr(matrix);
            System.out.println("设置第一列为0结束");
        }

        printArr(matrix);
        System.out.println("最终结果");
    }


    public void printArr(int[][] arr) {

        for (int i = 0; i < arr.length; i++) {
            System.out.println(Arrays.toString(arr[i]));
        }

    }


    public static void main(String[] args) {
        矩阵置零 test = new 矩阵置零();
        int[][] arr1 = {{1, 1, 1},
                {1, 0, 1},
                {1, 1, 1}};
        int[][] arr2 = {
                {0, 1, 2, 0},
                {3, 4, 5, 2},
                {1, 3, 1, 5}
        };
        test.setZeroes(arr2);
    }
}
