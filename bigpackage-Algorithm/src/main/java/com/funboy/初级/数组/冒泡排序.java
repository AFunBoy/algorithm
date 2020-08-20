package com.funboy.初级.数组;

import java.util.Arrays;

/**
 * @ClassName 冒泡排序
 * @Description TODO
 * @Author 王帆
 * @Date 2020/8/20 9:30
 * @Version 1.0
 */
public class 冒泡排序 {
    private static int[] arr = {4, 6, 1, 7, 9, 6, 8};

    public static int[] sortArr(int[] arr) {

        if (arr.length <= 1) {
            return arr;
        }

        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        return arr;
    }


    public static void main(String[] args) {
        sortArr(arr);
        System.out.println(Arrays.toString(arr));
    }
}
