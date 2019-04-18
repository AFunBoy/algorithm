package com.funboy.初级.其他;

/**
 * @Author: 王帆
 * @CreateTime: 2019-03-08 17:40
 * @Description: 输出1---1000内所有能被7整除的数，每行显示6个。
 */
public class 输出能被7整除的数字 {
    public static void main(String[] args) {
        int count = 0;
        for (int i = 1; i < 1000; i++) {
            if (i % 7 == 0) {
                System.out.print(i + " ");
                count++;
            }
            if (count  == 6) {
                System.out.println();
                count = 0;
            }
        }
    }
}
