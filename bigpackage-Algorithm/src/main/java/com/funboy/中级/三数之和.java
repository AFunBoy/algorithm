package com.funboy.中级;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 三数之和 {
    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        int i = 0;
        int j = nums.length - 1;
        for (; i < nums.length - 1 && i < j; i++) {
            //当前的最小值已经大于0 直接return
            if (nums[i] > 0) {
                return result;
            }
            //当前首尾之和
            int sum = nums[i] + nums[j];
            for (int k = i + 1; k < j; k++) {
                //首尾之和>0 大数指针-1 跳出内层循环 外层+1
                int tempSum = sum + nums[k];
                if (tempSum > 0) {
                    j--;
                    break;
                } else {
                    //首尾之和小于0
                    if (tempSum + nums[k] < 0) {
                        continue;
                    } else if (tempSum + nums[k] == 0) {
                        ArrayList<Integer> temp = new ArrayList<>();
                        temp.add(nums[i]);
                        temp.add(nums[j]);
                        temp.add(nums[k]);
                        result.add(temp);
                        break;
                    } else {
                        break;
                    }
                }

            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] input = new int[]{-1, 0, 1, 2, -1, -4};
        List<List<Integer>> result = threeSum(input);
        System.out.println(JSONObject.toJSONString(result));
    }

}
