package com.funboy.初级.数组;

import org.junit.Test;

import java.util.Arrays;

/**
 * @Author: 王帆
 * @CreateTime: 2018-12-03 15:27
 * @Description: 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。  最高位数字存放在数组的首位， 数组中每个元素只存储一个数字。  你可以假设除了整数 0 之外，这个整数不会以零开头。
 * 输入: [1,2,3]
 * 输出: [1,2,4]
 * 解释: 输入数组表示数字 123。
 * <p>
 * 输入: [4,3,2,1]
 * 输出: [4,3,2,2]
 * 解释: 输入数组表示数字 4321。
 */

public class 加一 {
    @Test
    public  void go() {
//        int[] ints = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
//        int[] ints1 = plusOne(ints);
//        System.out.println(Arrays.toString(ints1));


    }

    public int[] plusOne(int[] digits) {
        Long aLong = Long.valueOf(Arrays.toString(digits).substring(1, Arrays.toString(digits).length() - 1).replace(",", "").replace(" ", ""));
        aLong += 1;
        char[] chars = aLong.toString().toCharArray();
        int[] ints = new int[chars.length];
        for (int j = 0; j < chars.length; j++) {
            ints[j] = Integer.valueOf(String.valueOf(chars[j]));
        }
        return ints;
    }

}
