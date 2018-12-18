package com.funboy.初级.数组;

import org.junit.Test;

import java.util.Arrays;

public class 旋转数组 {

    @Test
    public void go() {
        rotate(new int[]{1, 2, 3, 4, 5, 6, 7}, 3);
    }

    public void rotate(int[] nums, int k) {
        int len = nums.length;
        k = k % len;
        if (k == 0) {
            return;
        }

        //1、翻转前n-k个数字
        reverse(nums, 0, len - k - 1);
        //2、翻转后k个数字
        //  reverse(nums, len - k, len - 1);
        //3、翻转整个数组
        reverse(nums, 0, len - 1);
    }

    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[end];
            nums[end] = nums[start];
            nums[start] = temp;
            start++;
            end--;
        }
        System.out.println(Arrays.toString(nums));
    }
}