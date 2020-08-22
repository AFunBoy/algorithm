package com.funboy.中级;

import java.util.List;

public class 三数之和 {
    public List<List<Integer>> threeSum(int[] nums) {
        nums = sort(nums);
        return null;
    }

    public int[] sort(int[] sums) {
        for (int i = 0; i < sums.length - 1; i++) {
            for (int j = 0; j < sums.length - 1 - i; j++) {
                if (sums[j] > sums[j + 1]) {
                    int temp = sums[j];
                    sums[j] = sums[j + 1];
                    sums[j + 1] = temp;
                }
            }
        }
        return sums;
    }
}
