package com.funboy.中级;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 三数之和 {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        int i = 0;
        int j = nums.length;
        for (; i < nums.length && i < j; i++) {
            for (int k = i + 1; k < j; k++) {
                if (i >= 0) {
                    return result;
                }
                int sum = nums[i] + nums[j];
                if (sum + nums[k] > 0) {
                    return result;
                }
                if (sum + nums[k] == 0) {
                    ArrayList<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[j]);
                    temp.add(nums[k]);
                    result.add(temp);
                }
            }
        }

        return result;
    }


}
