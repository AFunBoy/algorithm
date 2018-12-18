package com.funboy.初级.数组;

import org.junit.Test;

import java.util.Arrays;

/**
 * @Author: 王帆
 * @CreateTime: 2018-11-16 13:59
 * @Description: 移除元素
 * 给定一个数组 nums 和一个值 val，你需要原地移除所有数值等于 val 的元素，返回移除后数组的新长度。
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 * <p>
 * 给定 nums = [0,1,2,2,3,0,4,2], val = 2,
 * 函数应该返回新的长度 5, 并且 nums 中的前五个元素为 0, 1, 3, 0, 4。
 * 注意这五个元素可为任意顺序。
 * 你不需要考虑数组中超出新长度后面的元素。
 */
public class 移除元素 {
    @Test
    public void go() {
        int[] nums = {3, 2, 2, 3};
        int i = removeElement(nums, 3);
        System.out.println("i = " + i + "  nums = " + Arrays.toString(nums));
    }

    public int removeElement(int[] nums, int val) {
        int right = nums.length - 1;
        int left = 0;
        if (nums.length == 0) {
            return 0;
        }
        for (; left <= right; ) {
            if (nums[left] == val) {
                nums[left] = nums[right];
                nums[right] = val;
                right--;
            } else {
                left++;
            }
        }
        return left;
    }
}
