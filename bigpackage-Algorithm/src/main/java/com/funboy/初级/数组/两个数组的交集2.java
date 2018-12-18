package com.funboy.初级.数组;

import org.junit.Test;

import java.util.Arrays;

/**
 * @Author: 王帆
 * @CreateTime: 2018-11-27 14:37
 * @Description: 给定两个数组，编写一个函数来计算它们的交集。
 * <p>
 * 输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出: [4,9]
 * 输入: nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出: [2,2]
 */
public class 两个数组的交集2 {
    public int[] intersect(int[] nums1, int[] nums2) {
        int index = 0;
        int temp;
        for (int i = index; i < nums1.length; i++) {
            for (int j = index; j < nums2.length; j++) {
                if (index >= nums1.length || index >= nums2.length) {
                    return Arrays.copyOf(nums1, index);
                }
                //如果元素一样,把这个元素放在最前面 index++最后返回0-index个
                if (nums1[i] == nums2[j]) {
                    temp = nums1[i];
                    nums1[i] = nums1[index];
                    nums1[index] = temp;

                    temp = nums2[j];
                    nums2[j] = nums2[index];
                    nums2[index] = temp;

                    index++;
                    break;
                }
            }
        }
        return Arrays.copyOf(nums1, index);
    }

    @Test
    public void go() {
        int[] a = {1, 2, 2, 3, 4, 5, 6, 7};
        int[] b = {1, 9, 9, 2, 9, 9, 9, 2, 3, 4, 5};
        long l = System.currentTimeMillis();
        intersect(a, b);
        long l2 = System.currentTimeMillis();
        System.out.println(l2-l);
    }
}
