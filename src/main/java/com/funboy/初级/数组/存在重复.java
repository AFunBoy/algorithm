package com.funboy.初级.数组;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author: 王帆
 * @CreateTime: 2018-11-21 16:04
 * @Description: 给定一个整数数组，判断是否存在重复元素。  如果任何值在数组中出现至少两次，函数返回 true。如果数组中每个元素都不相同，则返回 false。
 * 输入: [1,2,3,1]
 * 输出: true
 * <p>
 * 输入: [1,2,3,4]
 * 输出: false
 */
public class 存在重复 {
    @Test
    public void go() {
        boolean b = containsDuplicate(new int[]{7, 6, 1, 5, 4, 1});
        System.out.println(b);
    }

    public boolean containsDuplicate(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] == nums[i]) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean containsDuplicate1(int[] nums) {

        for (int i = 1; i < nums.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] == nums[j]) {
                    return true;
                }
            }

        }
        return false;
    }
}
