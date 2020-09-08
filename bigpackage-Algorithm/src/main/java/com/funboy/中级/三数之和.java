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
            int currentMin = nums[i];
            int target = 0 - currentMin;
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
                }
                //todo 把2个if换成while true 条件是if的条件
                if (left + 1 <= arrLength && nums[left] == nums[left + 1]) {
                    left++;
                }
                if (right - 1 >= 0 && nums[right] == nums[right - 1]) {
                    right--;
                }
            }
            //左右两个数相加 再与当前最小值相加，如果等于0 记录
            //如果左右两个数相加 加上当前最小值 大于0了 右指针--
            //如果左右两个数相加 加上当前最小值 小于零  左指针++
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
        int[] input = new int[]{-1, 0, 1, 2, -1, -4};
        Arrays.sort(input);
        System.out.println(Arrays.toString(input));
        List<List<Integer>> result = threeSum(input);
        System.out.println(JSONObject.toJSONString(result));
    }

}
