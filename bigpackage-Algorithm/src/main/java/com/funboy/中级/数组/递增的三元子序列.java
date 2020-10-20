package com.funboy.中级.数组;

/**
 * 给定一个未排序的数组，判断这个数组中是否存在长度为 3 的递增子序列。
 * <p>
 * 数学表达式如下:
 * <p>
 * 如果存在这样的  i, j, k,    且满足  0 ≤ i < j < k ≤ n-1，
 * 使得  arr[i] < arr[j] < arr[k] ，返回 true ;  否则返回 false 。
 * 说明: 要求算法的时间复杂度为 O(n)，空间复杂度为 O(1) 。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,2,3,4,5]
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: [5,4,3,2,1]
 * 输出: false
 * <p>
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-medium/xvvuqg/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class 递增的三元子序列 {

    public boolean solution(int[] nums) {
        int temp1 = Integer.MAX_VALUE;
        int temp2 = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= temp1) {
                temp1 = nums[i];
            } else if (nums[i] <= temp2) {
                temp2 = nums[i];
            } else {
                return true;
            }
        }
        return false;

    }
}
