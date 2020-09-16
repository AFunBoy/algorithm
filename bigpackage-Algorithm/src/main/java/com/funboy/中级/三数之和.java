package com.funboy.中级;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 三数之和：
 * 1.排序，获取最小值，如果最小值大于零，直接braek，如果最小值和上一个值相同，continue,进入下一循环，i++
 * 2.获取当前最小值的情况下，和目标值的差值target
 * 3.计算当前左指针和右指针的和与target的值进行比较，如果相等，记录当前值，左指针比较下一个值和当前左指针的值是否相等，如果相等，左指针指到和当前值相等的最右一个值，右指针同理，指向当前值最左的这个值，比如 有2,2,2,2，那么左指针从第一个2指向最后一个2，右指针同理
 * 4.左右指针自增\自减，如果左指针小于右指针，进行上述循环
 * 5.如果左右指针的和大于target，右指针自减
 * 6.如果左右指针的和小于target，左指针自增
 */
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
                    addResult(result, i, left, right,nums);
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
