package com.funboy.初级.其他;

import java.util.Scanner;

/**
 * @Author: 王帆
 * @CreateTime: 2019-03-08 17:47
 * @Description: 将输入的正整数分解质因数。例如：输入90，打印出90=5*3*3*2
 */
public class 将输入的正整数分解质因数 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入一个整数 : ");
        int input = scanner.nextInt();
        StringBuilder sb = new StringBuilder();
        sb.append(input).append("=");
        boolean flag = true;
        while (flag) {
            for (int i = 2; i <= input; i++) {
                if (input % i == 0) {
                    input = input / i;
                    sb.append(i + "*");
                    break;
                }
            }
            if (input == 1) {
                flag = false;
            }
        }
        System.out.println(sb.toString().substring(0, sb.toString().length() - 1).toString());
    }

}
