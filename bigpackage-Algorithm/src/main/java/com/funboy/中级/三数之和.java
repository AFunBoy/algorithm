package com.funboy.中级;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 三数之和 {
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        //最外层 从最小的负数一直到最大的负数
        int arrLength = nums.length - 1;
        for (int i = 0; i < arrLength && nums[i] < 0; i++) {
            if (nums[i] > 0) break;
            int target = 0 - nums[i];
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            //两个滑动指针 left 和 right
            int left = i + 1;
            int right = arrLength;

            while (left < right) {
                if (nums[left] + nums[right] == target) {
                    ArrayList<Integer> objects = new ArrayList<>();
                    objects.add(nums[i]);
                    objects.add(nums[left]);
                    objects.add(nums[right]);
                    result.add(objects);
                    while (left < right && (nums[left] == nums[left + 1])) {
                        left++;
                    }
                    while (left < right && (nums[right] == nums[right - 1])) {
                        right--;
                    }
                    left++;
                    right--;
                }
                //两个指针的数字之和大于target 右指针减一
                if (nums[left] + nums[right] > target) {
                    right--;
                }
                if (nums[left] + nums[right] < target) {
                    left++;
                }


            }
        }


        return result;
    }


    private static void addResult(List<List<Integer>> result, int i, int j, int k, int[] nums) {
        ArrayList<Integer> temp = new ArrayList<>();
        temp.add(nums[i]);
        temp.add(nums[j]);
        temp.add(nums[k]);
        result.add(temp);
    }

    public static void main(String[] args) {
        int[] input = new int[]{-1, 0, 1, 1, 1, 1, 3, 3, 3, 3, 3, 32, -1, -4};
        Arrays.sort(input);
        System.out.println(Arrays.toString(input));
        List<List<Integer>> result = threeSum(input);
        System.out.println(JSONObject.toJSONString(result));
    }

}
