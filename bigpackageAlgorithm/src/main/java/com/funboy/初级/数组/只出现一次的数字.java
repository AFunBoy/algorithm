package com.funboy.初级.数组;

import org.junit.Test;

/**
 * @Author: 王帆
 * @CreateTime: 2018-11-27 10:06
 * @Description: 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 * 说明：
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 * 输入: [4,1,2,1,2]
 * 输出: 4
 */
public class 只出现一次的数字 {
    @Test
    public void go() {
        System.out.println(singleNumber(new int[]{1, 2, 1}));
    }

    public int singleNumber(int[] nums) {
        int temp;
        int index = 0;
        for (int i = 1; i < nums.length; i++) {
            boolean flag = true;
            if (nums[i] == nums[index]) {
                temp = nums[i];
                nums[i] = nums[index + 1];
                nums[index + 1] = temp;
                index++;
                index++;
                i = index;
                flag = false;
                continue;
            }
            if (i == nums.length - 1 && flag) {
                return nums[index];
            }
        }
        return nums[index];
    }
}
